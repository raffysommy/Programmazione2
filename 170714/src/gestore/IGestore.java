package gestore;

import java.rmi.Remote;
import java.rmi.RemoteException;

import deposito.IDeposito;

public interface IGestore extends Remote {
	public void sottoscrivi(IDeposito d) throws RemoteException;
	public void richiestaDeposito(int idArticolo) throws RemoteException;
}
