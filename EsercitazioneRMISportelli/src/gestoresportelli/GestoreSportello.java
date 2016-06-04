package gestoresportelli;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class GestoreSportello {

	public static void main(String[] args) {
		IGestoreSportello gestore=new GestoreSportelloImpl();
		try {
			Registry remote=LocateRegistry.getRegistry(2000);
			IGestoreSportello stub=(IGestoreSportello) UnicastRemoteObject.exportObject(gestore,0);
			remote.rebind("gestore", gestore);
			System.out.println("GESTORE registrato = "+stub.toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
