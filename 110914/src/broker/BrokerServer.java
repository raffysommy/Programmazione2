package broker;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class BrokerServer {

	public static void main(String[] args) {
		
		try {
			Registry remote = LocateRegistry.getRegistry(2000);
			IBroker broker=new BrokerImpl();
			IBroker stub=(IBroker) UnicastRemoteObject.exportObject(broker, 0);	
			remote.rebind("broker", stub);
			System.out.println(stub);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
