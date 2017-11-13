package delegate.two;

public class Circle implements IFigure {

	@Override
	public void draw() {
		System.out.println("Рисуем круг");
	}
}
