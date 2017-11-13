package abstract_factory;

public class EnDevice implements IDevice {

	@Override
	public IPower createPower() {
		return new EnPower();
	}

	@Override
	public IKeyboard createKeyboard() {
		return new EnKeyboard();
	}

}
