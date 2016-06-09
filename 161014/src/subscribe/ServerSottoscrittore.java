package subscribe;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.IGestore;

public class ServerSottoscrittore {

	public static void main(String[] args) {
		try {
			Registry remote=LocateRegistry.getRegistry(2000);
			IGestore gestore=(IGestore) remote.lookup("gestore");
			gestore.subscribe("/data/temperature", new Sottoscrittore());
			gestore.subscribe("/data/humidity", new Sottoscrittore());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
