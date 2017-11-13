package mediator;

public class Main {

	public static void main(String[] args) {
		Mediator mediator = new Mediator("mediator");

		IUser admin = new AdminUser(mediator, "admin");
		IUser user1 = new SimpleUser(mediator, "user1");
		IUser user2 = new SimpleUser(mediator, "user2");

		mediator.addUsers(admin, user1, user2);

		user1.sendMessage(admin, "Привет !");
		System.out.println();
		admin.sendMessageToAllUsers("Bсем привет !");
	}
}
