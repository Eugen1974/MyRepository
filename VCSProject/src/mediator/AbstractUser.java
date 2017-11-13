package mediator;

public abstract class AbstractUser implements IUser {

	private IMediator mediator;
	private String name;

	public AbstractUser(Mediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}

	public IMediator getMediator() {
		return mediator;
	}

	public void setMediator(IMediator mediator) {
		this.mediator = mediator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean sendMessage(IUser receiver, String message) {
		return mediator.sendMessage(this, receiver, message);
	}

	@Override
	public void receiveMessage(IUser sender, String message) {
		System.out.println("Message from " + ((AbstractUser) sender).name + " to " + name + ": " + message);
	}

	@Override
	public void sendMessageToAllUsers(String message) {
		mediator.sendMessageToAllUsers(this, message);
	}
}
