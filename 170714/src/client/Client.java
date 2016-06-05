package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import gestore.IGestore;

public class Client {

	public static void main(String[] args) {
		for(int i=0;i<10;i++)
		new Thread(){
			public void run(){			
				try {
					Registry registry=LocateRegistry.getRegistry(2000);
					IGestore gest=(IGestore) registry.lookup("gestore");
					for(int j=0;j<5;j++){
						Thread.sleep((long) (Math.random()*2000+1000));
						gest.richiestaDeposito((int) (Math.random()*100));
					}
				} catch (RemoteException | NotBoundException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();

	}

}
