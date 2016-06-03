package client;


import magazzino.IMagazzino;

public class Client {

	public static void main(String[] args) {
		IMagazzino magazzino=new Stub();
		magazzino.deposita("smartphone",3);
		magazzino.preleva("smartphone");
		for(int i=0;i<5;i++){
			new Thread(){
				public void run(){
					try {
						for(int j=0;j<3;j++){
							Thread.sleep((long) (Math.random()*2+2));
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
		}
		for(int i=0;i<5;i++){
			new Thread(){
				public void run(){
					try {
						for(int j=0;j<3;j++){
							Thread.sleep((long) (Math.random()*2+2));
							String articolo=((int)(Math.random()*2))%2==0?"smartphone":"laptop";
							System.out.println("Ho Depositato: "+articolo+" Con id:"+magazzino.preleva(articolo));
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}				
				}
			}.start();
		}
	}

}
