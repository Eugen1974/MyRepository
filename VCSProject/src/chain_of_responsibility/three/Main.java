package chain_of_responsibility.three;

import chain_of_responsibility.three.Handler1;
import chain_of_responsibility.three.Handler2;
import chain_of_responsibility.three.Handler3;
import chain_of_responsibility.three.Level;

public class Main {

	public static void main(String[] args) {
		Handler1 handler1 = new Handler1(Level.INFO);
		Handler2 handler2 = new Handler2(Level.DEBUG);
		Handler3 handler3 = new Handler3(Level.ERROR);

		handler1.setNext(handler2);
		handler2.setNext(handler3);

		handler1.handleMessage(Level.INFO, "инфо");
		System.out.println();
		handler1.handleMessage(Level.DEBUG, "отладка");
		System.out.println();
		handler1.handleMessage(Level.ERROR, "ошибка");
	}
}
