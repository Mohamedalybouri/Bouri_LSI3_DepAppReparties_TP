package ServerPackage;
import java.io.*;
import java.net.*;

import ClientPackage.Dep;
public class Server {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		try {
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("Je suis un serveur en attende la connexion d'un client");
		
			Socket s = ss.accept();
			System.out.println("un client est connecte");

			
			/*InputStream is = s.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			Dep d = (Dep)ois.readObject();*/
			
			
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			InputStream is = s.getInputStream();
			InputStreamReader isr= new InputStreamReader(is); 
			BufferedReader br = new BufferedReader(isr);
			
			int p1 = Integer.parseInt(br.readLine());
			
			String p2 = br.readLine();
			
			int p3 = Integer.parseInt(br.readLine());
			
			float nb=0;
			
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
			out.println(nb);
			
			/*int p1 = Integer.parseInt(d.getop1());
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
			
			d.setRes(nb);
			OutputStream os = s.getOutputStream();
			OutputStream ooos = new ObjectOutputStream(os);
			((ObjectOutputStream) ooos).writeObject(d);*/
			 
			
			s.close();

	}catch(IOException e) {
		System.out.println(e.getMessage());
		}
	}

}

