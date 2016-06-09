package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import broker.IBroker;

public class Client {

	public static void main(String[] args) {
		for(int i=0;i<5;i++)
		new Thread(){
			public void run(){
				Registry remote;
				try {
					remote = LocateRegistry.getRegistry(2000);
					IBroker broker=(IBroker) remote.lookup("broker");
					for(int i=0;i<25;i++){
						//Thread.sleep((long) (Math.random()*1000+2000));
						broker.sottoponi((i%2+1), (int) (Math.random()*4+1));
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}.start();

	}

}
