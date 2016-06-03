import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Client extends Thread{
	@Override
	public void run(){
		try {
			DatagramSocket socket=new DatagramSocket();
			byte buffer[]="Ciaone".getBytes();
			DatagramPacket pkt=new DatagramPacket(buffer,buffer.length,InetAddress.getByName("localhost"),12345);
			socket.send(pkt);
			System.out.println("Pacchetto di lunghezza: "+pkt.getLength()+" inviato su porta: "+pkt.getPort()+" Dati: "+new String(pkt.getData(),"UTF-8"));
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
