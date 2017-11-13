package builder.one;

public class Car {

	private String name;
	private BoxTransfer boxTransfer;
	private int maxSpeed;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BoxTransfer getBoxTransfer() {
		return boxTransfer;
	}

	public void setBoxTransfer(BoxTransfer boxTransfer) {
		this.boxTransfer = boxTransfer;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", boxTransfer=" + boxTransfer + ", maxSpeed=" + maxSpeed + "]";
	}
}
