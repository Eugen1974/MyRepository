package bridge;

public abstract class AbstractCar {

	private String name;
	private IManufacturer manufacturer;

	public AbstractCar(String name, IManufacturer manufacturer) {
		this.name = name;
		this.manufacturer = manufacturer;
	}

	abstract public String toString();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IManufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(IManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacturerInfo() {
		return manufacturer.getInfo();
	}
}
