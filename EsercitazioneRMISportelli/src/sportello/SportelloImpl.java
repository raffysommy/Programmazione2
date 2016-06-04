package sportello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Semaphore;

public class SportelloImpl extends UnicastRemoteObject implements ISportello {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7261331941006800837L;
	private Semaphore semaforo;
	@Override
	public boolean serviRichiesta(int idCliente) {
		if(semaforo.tryAcquire()){
			try {
				Thread.sleep((long) (Math.random()*2000+1));
				System.out.println("Sportello: "+Thread.currentThread().getName()+" Richiesta servita di:"+idCliente+" Stato"+semaforo.availablePermits());
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				semaforo.release();
			}
			
			return true;
		}
		System.out.println("Sportello: "+Thread.currentThread().getName()+" Richiesta scartata di:"+idCliente);
		return false;
	}
	public SportelloImpl() throws RemoteException {
		super();
		this.semaforo =new Semaphore(3);
	}

}
