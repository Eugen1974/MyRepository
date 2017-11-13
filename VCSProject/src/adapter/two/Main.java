package adapter.two;

import adapter.one.ISourcePower;

public class Main {

	public static void main(String[] args) {
		ISourcePower adapter = new AdapterPower();
		adapter.supplyPower();
	}
}
