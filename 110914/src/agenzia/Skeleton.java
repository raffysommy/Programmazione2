package agenzia;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class Skeleton implements IAgenzia {
	ServerSocket skt;

	public Skeleton(int porto) {
		try {
			this.skt = new ServerSocket(porto);
			System.out.println(skt.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			try {
				Socket s=skt.accept();
				System.out.println(s.toString());
				AgenziaThread leggero=new AgenziaThread(s,this);
				leggero.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	@Override
	public void vendi(int quantita){}
	@Override
	public void acquista(int quantita){}

}
