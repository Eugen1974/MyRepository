package abstract_factory;

public class RuPower implements IPower {

	@Override
	public void setOn() {
		System.out.println("Питание включено");
	}

	@Override
	public void setOff() {
		System.out.println("Питание выключено");
	}
}
