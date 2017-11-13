package abstract_factory;

public class EnKeyboard implements IKeyboard {

	@Override
	public void keyUp() {
		System.out.println("Button up");
	}

	@Override
	public void keyDown() {
		System.out.println("Button down");
	}

	@Override
	public void keyPressed() {
		System.out.println("Button was pressed");
	}
}
