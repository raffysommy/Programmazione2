package compute;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class Compute{
	private Semaphore sem=new Semaphore(5);
	private DataOutputStream dos;
	public Compute(){
		try {
			dos=new DataOutputStream(new FileOutputStream(new File("test.txt"),true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getResult(String string, int double1, int double2) {
		sem.acquireUninterruptibly();
		int result;
		if(string.equals("mult")){
			result=double1*double2;
		}else if(string.equals("sum")){
			result=double1+double2;
		}else{
			sem.release();
			throw new RuntimeException("Operazione Sconosciuta");
		}
		try {
			dos.writeUTF(string+","+double1+","+double2+","+result);
			dos.writeChar('\n');
			dos.writeChar('\r');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sem.release();
		}
		return result;
	}
	
}
