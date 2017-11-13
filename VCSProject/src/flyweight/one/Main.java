package flyweight.one;

public class Main {

	public static void main(String[] args) {
		for (EnumFigure f : EnumFigure.values()) {
			FigureFactory.getFigure(f).draw();
		}
	}
}
