package Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import compute.Compute;

public class ComputeClient {
	public static void main(String[] args){
		try {
			Registry remote=LocateRegistry.getRegistry(2000);
			Compute c=(Compute)remote.lookup("compute");
			System.out.println(c.somma(2, 3));
			System.out.println(c.esegui(new Moltiplicazione(3,5)));
			System.out.println(c.esegui(new Media(3,5)));
			System.out.println(c.esegui(new Divisione(3,0)));
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
