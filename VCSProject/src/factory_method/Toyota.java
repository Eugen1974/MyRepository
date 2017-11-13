package factory_method;

public class Toyota implements IManufacturer {

	@Override
	public ICar createCar() {
		return new Car2();
	}
}
