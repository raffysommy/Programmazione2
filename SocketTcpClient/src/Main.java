import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {
		for(int i=0;i<100;i++){
		try {
			Socket socket=new Socket("127.0.0.1",12345);
			DataInputStream din=new DataInputStream(socket.getInputStream());
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			dos.writeUTF("Ciao sono il Client "+ Thread.currentThread().getId()+" N Sequenza: "+i);
			System.out.println("Client: "+din.readUTF());
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
