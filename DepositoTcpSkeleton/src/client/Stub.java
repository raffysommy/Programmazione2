package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import magazzino.IMagazzino;

public class Stub implements IMagazzino {
	
	@Override
	public void deposita(String name, int id) {		
		try {
			Socket s = new Socket("127.0.0.1",12345);
			DataInputStream din=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			dos.writeUTF("PUT");
			dos.writeUTF(name);
			dos.writeInt(id);
			din.readUTF();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public int preleva(String name) {
		int valore=0;
		try {
			//System.out.println("sto qua");
			Socket s = new Socket("127.0.0.1",12345);
			DataInputStream din=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			dos.writeUTF("POP");
			dos.writeUTF(name);
			valore=din.readInt();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valore;
	}


}
