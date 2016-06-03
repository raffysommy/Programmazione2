import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server extends Thread {
	@Override
	public void run(){
		try {
			DatagramSocket socket=new DatagramSocket(12345);
			byte buffer[]=new byte[65508];
			DatagramPacket pkt=new DatagramPacket(buffer,buffer.length);
			socket.receive(pkt);
			System.out.println("Pacchetto di lunghezza: "+pkt.getLength()+" ricevuto su porta: "+pkt.getPort()+" Dati: "+new String(pkt.getData(),"UTF-8"));
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
