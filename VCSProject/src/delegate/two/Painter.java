package delegate.two;

public class Painter {

	private IFigure figure;

	public IFigure getFigure() {
		return figure;
	}

	public void setFigure(IFigure figure) {
		this.figure = figure;
	}

	public void doDraw() {
		figure.draw();
	}
}
