package factory_method;

public class Ford implements IManufacturer {

	@Override
	public ICar createCar() {
		return new Car3();
	}
}
