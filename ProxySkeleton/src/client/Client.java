package client;

import server.InterfacciaServer;

public class Client {
	private static InterfacciaServer proxy;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<300;i++){
			new Thread(){
				@Override
				public void run(){
					proxy=new Stub();
					if(Thread.currentThread().getId()%3==0)
						System.out.println("Valore: "+proxy.get());
					else if(Thread.currentThread().getId()%3==1)
						proxy.sum((int) (Math.random()*10));
					else
						System.out.println("Valore incrementato: "+proxy.inc());
					//System.out.println("Valore: "+proxy.get());
				}
			}.start();
		}
	}

}
