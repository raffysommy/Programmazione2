package deposito;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;


public abstract class Skeleton implements IDeposito {
	ServerSocket s;
	public Skeleton(int porta){
		try {
			this.s=new ServerSocket(porta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			try {
				Socket skt=s.accept();
				DataInputStream dis=new DataInputStream(skt.getInputStream());
				DataOutputStream dos=new DataOutputStream(skt.getOutputStream());
				if(dis.readUTF().equals("Deposita")){
					this.deposita(dis.readInt());
					dos.writeUTF("ACK");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public boolean deposita(int idArticolo){return false;}


}
