package server;

import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import compute.Compute;

public class ComputeServer {
	public static void main(String[] args){
		Compute servizio=new ComputeImpl();
		Compute serviziostub=null;
		try {
			serviziostub=(Compute)UnicastRemoteObject.exportObject(servizio, 0);
			System.out.println("Servizio:"+servizio.toString());
			System.out.println("Serviziostub:"+serviziostub.toString());
			Registry remote=LocateRegistry.getRegistry(2000);
			remote.rebind("compute",serviziostub);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
