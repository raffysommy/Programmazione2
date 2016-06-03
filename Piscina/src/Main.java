import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String argv[]){
		ExecutorService pool=Executors.newFixedThreadPool(4);
		for(int i=0;i<100;i++){
			pool.execute(new Worker());
		}
	}
}
