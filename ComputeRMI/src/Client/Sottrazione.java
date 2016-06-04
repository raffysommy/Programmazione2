package Client;

import compute.Operation;

public class Sottrazione implements Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int a;
	private int b;

	@Override
	public int calcola() {
		return a-b;
	}

	public Sottrazione(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

}
