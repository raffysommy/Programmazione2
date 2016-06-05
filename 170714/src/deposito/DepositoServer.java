package deposito;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import gestore.IGestore;

public class DepositoServer {
	public static void main(String[] args) {
		for(int i=0;i<3;i++)
		new Thread(){
			public void run(){
				int port=(int) (Math.random()*32300+30000);
				Skeleton skeleton=new DepositoSkeleton(port);
				IDeposito proxy=new Stub(port);
				try{
					Registry remote=LocateRegistry.getRegistry(2000);
					IGestore gest=(IGestore) remote.lookup("gestore");
					gest.sottoscrivi(proxy);
					skeleton.run();
				} catch(RemoteException | NotBoundException e){
					e.printStackTrace();
				}
			}
		}.start();
				
	}
}
