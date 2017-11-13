package proxy.one;

public class Main {

	public static void main(String[] args) {
		Proxy proxy = new Proxy();

		proxy.setService(new Service1());
		proxy.doSomething();

		proxy.setService(new Service2());
		proxy.doSomething();
	}
}
