package Client;

import compute.Operation;

public class Moltiplicazione implements Operation {

	private int a;
	private int b;
	public Moltiplicazione(int a,int b) {
		this.a=a;
		this.b=b;
		System.out.println("Oggetto moltiplicazione creato : #version = "+serialVersionUID);
	}
	
	/**
	 * numero di versione 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public int calcola(){
		System.out.println("Moltiplicazione eseguita");
		return a*b;	
	}


}
