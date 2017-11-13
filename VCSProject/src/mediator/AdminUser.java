package mediator;

public class AdminUser extends AbstractUser {

	public AdminUser(Mediator mediator, String name) {
		super(mediator, name);
	}

	@Override
	public String toString() {
		return "AdminUser [mediator=" + ((Mediator) getMediator()).getName() + ", name=" + getName() + "]";
	}
}
