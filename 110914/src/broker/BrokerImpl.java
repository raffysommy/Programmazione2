package broker;

import java.rmi.RemoteException;
import java.util.ArrayList;


import agenzia.IAgenzia;

public class BrokerImpl implements IBroker {
	Integer counter=0;
	ArrayList<Integer> agenzie=new ArrayList<Integer>();
	@Override
	public void sottoponi(int tipo, int quantità) throws RemoteException {
		int contatore=0;
		synchronized(counter){
			contatore=counter=++counter%agenzie.size();
			System.out.println(counter);
		}
		if(tipo==1){
			System.out.println("Richiesta di acquisto:"+quantità);
			new AgenziaStub(agenzie.get(contatore)).acquista(quantità);
		}else if(tipo==2){
			new AgenziaStub(agenzie.get(contatore)).vendi(quantità);
			System.out.println("Richiesta di vendita:"+quantità);
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
