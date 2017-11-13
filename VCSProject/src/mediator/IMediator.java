package mediator;

public interface IMediator {

	boolean sendMessage(IUser sender, IUser receiver, String message);

	void sendMessageToAllUsers(IUser sender, String message);
}
