package subscribe;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Sottoscrittore extends UnicastRemoteObject implements ISottoscrittore{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6353898938051827955L;

	protected Sottoscrittore() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onMessage(String msg) throws RemoteException{
		System.out.println("Sono:"+Thread.currentThread().getName()+" Ho ricevuto:"+msg);
	}

}
