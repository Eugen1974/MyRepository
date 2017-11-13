package proxy.two;

public class Math1 implements IMath {

	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public int subtraction(int x, int y) {
		return x - y;
	}
}
