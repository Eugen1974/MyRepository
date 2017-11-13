package memento.two;

import java.util.Objects;

public class Data {

	private String str;

	public Data() {
		str = new String();
	}

	public Data(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "Data [str=" + str + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(str);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Data) {
			return Objects.equals(str, ((Data) obj).str);
		}
		return false;
	}
}
