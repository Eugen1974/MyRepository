package proxy.two;

public class Math2 implements IMath {

	@Override
	public int add(int x, int y) {
		return Math.abs(x) + Math.abs(y);
	}

	@Override
	public int subtraction(int x, int y) {
		return Math.abs(x) - Math.abs(y);
	}
}
