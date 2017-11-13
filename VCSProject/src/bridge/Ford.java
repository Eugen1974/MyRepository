package bridge;

public class Ford extends AbstractCar {

	public Ford(String name, IManufacturer manufacturer) {
		super(name, manufacturer);
	}

	@Override
	public String toString() {
		return "Ford [name=" + getName() + ", manufacturer=" + getManufacturer() + "]";
	}
}
