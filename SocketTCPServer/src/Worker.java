import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Worker extends Thread{

	private Socket socket;

	public Worker(Socket accept) {
		this.socket=accept;
	}
	@Override
	public void run(){
		try {
			DataInputStream din=new DataInputStream(this.socket.getInputStream());
			DataOutputStream dos=new DataOutputStream(this.socket.getOutputStream());
			System.out.println("Server:"+din.readUTF());
			dos.writeUTF("Ciao Client sono il Worker "+ Thread.currentThread().getId()+"Random: "+Math.random());
			this.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
