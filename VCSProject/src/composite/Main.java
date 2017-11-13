package composite;

public class Main {

	public static void main(String[] args) {
		ContainerFigures container1 = new ContainerFigures();
		container1.addFigure(new Circle());
		container1.addFigure(new Triangle());

		ContainerFigures container2 = new ContainerFigures();
		container2.addFigure(new Square());

		ContainerFigures container = new ContainerFigures();
		container.addFigure(container1);
		container.addFigure(container2);

		container.printName();
	}
}
