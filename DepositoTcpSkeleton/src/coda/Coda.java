package coda;


public interface Coda<T> {
	public T pop();
	public void push(T object);
	public boolean isempty();
	public boolean isfull();
	public int lenght();
}
