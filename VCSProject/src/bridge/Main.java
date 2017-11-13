package bridge;

public class Main {

	public static void main(String[] args) {
		AbstractCar[] cars = { new Ford	 ("Ford", 	new Manufacturer1()), 
							   new Toyota("Toyota", new Manufacturer2()),
							   new Tesla ("Tesla", 	new Manufacturer3()) };
		for (AbstractCar car : cars) {
			System.out.printf("%50s %s\n", car, car.getManufacturerInfo());
		}
	}
}
