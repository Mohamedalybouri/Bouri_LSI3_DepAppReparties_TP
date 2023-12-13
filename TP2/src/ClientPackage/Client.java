package ClientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		

		System.out.println("Je suis un client pas encore connecte...");

		Socket s = new Socket("127.0.0.1", 1234);
		
		System.out.println("Je suis connecté");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner le premier nombre ");
		String x = sc.next();
	
		System.out.println("Donner l'operateur ");
		String x2 = sc.next();
		
		System.out.println("Donner le deuxieme nombre ");
		String x3 = sc.next();
		
		Dep d = new Dep(x,x3,x2);
		
		/*OutputStream os = s.getOutputStream(); 
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(d);*/
		
		OutputStream os = s.getOutputStream(); 
		PrintWriter pw = new PrintWriter(os, true);
		pw.println(x);
		
		OutputStream os2 = s.getOutputStream(); 
		PrintWriter pw2 = new PrintWriter(os2, true);
		pw2.println(x2);
		
		OutputStream os3 = s.getOutputStream(); 
		PrintWriter pw3 = new PrintWriter(os3, true);
		pw3.println(x3);
		
		InputStream is = s.getInputStream();
		InputStreamReader isr= new InputStreamReader(is); 
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("The result is :"+br.readLine());
        //System.out.println("Resultat : "+d.getRes());
        
		/*InputStream is = s.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		Dep d2 = (Dep)ois.readObject();
		System.out.println("The result is : "+d2.getRes());*/
		
		s.close();

	}
}
