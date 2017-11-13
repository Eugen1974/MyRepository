package abstract_factory;

public interface IDevice {

	IPower createPower();

	IKeyboard createKeyboard();
}
