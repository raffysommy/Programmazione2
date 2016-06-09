package server;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import subscribe.ISottoscrittore;

public class Gestore implements IGestore {
	private HashMap<String,Vector<String>> message=new HashMap<String,Vector<String>>();
	private HashMap<String,Vector<ISottoscrittore>> subscriber=new HashMap<String,Vector<ISottoscrittore>>();
	private Semaphore semaforo;
	@Override
	public boolean publish(String topic, String msg) throws RemoteException {
		try {
			semaforo.acquire();
			System.out.println("Richiesta Accettata");
			message.putIfAbsent(topic, new Vector<String>());
			message.get(topic).add(msg);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Vector<ISottoscrittore> sottoscrittori=subscriber.get(topic);
			if(sottoscrittori!=null){
				for(int i=0;i<sottoscrittori.size();i++){
					sottoscrittori.get(i).getListner().onMessage(msg);
				}
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			semaforo.release();
		}
		return true;
	}

	@Override
	public void subscribe(String topic, ISottoscrittore sottoscrittore) throws RemoteException {
		subscriber.putIfAbsent(topic, new Vector<ISottoscrittore>());
		subscriber.get(topic).add(sottoscrittore);
		System.out.println(sottoscrittore.toString());
	}
	public Gestore(){
		semaforo = new Semaphore(3);
	}

}
