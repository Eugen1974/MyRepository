package chain_of_responsibility.three;

public enum Level {

	INFO(1), DEBUG(2), ERROR(3);

	private int num;

	private Level(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	@Override
	public String toString() {
		return "Level [name=" + name() + ", num=" + num + "]";
	}
}
