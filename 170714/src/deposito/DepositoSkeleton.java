package deposito;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DepositoSkeleton extends Skeleton implements IDeposito {

	private DataOutputStream dos;

	public DepositoSkeleton(int porta) {
		super(porta);
		try {
			FileOutputStream fos=new FileOutputStream(Thread.currentThread().getName()+".txt");
			dos=new DataOutputStream(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean deposita(int idArticolo) {
		try {
			Thread.sleep((long) (Math.random()*4000+1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sto depositando"+idArticolo+" NThread"+Thread.currentThread().getName());
		try {
			dos.writeUTF("Articolo:"+idArticolo);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

}
