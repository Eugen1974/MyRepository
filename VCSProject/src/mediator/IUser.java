package mediator;

public interface IUser {

	boolean sendMessage(IUser receiver, String message);

	void sendMessageToAllUsers(String message);

	void receiveMessage(IUser sender, String message);
}
