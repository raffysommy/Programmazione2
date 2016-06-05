package gestore;

import java.rmi.RemoteException;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

import deposito.IDeposito;

public class GestoreImpl implements IGestore {
	Vector<IDeposito> depositi;
	int counter=0;
	@Override
	public void sottoscrivi(IDeposito d) throws RemoteException {
		System.out.println("Deposito "+d.toString()+" Sottoscritto");
		depositi.addElement(d);

	}

	@Override
	public void richiestaDeposito(int idArticolo) throws RemoteException {
		int value=0;
		synchronized(this){
			value=counter=++counter%depositi.size();
		}
		boolean status=depositi.get(value).deposita(idArticolo);
		System.out.println("Ho depositato:"+idArticolo+" Nel Deposito:"+counter+"Stato:"+status);

	}

	public GestoreImpl() {
		super();
		this.depositi = new Vector<IDeposito>();
	}

}
