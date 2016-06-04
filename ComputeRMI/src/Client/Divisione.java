package Client;

import compute.Operation;

public class Divisione implements Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8113500006471974344L;
	private int a;
	private int b;

	@Override
	public int calcola() {
		// TODO Auto-generated method stub
		return a/b;
	}

	public Divisione(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

}
