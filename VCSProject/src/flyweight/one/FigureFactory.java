package flyweight.one;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

import delegate.two.Circle;
import delegate.two.IFigure;
import delegate.two.Triangle;

public class FigureFactory {

	private static final Map<EnumFigure, IFigure> FIGURES;

	static {
		FIGURES = new EnumMap<>(EnumFigure.class);
	}

	private FigureFactory() {
	}

	public static IFigure getFigure(EnumFigure f) {
		IFigure figure = FIGURES.get(f);
		if (Objects.isNull(figure)) {
			if (Objects.equals(f, EnumFigure.CIRCLE)) {
				figure = new Circle();
			} else if (Objects.equals(f, EnumFigure.TRIANGLE)) {
				figure = new Triangle();
			} else if (Objects.equals(f, EnumFigure.SQUARE)) {
				figure = new Square();
			} else {
				throw new IllegalArgumentException("Doesn't operated case for figure = " + f + " !");
			}
			FIGURES.put(f, figure);
		}
		return figure;
	}
}
