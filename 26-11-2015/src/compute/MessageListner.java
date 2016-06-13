package compute;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;

public class MessageListner implements MessageListener {

	private QueueConnection qconn;
	private Compute c;

	public MessageListner(QueueConnection qconn,Compute c) {
		this.qconn=qconn;
		//this.rplm=rplm;
		//this.rpls=rpls;
		this.c=c;
	}

	@Override
	public void onMessage(Message arg0) {
		MapMessage mes=(MapMessage) arg0;
		try {
			int valore = c.getResult(mes.getString("type"),mes.getInt("op1"),mes.getInt("op2"));
			System.out.println(Thread.currentThread().getName());
			QueueSession qsess=qconn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueSender qsend=qsess.createSender((Queue) mes.getJMSReplyTo());
			MapMessage mess=qsess.createMapMessage();
			mess.setInt("result", valore);
			qsend.send(mess);
			qsend.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
