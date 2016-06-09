package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import subscribe.ISottoscrittore;

public interface IGestore extends Remote{
	public boolean publish(String topic,String msg)throws RemoteException;
	public void subscribe(String topic,ISottoscrittore sottoscrittore)throws RemoteException;
}
