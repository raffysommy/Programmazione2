package gestore;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class GestoreServer {

	public static void main(String[] args) {
		try {
			Registry remote = LocateRegistry.getRegistry(2000);
			IGestore gest=new GestoreImpl();
			IGestore stub=(IGestore) UnicastRemoteObject.exportObject(gest,0);
			System.out.println(stub);
			remote.rebind("gestore", stub);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
