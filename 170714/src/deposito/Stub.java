package deposito;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public class Stub implements IDeposito,Serializable{
	private static final long serialVersionUID = -1344858847643728769L;
	private int port;
	public Stub(int port){
		this.port=port;
	}
	@Override
	public boolean deposita(int idArticolo) {
		try {
			Socket s=new Socket("127.0.0.1",port);
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			dos.writeUTF("Deposita");
			dos.writeInt(idArticolo);
			dis.readUTF();
			s.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
		
}
