package agenzia;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import broker.IBroker;

public class AgenziaReale extends Skeleton implements IAgenzia{
	private Integer biglietti=new Integer(10);
	private Lock lock=new ReentrantLock();
	public AgenziaReale(int porto) {
		super(porto);
		IBroker broker;
		try {
			broker = (IBroker)LocateRegistry.getRegistry(2000).lookup("broker");
			broker.sottoscrivi(porto);
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void vendi(int quantita) {
		lock.lock();
			biglietti+=quantita;
			System.out.println("Numero Biglietti:"+biglietti);
		lock.unlock();
	}

	@Override
	public void acquista(int quantita) {
		lock.lock();
			if(biglietti>=quantita)
				biglietti-=quantita;
			System.out.println("Numero Biglietti:"+biglietti);
		lock.unlock();
	}

}
