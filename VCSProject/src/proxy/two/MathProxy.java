package proxy.two;

public class MathProxy implements IMath {

	private IMath math;

	public IMath getMath() {
		return math;
	}

	public void setMath(IMath math) {
		this.math = math;
	}

	@Override
	public int add(int x, int y) {
		return math.add(x, y);
	}

	@Override
	public int subtraction(int x, int y) {
		return math.subtraction(x, y);
	}
}
