package state.one;

public class Main {

	public static void main(String[] args) {
		Radio radio = new Radio();
		radio.setRadioStation(new RadioStation1());

		for (int i = 1; i <= 3; i++) {
			radio.doPlay();
			radio.nextRadioStation();
		}
		radio.doPlay();
	}
}
