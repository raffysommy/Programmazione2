package sportello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SportelloImpl extends UnicastRemoteObject implements ISportello {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7261331941006800837L;
	private ModdedSemaphore semaforo;
	@Override
	public boolean serviRichiesta(int idCliente) {
		try {
			if(semaforo.tryacqu()){
				try {
					Thread.sleep((long) (Math.random()*2000+1));
					System.out.println("Sportello: "+Thread.currentThread().getName()+" Richiesta servita di:"+idCliente+" Stato"+semaforo.availablePermits());
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					semaforo.rilascia();
				}
				
				return true;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sportello: "+Thread.currentThread().getName()+" Richiesta scartata di:"+idCliente);
		return false;
	}
	public SportelloImpl() throws RemoteException {
		super();
		this.semaforo =new ModdedSemaphore(3);
	}

}
