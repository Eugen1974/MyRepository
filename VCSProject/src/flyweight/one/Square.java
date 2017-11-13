package flyweight.one;

import delegate.two.IFigure;

public class Square implements IFigure {

	@Override
	public void draw() {
		System.out.println("Рисуем квадрат");
	}
}
