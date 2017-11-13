package abstract_factory;

public class RuKeyboard implements IKeyboard {

	@Override
	public void keyUp() {
		System.out.println("Отжатие кнопки");
	}

	@Override
	public void keyDown() {
		System.out.println("Нажатие кнопки");
	}

	@Override
	public void keyPressed() {
		System.out.println("Кнопка была нажата");
	}
}
