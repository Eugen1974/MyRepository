package builder.two;

import builder.one.BoxTransfer;

public class TeslaBuilder extends AbstractCarBuilder {

	@Override
	public void setName() {
		super.getCar().setName("Tesla");
	}

	@Override
	public void setBoxTransfer() {
		super.getCar().setBoxTransfer(BoxTransfer.AUTO);
	}

	@Override
	public void setMaxSpeed() {
		super.getCar().setMaxSpeed(120);
	}
}
