package visitor.two;

public abstract class AbstractPoint implements IPoint {

	private int x;
	private int y;
	private int result;

	public AbstractPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
