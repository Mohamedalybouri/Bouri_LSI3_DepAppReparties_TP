package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConversionImpl extends UnicastRemoteObject implements IConversion {
	//public si la classe ConversionServer existe ailleur de package
	public ConversionImpl() throws RemoteException {
		super();
	}

	@Override
	public double convertirMontant(double mt) {
		return mt*3.3;
	}

}
