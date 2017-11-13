package delegate.two;

public class Main {

	public static void main(String[] args) {
		Painter painter = new Painter();

		painter.setFigure(new Circle());
		painter.doDraw();

		painter.setFigure(new Triangle());
		painter.doDraw();
	}
}
