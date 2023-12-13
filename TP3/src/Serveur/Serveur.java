package Serveur;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Client.Operation;

public class Serveur {
	public static void main(String [] args) throws IOException {
		ServerSocket socketServeur = new ServerSocket(1234);
		System.out.println("Le serveur attend la connexion d'un client ");
		while(true){
			try {
				Socket socket = socketServeur.accept();
				System.out.println("un client est connecte "+ socket.getRemoteSocketAddress());
				ClientProcess client = new ClientProcess(socket);
				client.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			}
	}
}
class ClientProcess extends Thread {
	private Socket socket;
	private static int nb=0;
	// Constructeur
	public ClientProcess(Socket socket){
		super();
		this.socket = socket;
	}
	// La troisième étape : le client effectue son traitement
	public void run() {
		nb++;
		System.out.println("Le client "+nb+" est connecte !");
		try {
		// La dernière étape : fermeture de la socket
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			Operation d = (Operation)ois.readObject();
						
			int p1 = Integer.parseInt(d.getop1());
			String p2 = d.getop();
			int p3 = Integer.parseInt(d.getop2());
			
			int nb=0;
			
			switch(p2) {
				case "+": nb = p1+p3;
						break;
				case "-": nb = p1-p3;
						break;
				case "*": nb = p1*p3;
						break;
				case "/": nb = p1/p3;
						break;
			}
			System.out.println(nb);
			d.setRes(nb);
			OutputStream os = socket.getOutputStream();
			OutputStream ooos = new ObjectOutputStream(os);
			((ObjectOutputStream) ooos).writeObject(d);
			socket.close();
		}
		catch (IOException e)
		{e.printStackTrace();} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}