package client;

import magazzino.IMagazzino;

public class ClientB {

		public static void main(String[] args) {
				IMagazzino magazzino=new Stub();
				System.out.println("Ho prelevato: smartphone Con id:"+magazzino.preleva("smartphone"));
				/*	for(int i=0;i<5;i++)
				new Thread(){
					public void run(){
						try {
							for(int j=0;j<3;j++){
								int time=(((int)(Math.random()*3))%3+2);
								Thread.sleep(time);
								String articolo=((int)(Math.random()*2))%2==0?"smartphone":"laptop";
								int id=magazzino.preleva(articolo);
								System.out.println("Ho prelevato: "+articolo+" Con id:"+id);
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}				
					}
				}.start();
			*/
		}


}