package agenzia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AgenziaThread extends Thread{
	Socket s;
	Skeleton skl;
	public AgenziaThread(Socket s, Skeleton skl) {
		super();
		this.s = s;
		this.skl = skl;
	}
	public void run(){
		try {
			System.out.println ("[SRV] nuova richiesta!" );
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			String cmd=dis.readUTF();
			if(cmd.contains("VENDI")){
				this.skl.vendi(dis.readInt());
				dos.writeUTF("ACK");
			}else if(cmd.contains("ACQUISTA")){
				this.skl.acquista(dis.readInt());
				dos.writeUTF("ACK");
			}else{
				System.err.println("Operazione non valida");
				dos.writeUTF("ACK");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
