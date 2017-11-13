package prototype;

public class Fabrica {

	private ICopy copy;

	public ICopy getCopy() {
		return copy;
	}

	public void setCopy(ICopy copy) {
		this.copy = copy;
	}

	public ICopy makeCopy() {
		return copy.createCopy();
	}
}
