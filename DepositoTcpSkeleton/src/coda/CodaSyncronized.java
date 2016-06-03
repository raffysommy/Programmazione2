package coda;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CodaSyncronized<T> implements Coda<T> {
	private T[] elements;
	private int testa;
	private int coda;
	private int nelem=0;
	private int dimensione;
	private final Lock lock;
	private final Condition fullqueue;
	private final Condition emptyqueue;
	@Override
	public T pop() {
		
		lock.lock();
		T element=null;
		try {
			while(this.isempty())
				emptyqueue.await();
			element=elements[testa];
			testa=(testa+1)%dimensione;
			nelem--;
			fullqueue.signal();
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		finally{
				lock.unlock();
		}
		return element;
		
	}

	@Override
	public void push(T object) {
		lock.lock();
		try {
		while(this.isfull())			
				fullqueue.await();
		elements[coda]=object;
		coda=(coda+1)%dimensione;
		nelem++;
		emptyqueue.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
	}	

	@Override
	public boolean isempty() {
		return nelem<=0;
	}

	@Override
	public boolean isfull() {
		return nelem>=dimensione;
	}

	@Override
	public int lenght() {
		return nelem;
	}

	@SuppressWarnings("unchecked")
	public CodaSyncronized(int dimensione) {
		this.lock=new ReentrantLock();
		elements=(T[])(new Object[dimensione]);
		emptyqueue=lock.newCondition();
		fullqueue=lock.newCondition();
		this.testa = 0;
		this.coda = 0;
		this.dimensione = dimensione;
	}


}
