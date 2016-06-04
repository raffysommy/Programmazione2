package Client;

import compute.Operation;

public class Media implements Operation {
	/**
	 * 
	 */
	private static final long serialVersionUID = -255257398830236385L;
	int a;
	int b;
	public Media(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	@Override
	public int calcola() {
		// TODO Auto-generated method stub
		return (a*b)/2;
	}

	
}
