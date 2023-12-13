package ServerPackage;
import java.io.*;
import java.net.*;
public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//première étape
		//TODO
		ServerSocket socketServeur = new ServerSocket(1234);
		System.out.println("Je suis un serveur en attente la connexion d'un client");
		//la deuxième étape	
		Socket socket = socketServeur.accept();
		System.out.println("un client est connecté");

		InputStream is = socket.getInputStream();
		InputStreamReader isr= new InputStreamReader(is); 
		BufferedReader br = new BufferedReader(isr); 
		String s= br.readLine();
		int nb= Integer.parseInt(s);
		
		InputStream is1 = socket.getInputStream();
		InputStreamReader isr1= new InputStreamReader(is1); 
		BufferedReader br1 = new BufferedReader(isr1); 
		String s1= br1.readLine();
		
		InputStream is2 = socket.getInputStream();
		InputStreamReader isr2= new InputStreamReader(is2); 
		BufferedReader br2 = new BufferedReader(isr2); 
		String s2= br2.readLine();
		int nb2= Integer.parseInt(s2);

		int x = 0;
		switch(s1)
		{
			case "+":  x=nb+nb2; break;
			case "-":  x=nb-nb2; break;
			case "*":  x=nb*nb2; break;
			case "/":  x=nb/nb2; break;
		}
		//Le serveur envoie le résultat au client
		OutputStream os =socket.getOutputStream(); 
		os.write(x);
		// la dérinère étape: fermer socket
		socket.close();
	}
}
