



package magazzino;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SkeletonThread extends Thread {

	private Socket socket;
	private Skeleton skeleton;

	public SkeletonThread(Socket socket, Skeleton skeleton) {
		this.socket=socket;
		this.skeleton=skeleton;
	}
	public void run(){
		try {
			DataOutputStream out=new DataOutputStream(socket.getOutputStream());
			DataInputStream in=new DataInputStream(socket.getInputStream());
			String cmd=in.readUTF();
			if(cmd.contains("PUT")){
				skeleton.deposita(in.readUTF(), in.readInt());
				out.writeUTF("ACK");
			}else if(cmd.contains("POP")){
				out.writeInt(skeleton.preleva(in.readUTF()));
			}else
				throw new RuntimeException("Errore Irreversibile");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
