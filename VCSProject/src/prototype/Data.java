package prototype;

public class Data implements ICopy {

	private String str;

	public Data(String str) {
		this.str = str;
	}

	@Override
	public Data createCopy() {
		return new Data(new String(str));
	}

	@Override
	public String toString() {
		return "Data [str=" + str + "]";
	}
}
