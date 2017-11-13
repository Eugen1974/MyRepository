package bridge;

public class Tesla extends AbstractCar {

	public Tesla(String name, IManufacturer manufacturer) {
		super(name, manufacturer);
	}

	@Override
	public String toString() {
		return "Tesla [name=" + getName() + ", manufacturer=" + getManufacturer() + "]";
	}
}
