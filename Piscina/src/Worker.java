
public class Worker implements Runnable{
	private double id;
	public Worker(){
		this.id=Math.random();
	}
	@Override
	public void run(){
		System.out.println("Runnable: "+this.id+" Executed on Thread "+ Thread.currentThread().getName() );
	}
}
