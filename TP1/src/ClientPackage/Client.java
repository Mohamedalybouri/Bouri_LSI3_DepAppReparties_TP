package ClientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		//la première étape
		//TODO
		System.out.println("Je suis un client pas encore connecté...");
		//TODO
		Socket socket = new Socket("localhost", 1234);
		System.out.println("Je suis un client connecté");
		//Le client taper un entier
		System.out.println("Donner un entier");
		Scanner sc=new Scanner(System.in);
		int x= sc.nextInt();
		OutputStream os = socket.getOutputStream(); 
		//envoie caractere par caractere
		PrintWriter pw = new PrintWriter(os, true);
		String ch=Integer.toString(x);
		pw.println(ch);
		//Le client choisi l'operation
		System.out.println("Choisi L'operation:");
		System.out.println("+: L'addition");
		System.out.println("-: Soustraction");
		System.out.println("*:Multiplication");
		System.out.println("/: division");
		Scanner sc1=new Scanner(System.in);
		String op = sc1.next();
		OutputStream os1 = socket.getOutputStream();
		PrintWriter pw1 = new PrintWriter(os, true);
		pw.println(op);
		//os1.write(ch);
		// le client choisi autre entier
		System.out.println("Donner un autre entier");
		Scanner sc2=new Scanner(System.in);
		int x1= sc2.nextInt();
		OutputStream os2 = socket.getOutputStream(); 
		//os2.write(x1);
		PrintWriter pw2 = new PrintWriter(os, true);
		String ch2=Integer.toString(x1);
		pw.println(ch2);
		//Resultat de serveur
		InputStream is = socket.getInputStream();
		int nb=is.read();
		System.out.println(nb);
		//La dernière étape : Fermer socket
		//TODO
		socket.close();

	}

}
