package factory_method;

public class Main {

	public static void main(String[] args) {
		new Tesla().createCar().info();
		new Toyota().createCar().info();
		new Ford().createCar().info();
	}
}
