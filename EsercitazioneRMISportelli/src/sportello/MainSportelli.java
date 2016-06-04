package sportello;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import gestoresportelli.IGestoreSportello;

public class MainSportelli {

public static void main(String[] args) {	
		try {
			ISportello s=new SportelloImpl();
			Registry remote=LocateRegistry.getRegistry(2000);
			//ISportello sstub=(ISportello) UnicastRemoteObject.exportObject(s, 0);
			IGestoreSportello i=(IGestoreSportello) remote.lookup("gestore");
			i.sottoscrivi(s);
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
