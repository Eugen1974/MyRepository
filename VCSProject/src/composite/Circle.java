package composite;

public class Circle implements IFigure {

	@Override
	public void printName() {
		System.out.println("Круг");
	}

	@Override
	public String toString() {
		return "Circle";
	}
}
