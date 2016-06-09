package subscribe;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISottoscrittore extends Remote{
	public void onMessage(String msg) throws RemoteException;
}
