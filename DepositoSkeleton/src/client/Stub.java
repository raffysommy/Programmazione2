package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import magazzino.IMagazzino;

public class Stub implements IMagazzino{
	private DatagramSocket socket;
	private DatagramPacket pkt;
	@Override
	public void deposita(String name, int id) {
		byte[] dati=("PUT_"+name+"_"+id).getBytes();
		try {
			pkt=new DatagramPacket(dati,dati.length,InetAddress.getLocalHost(),3000);		
			socket.send(pkt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Stub Thread "+Thread.currentThread().getId()+" Depositato:"+ name+" Id:" +id);
	}

	@Override
	public int preleva(String name) {
		byte[] dati=("POP_"+name).getBytes();
		int id = 0;
		try {
			pkt=new DatagramPacket(dati,dati.length,InetAddress.getLocalHost(),3000);
			socket.send(pkt);
			byte[] response=new byte[65500];
			pkt=new DatagramPacket(response,response.length);
			socket.receive(pkt);
			id=Integer.valueOf(new String(pkt.getData(),0,pkt.getData().length).trim()).intValue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Stub Thread "+Thread.currentThread().getId()+" Prelevato:"+ name+" Id:" +id);
		return id;
	}
	public Stub(){
		try {
			socket=new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
