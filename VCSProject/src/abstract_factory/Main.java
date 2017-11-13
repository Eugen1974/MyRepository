package abstract_factory;

public class Main {

	public static void main(String[] args) {
		showDevice(new RuDevice());
		System.out.println("------------------");
		showDevice(new EnDevice());
	}

	public static void showDevice(IDevice device) {
		IPower power = device.createPower();
		power.setOn();
		power.setOff();

		System.out.println();

		IKeyboard keyboard = device.createKeyboard();
		keyboard.keyDown();
		keyboard.keyUp();
		keyboard.keyPressed();
	}
}
