package agenzia;

public class AgenziaServer {

	public static void main(String[] args) {
		for(int i=0;i<3;i++)
		new Thread(){
			public void run(){
				Skeleton agenzia1=new AgenziaReale((int) (Math.random()*30000+30000));
				agenzia1.run();
			}
		}.start();
		

	}

}
