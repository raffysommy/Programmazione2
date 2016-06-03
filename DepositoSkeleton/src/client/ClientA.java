package client;

import magazzino.IMagazzino;

public class ClientA {

	public static void main(String[] args) {
		IMagazzino magazzino=new Stub();
		magazzino.deposita("smartphone",3);
		/*for(int i=0;i<5;i++){
			new Thread(){
				public void run(){
					try {
						for(int j=0;j<3;j++){
							int time=(((int)(Math.random()*3))%3+2);
							Thread.sleep(time);
							String articolo=((int)(Math.random()*2))%2==0?"smartphone":"laptop";
							int id=(int)(Math.random()*100);
							magazzino.deposita(articolo,id);
							System.out.println("Ho Depositato: "+articolo+" Con id:"+id);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}				
				}
			}.start();
		}*/
	}
}
