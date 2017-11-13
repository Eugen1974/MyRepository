package builder.one;

public class CarBuilder {

	private Car car;

	public CarBuilder() {
		car = new Car();
	}

	public CarBuilder setName(String name) {
		car.setName(name);
		return this;
	}

	public CarBuilder setBoxTransfer(BoxTransfer boxTransfer) {
		car.setBoxTransfer(boxTransfer);
		return this;
	}

	public CarBuilder setMaxSpeed(int maxSpeed) {
		car.setMaxSpeed(maxSpeed);
		return this;
	}

	public Car getCar() {
		return car;
	}
}
