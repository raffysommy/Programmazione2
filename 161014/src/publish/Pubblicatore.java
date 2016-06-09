package publish;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.IGestore;

public class Pubblicatore {

	public static void main(String[] args) {
		String topic=new String(args[0]).trim();
		String msg=new String(args[1]).trim();
		try {
			Registry remote=LocateRegistry.getRegistry(2000);
			IGestore gestore=(IGestore) remote.lookup("gestore");
			gestore.publish(topic, msg);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
