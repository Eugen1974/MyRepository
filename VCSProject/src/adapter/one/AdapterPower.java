package adapter.one;

public class AdapterPower implements ISourcePower {

	private ConstantVoltage source;

	public AdapterPower() {
		source = new ConstantVoltage();
	}

	@Override
	public void supplyPower() {
		System.out.println("Преобразование 220В");
		source.supplyConstantVoltage();
	}
}
