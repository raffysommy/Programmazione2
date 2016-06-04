package gestoresportelli;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import sportello.ISportello;

public class GestoreSportelloImpl implements IGestoreSportello {
	private List<ISportello> sportelli;

	@Override
	public boolean sottoponiRichiesta(int idCliente) throws RemoteException {
		for(int i=0;i<sportelli.size();i++){
			if(sportelli.get(i).serviRichiesta(idCliente))
				return true;
		}
		return false;
	}

	@Override
	public boolean sottoscrivi(ISportello s) throws RemoteException {
		sportelli.add(s);
		return true;
	}

	public GestoreSportelloImpl() {
		super();
		this.sportelli = new ArrayList<ISportello>();
	}
	
}
