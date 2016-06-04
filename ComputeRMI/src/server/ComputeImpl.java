package server;

import java.rmi.RemoteException;

import compute.Compute;
import compute.Operation;

public class ComputeImpl implements Compute {

	@Override
	public int somma(int a, int b) throws RemoteException {
		System.out.println("Compute:"+Thread.currentThread().getName()+"somma di:"+ a +" e "+b);
		return a+b;
	}

	@Override
	public int esegui(Operation o) throws RemoteException {
		System.out.println("Compute:"+Thread.currentThread().getName()+"Operazione");
		return o.calcola();
	}

}
