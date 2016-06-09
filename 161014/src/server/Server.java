package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

	public static void main(String[] args) {
		try {
			Registry remote=LocateRegistry.getRegistry(2000);
			IGestore gestore=new Gestore();
			IGestore geststub=(IGestore) UnicastRemoteObject.exportObject(gestore, 0);
			remote.rebind("gestore", geststub);
			System.out.println(geststub.toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
