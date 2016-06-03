package magazzino;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import coda.Coda;
import coda.CodaSyncronized;

public class MagazzinoReale extends Skeleton implements IMagazzino {
	private Coda<Integer> smartphone;
	private Coda<Integer> laptop;
	FileOutputStream file;
	@Override
	public void deposita(String name, int id) {
		//System.out.println("sto depositando "+name +" con id:"+id);
		try{
			if(name.equals("laptop")){
				laptop.push(id);
			}
			else if(name.equals("smartphone")){
				smartphone.push(id);
			}
		} catch(Exception e){
			e.printStackTrace();
			System.err.println(id);
		}
		System.out.println("ho depositato "+name +" con id:"+id);
	}

	@Override
	public int preleva(String name) {
		int id = 0;
		System.out.println("Sto prelevando"+name);
		if(name.equals("laptop")){
			id=laptop.pop();
		}
		else if(name.equals("smartphone")){
			id=smartphone.pop();
		}
		//try {
			//(new DataOutputStream(file)).writeInt(id);
		//} catch (IOException e) {
			//e.printStackTrace();
		//}
		//System.out.println("ho prelevato"+name+" con id:"+id);
		return id;
		
	}

	public MagazzinoReale() {
		super();
		try {
			this.file=new FileOutputStream("id.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.smartphone = new CodaSyncronized<Integer>(5);
		this.laptop = new CodaSyncronized<Integer>(5);
	}

}
