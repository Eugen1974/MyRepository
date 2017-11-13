package command.two;

public class DrawGraphic implements ICommand {

	private Plotter plotter;

	public DrawGraphic() {
		plotter = new Plotter();
	}

	public Plotter getPlotter() {
		return plotter;
	}

	public void setPlotter(Plotter plotter) {
		this.plotter = plotter;
	}

	@Override
	public void execute() {
		plotter.draw();
	}
}
