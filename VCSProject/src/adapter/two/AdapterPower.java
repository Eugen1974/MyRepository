package adapter.two;

import adapter.one.ConstantVoltage;
import adapter.one.ISourcePower;

public class AdapterPower extends ConstantVoltage implements ISourcePower {

	@Override
	public void supplyPower() {
		System.out.println("Преобразование 220В");
		super.supplyConstantVoltage();
	}
}
