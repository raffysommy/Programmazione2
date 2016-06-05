package observer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import whiteboard.IWhiteBoard;
import whiteboard.WhiteBoardImpl;

public class ObserverMain {

	public static void main(String[] args) {
		try {
			Registry remote=LocateRegistry.getRegistry(2000);
			IWhiteBoard lavagnaremote=(IWhiteBoard) remote.lookup("lavagna");
			IObserver obs=new ObserverImpl(lavagnaremote);
			obs.attachObserver();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
