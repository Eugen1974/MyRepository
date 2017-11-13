package composite;

import java.util.ArrayList;
import java.util.List;

public class ContainerFigures implements IFigure {

	private List<IFigure> figures;

	public ContainerFigures() {
		figures = new ArrayList<>();
	}

	public boolean addFigure(IFigure figure) {
		return figures.add(figure);
	}

	public boolean removeFigure(IFigure figure) {
		return figures.remove(figure);
	}

	@Override
	public void printName() {
		figures.forEach(IFigure::printName);
	}

	@Override
	public String toString() {
		return "ContainerFigures [figures=" + figures + "]";
	}
}
