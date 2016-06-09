package broker;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBroker extends Remote {
	public void sottoponi(int tipo,int quantità) throws RemoteException;
	public void sottoscrivi(int porto) throws RemoteException;

}
