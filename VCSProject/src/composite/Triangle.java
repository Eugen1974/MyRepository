package composite;

public class Triangle implements IFigure {

	@Override
	public void printName() {
		System.out.println("Треугольник");
	}
	
	@Override
	public String toString() {
		return "Triangle";
	}
}
