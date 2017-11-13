package adapter.one;

public class Main {

	public static void main(String[] args) {
		ISourcePower adapter = new AdapterPower();
		adapter.supplyPower();
	}
}
