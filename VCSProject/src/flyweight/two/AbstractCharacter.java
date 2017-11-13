package flyweight.two;

public abstract class AbstractCharacter {

	private char symbol;
	private int width;
	private int height;

	public AbstractCharacter(char symbol, int width, int height) {
		this.symbol = symbol;
		this.width = width;
		this.height = height;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Simbol = " + getSymbol() + ", Width = " + getWidth() + ", Height = " + getHeight();
	}
}
