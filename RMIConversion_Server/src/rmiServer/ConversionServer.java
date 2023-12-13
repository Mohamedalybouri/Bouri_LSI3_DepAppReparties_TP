package rmiServer;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmiService.ConversionImpl;

public class ConversionServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			LocateRegistry.createRegistry(1099);
			ConversionImpl od = new ConversionImpl();
			System.out.println(od.toString());
			//publier la reference de l'objet distant
			Naming.rebind("rmi://localhost:1099/OD", od);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
