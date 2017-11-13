package builder.two;

import builder.one.Car;

public class Seller {

	private AbstractCarBuilder builder;

	public AbstractCarBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(AbstractCarBuilder builder) {
		this.builder = builder;
	}

	public Car buildCar() {
		builder.setCar(new Car());
		builder.setName();
		builder.setBoxTransfer();
		builder.setMaxSpeed();
		return builder.getCar();
	}
}
