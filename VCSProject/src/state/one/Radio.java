package state.one;

public class Radio {

	private IRadioStation radioStation;

	public IRadioStation getRadioStation() {
		return radioStation;
	}

	public void setRadioStation(IRadioStation radioStation) {
		this.radioStation = radioStation;
	}

	public IRadioStation nextRadioStation() {
		if (radioStation instanceof RadioStation1) {
			radioStation = new RadioStation2();
		} else if (radioStation instanceof RadioStation2) {
			radioStation = new RadioStation3();
		} else if (radioStation instanceof RadioStation3) {
			radioStation = new RadioStation1();
		}
		return radioStation;
	}

	public void doPlay() {
		radioStation.play();
	}
}
