package builder.two;

import builder.one.BoxTransfer;

public class FordBuilder extends AbstractCarBuilder {

	@Override
	public void setName() {
		super.getCar().setName("Ford");
	}

	@Override
	public void setBoxTransfer() {
		super.getCar().setBoxTransfer(BoxTransfer.MANUAL);
	}

	@Override
	public void setMaxSpeed() {
		super.getCar().setMaxSpeed(180);
	}
}
