package builder.two;

import builder.one.Car;

public abstract class AbstractCarBuilder {

	private Car car;

	public abstract void setName();

	public abstract void setBoxTransfer();

	public abstract void setMaxSpeed();

	public void setCar(Car car) {
		this.car = car;
	}

	public Car getCar() {
		return car;
	}
}
