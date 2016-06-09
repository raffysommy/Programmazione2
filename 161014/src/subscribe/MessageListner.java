package subscribe;

import java.rmi.RemoteException;

public class MessageListner extends java.rmi.server.UnicastRemoteObject implements IListner{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4110197533950096866L;
	protected MessageListner() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public void onMessage(String msg) throws RemoteException{
		System.out.println("Sono:"+Thread.currentThread().getName()+" Ho ricevuto:"+msg);
	}

}
