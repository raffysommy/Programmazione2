package magazzino;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public abstract class Skeleton implements IMagazzino{
	private ServerSocket socket;
	public Skeleton(){
		try {
			this.socket=new ServerSocket(12345);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			Socket s;
			try {
				s = socket.accept();
				System.out.println ("[SRV] nuova richiesta!" );
				SkeletonThread t = new SkeletonThread (s,this);
				t.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void deposita(String name, int id) {}
	@Override
	public int preleva(String name) {return 0;}
	
}
