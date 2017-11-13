package abstract_factory;

public class EnPower implements IPower {

	@Override
	public void setOn() {
		System.out.println("Power set on");
	}

	@Override
	public void setOff() {
		System.out.println("Power set off");
	}
}
