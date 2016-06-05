package observer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import whiteboard.IShape;
import whiteboard.IWhiteBoard;

public class ObserverImpl extends UnicastRemoteObject implements IObserver {
	private IWhiteBoard whiteboard;
	
	@Override
	public boolean CallBack() throws RemoteException {
			Vector<IShape> forme = whiteboard.getForme();
			for(int i=0;i<forme.size();i++)
				forme.get(i).Draw();
			return true;
	}

	public ObserverImpl(IWhiteBoard whiteboard) throws RemoteException {
		super();
		this.whiteboard = whiteboard;
	}
	public void attachObserver() throws RemoteException{
		this.whiteboard.Subscribe(this);
	}

}
