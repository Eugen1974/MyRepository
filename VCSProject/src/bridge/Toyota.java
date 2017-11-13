package bridge;

public class Toyota extends AbstractCar {

	public Toyota(String name, IManufacturer manufacturer) {
		super(name, manufacturer);
	}

	@Override
	public String toString() {
		return "Toyota [name=" + getName() + ", manufacturer=" + getManufacturer() + "]";
	}
}
