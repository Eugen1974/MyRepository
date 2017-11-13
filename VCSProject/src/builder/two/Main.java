package builder.two;

import builder.one.Car;

public class Main {

	public static void main(String[] args) {
		Seller seller = new Seller();

		seller.setBuilder(new TeslaBuilder());
		Car car = seller.buildCar();
		System.out.println(car);

		seller.setBuilder(new FordBuilder());
		car = seller.buildCar();
		System.out.println(car);
	}
}
