package facade;

public class Computer {

	private Power power;
	private FlashMemory memory;
	private HDD hdd;

	public Computer() {
		power = new Power();
		memory = new FlashMemory();
		hdd = new HDD();
	}

	public void loadData() {
		power.setOn();
		memory.setIn();
		hdd.copyingFromFlashMemoryToHDD();
	}
}
