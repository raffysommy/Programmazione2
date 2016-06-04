package client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import gestoresportelli.IGestoreSportello;

public class Client {
	public static void main(String args[]){
		try {
			Registry remote = LocateRegistry.getRegistry(2000);
			for(int j=0;j<10;j++)
				new Thread(){
					public void run(){
							try {
								IGestoreSportello gestore=(IGestoreSportello) remote.lookup("gestore");
								for(int i=0;i<10;i++){
									String risultato=gestore.sottoponiRichiesta((int) (Math.random()*100))?"accettata":"scartata";
									System.out.println("Thread:"+Thread.currentThread().getName()+" Richiesta "+risultato);
									Thread.sleep((long) (Math.random()*2+1));
								}
							} catch (AccessException e) {
							// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (NotBoundException e) {
							// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}.start();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
