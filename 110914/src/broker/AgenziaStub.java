package broker;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.sound.sampled.Port;

import agenzia.IAgenzia;

public class AgenziaStub implements IAgenzia {
	int porto;
	@Override
	public void vendi(int quantita) {
		try {
			Socket s=new Socket(InetAddress.getLocalHost(),porto);
			System.out.println(s.toString());
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			dos.writeUTF("VENDI");
			dos.writeInt(quantita);
			dis.readUTF();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void acquista(int quantita) {
		try {
			Socket s=new Socket(InetAddress.getLocalHost(),porto);
			System.out.println(s.toString());
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			dos.writeUTF("ACQUISTA");
			dos.writeInt(quantita);
			dis.readUTF();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public AgenziaStub(int porto) {
		super();
		this.porto=porto;
		
	}

}
