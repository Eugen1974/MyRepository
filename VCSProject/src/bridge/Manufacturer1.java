package bridge;

public class Manufacturer1 implements IManufacturer {

	@Override
	public String getInfo() {
		return "Manufacturer1::getInfo";
	}

	@Override
	public String toString() {
		return "Manufacturer1";
	}
}
