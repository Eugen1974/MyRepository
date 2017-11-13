package chain_of_responsibility.one;

public class Main {

	public static void main(String[] args) {
		Handler1 handler1 = new Handler1();
		Handler2 handler2 = new Handler2();
		Handler3 handler3 = new Handler3();
		
		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		
		handler1.handleMessage();
	}
}
