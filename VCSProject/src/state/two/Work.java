package state.two;

public class Work implements IActivity {

	@Override
	public void doSomething(Human human) {
		System.out.println("Я работаю");
		human.setActivity(new Rest());
	}
}
