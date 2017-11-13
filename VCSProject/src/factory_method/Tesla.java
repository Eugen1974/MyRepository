package factory_method;

public class Tesla implements IManufacturer {

	@Override
	public ICar createCar() {
		return new Car1();
	}
}
