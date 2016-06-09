package broker;

import java.rmi.RemoteException;
import java.util.ArrayList;


import agenzia.IAgenzia;

public class BrokerImpl implements IBroker {
	Integer counter=0;
	ArrayList<Integer> agenzie=new ArrayList<Integer>();
	@Override
	public void sottoponi(int tipo, int quantit�) throws RemoteException {
		int contatore=0;
		synchronized(counter){
			contatore=counter=++counter%agenzie.size();
			System.out.println(counter);
		}
		if(tipo==1){
			System.out.println("Richiesta di acquisto:"+quantit�);
			new AgenziaStub(agenzie.get(contatore)).acquista(quantit�);
		}else if(tipo==2){
			new AgenziaStub(agenzie.get(contatore)).vendi(quantit�);
			System.out.println("Richiesta di vendita:"+quantit�);
		}else{
			System.err.println("Operazione non valida");
		}
		
	}

	@Override
	public void sottoscrivi(int porto) throws RemoteException {
		agenzie.add(porto);
		System.out.println("Agenzia registrata su porto:"+porto);
	}

}
