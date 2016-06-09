package subscribe;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISottoscrittore extends Remote{
	public IListner getListner() throws RemoteException;
}
