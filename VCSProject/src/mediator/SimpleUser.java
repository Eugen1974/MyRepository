package mediator;

public class SimpleUser extends AbstractUser {

	public SimpleUser(Mediator mediator, String name) {
		super(mediator, name);
	}

	@Override
	public String toString() {
		return "SimpleUser [mediator=" + ((Mediator) getMediator()).getName() + ", name=" + getName() + "]";
	}
}
