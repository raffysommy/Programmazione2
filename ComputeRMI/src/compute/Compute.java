package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote{
	public int somma(int a,int b) throws RemoteException;
	public int esegui(Operation o) throws RemoteException;
}
