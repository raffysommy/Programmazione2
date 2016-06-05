package sportello;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ModdedSemaphore extends Semaphore {

	public ModdedSemaphore(int permits) {
		super(permits);
	}
	private static final long serialVersionUID = 514459123880209395L;
	Semaphore internal=new Semaphore(0);
	AtomicInteger counter=new AtomicInteger(2);
	public boolean tryacqu() throws InterruptedException{
		if(this.tryAcquire())
			return true;
		if(counter.get()>0){
			counter.decrementAndGet();
			System.out.println("Richiesta Accodata");
			this.internal.acquire();
			return true;
		}
		return false;
	}
	public void rilascia(){
		if(counter.get()<2){
			counter.incrementAndGet();
			this.internal.release();
		}else{
			this.release();
		}
	}

}
