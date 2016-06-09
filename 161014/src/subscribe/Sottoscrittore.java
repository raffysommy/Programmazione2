package subscribe;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Sottoscrittore extends UnicastRemoteObject implements ISottoscrittore{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6353898938051827955L;
	private MessageListner listner;

	protected Sottoscrittore() throws RemoteException {
		super();
		this.listner=new MessageListner();
	}

	public IListner getListner() throws RemoteException{
		return this.listner;
	}

}
