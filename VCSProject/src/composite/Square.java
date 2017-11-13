package composite;

public class Square implements IFigure {

	@Override
	public void printName() {
		System.out.println("Квадрат");
	}
	
	@Override
	public String toString() {
		return "Square";
	}
}
