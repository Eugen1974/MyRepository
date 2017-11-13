package state.two;

public class Human {

	private IActivity activity;

	public Human(IActivity activity) {
		this.activity = activity;
	}

	public IActivity getActivity() {
		return activity;
	}

	public void setActivity(IActivity activity) {
		this.activity = activity;
	}

	public void nextActivity() {
		activity.doSomething(this);
	}
}
