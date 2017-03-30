package threads.switcher;

public class Switcher {

	protected Action state;

	public Switcher(Action state) {
		this.state = state;
	}

	public Action getState() {
		return state;
	}

	public void setState(Action state) {
		this.state = state;
	}
}
