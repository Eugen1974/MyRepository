package state.two;

public class Rest implements IActivity {

	private int counter;

	@Override
	public void doSomething(Human human) {
		if (counter < 3) {
			System.out.println("Я отдыхаю");
			counter++;
		} else {
			human.setActivity(new Work());
		}
	}
}
