package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SkeletonThread extends Thread {

	private DatagramSocket socket;
	private DatagramPacket p;
	private InterfacciaServer ser;

	public SkeletonThread(DatagramPacket p, DatagramSocket socket, Skeleton skeleton) {
		this.p=p;
		this.socket=socket;
		this.ser=skeleton;
	}
	@Override
	public void run(){
		String dati=new String(p.getData(),0,p.getLength());
		if(dati.contains("Somma_")){
			int valoredasommare = Integer.parseInt(dati.substring("Somma_".length(), dati.length()));
			ser.sum(valoredasommare);
			System.out.println("Thread:"+this.getName()+" Ho sommato:"+valoredasommare);
		}else if(dati.contains("Get_")){
			byte[] response= String.valueOf(ser.get()).getBytes();
			DatagramPacket p2 = new DatagramPacket(response,response.length,p.getAddress(),p.getPort());
			try {
				socket.send(p2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(dati.contains("Inc_")){
			byte[] response= String.valueOf(ser.inc()).getBytes();
			DatagramPacket p2 = new DatagramPacket(response,response.length,p.getAddress(),p.getPort());
			try {
				socket.send(p2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
