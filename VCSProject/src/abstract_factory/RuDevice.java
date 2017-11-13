package abstract_factory;

public class RuDevice implements IDevice {

	@Override
	public IPower createPower() {
		return new RuPower();
	}

	@Override
	public IKeyboard createKeyboard() {
		return new RuKeyboard();
	}
}
