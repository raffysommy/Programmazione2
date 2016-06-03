package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public abstract class Skeleton implements InterfacciaServer {

	private DatagramSocket socket;


	public Skeleton(){
		
		try {
			socket=new DatagramSocket(3000);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void runSkeleton(){
		while(true){
			byte[] data=new byte[65500];
			DatagramPacket p = new DatagramPacket(data,data.length);
			try {
				socket.receive(p);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SkeletonThread leggero=new SkeletonThread(p,socket,this);
			leggero.start();
		}
	}
	@Override
	public abstract void sum(int i);

	@Override
	public abstract int get();


	@Override
	public abstract int inc();

}
