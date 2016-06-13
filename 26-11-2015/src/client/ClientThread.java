package client;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

public class ClientThread extends Thread {
	private Queue answ;
	private Queue req;
	private QueueConnection qconn;
	private String type;
	private Integer operand1;
	private Integer operand2;

	public ClientThread(QueueConnection qconn,Queue req,Queue answ,String type,Integer operand1,Integer operand2){
		this.qconn=qconn;
		this.req=req;
		this.answ=answ;
		this.type=type;
		this.operand1=operand1;
		this.operand2=operand2;
	}
	public void run(){
		try {
			Thread.sleep((long) (Math.random()*1000+4000));
			QueueSession qsess=qconn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueSender qsend=qsess.createSender(req);
			QueueReceiver qrecv=qsess.createReceiver(answ);
			MapMessage qmess=qsess.createMapMessage();
			qmess.setString("type", type);
			qmess.setInt("op1", operand1);
			qmess.setInt("op2", operand2);
			qmess.setJMSReplyTo(answ);
			qsend.send(qmess);
			MapMessage qreply=(MapMessage) qrecv.receive();
			System.out.println("Ho "+(type.equals("mult")?"moltiplicato":"sommato")+":"+operand1+" e "+operand2+"="+qreply.getInt("result"));
			qsess.close();
		} catch (InterruptedException | JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
