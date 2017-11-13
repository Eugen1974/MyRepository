package interpreter.two;

public class Context {

	public String getBinaryFormat(int number) {
		return Integer.toBinaryString(number);
	}

	public String getHexadecimalFormat(int number) {
		return Integer.toHexString(number);
	}
}
