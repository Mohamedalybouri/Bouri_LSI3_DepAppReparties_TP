package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
	public static void main(String [] args) throws UnknownHostException, IOException, ClassNotFoundException{
		InetAddress serverAddress = InetAddress.getByName("192.168.1.13");
        InetSocketAddress serverSocketAddr = new InetSocketAddress(serverAddress, 1234);
		System.out.println("Je suis un client pas encore connecte...");

		Socket s = new Socket();
		s.connect(serverSocketAddr);
		System.out.println("Je suis connecté");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner le premier nombre ");
		String x = sc.next();
	
		System.out.println("Donner l'operateur ");
		String x2 = sc.next();
		
		System.out.println("Donner le deuxieme nombre ");
		String x3 = sc.next();
		
		Operation d = new Operation(x,x3,x2);
		
		OutputStream os = s.getOutputStream(); 
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(d);
		        
		InputStream is = s.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		Operation d2 = (Operation)ois.readObject();
		System.out.println("The result is : "+d2.getRes());
		
		s.close();
	}
}
