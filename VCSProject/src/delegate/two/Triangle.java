package delegate.two;

public class Triangle implements IFigure {

	@Override
	public void draw() {
		System.out.println("Рисуем треугольник");
	}
}
