package state.two;

public class Main {

	public static void main(String[] args) {
		Human human = new Human(new Work());
		for (int i = 0; i < 14; i++) {
			human.nextActivity();
		}
	}
}
