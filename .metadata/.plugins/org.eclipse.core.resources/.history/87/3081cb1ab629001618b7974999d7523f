package magazzino;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SkeletonThread extends Thread {

	private DatagramSocket socket;
	private DatagramPacket p;
	private Skeleton skeleton;

	public SkeletonThread(DatagramPacket p, DatagramSocket socket, Skeleton skeleton) {
		this.p=p;
		this.socket=socket;
		this.skeleton=skeleton;
	}
	public void run(){
		String[] ricevuti=new String(p.getData(),0,p.getData().length).split("_");
		if(ricevuti[0].contains("PUT")){
			//System.out.println("Sto depositando: "+ricevuti[1] +" con id:"+ricevuti[2]);
			skeleton.deposita(ricevuti[1].trim(),Integer.valueOf(ricevuti[2].trim()).intValue());
		}
		else if(ricevuti[0].contains("POP")){
			int id=skeleton.preleva(ricevuti[1]);
			String risposta=Integer.toString(id);
			DatagramPacket pkt=new DatagramPacket(risposta.getBytes(),risposta.length(),p.getAddress(),p.getPort());
			try {
				socket.send(pkt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
