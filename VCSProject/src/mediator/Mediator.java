package mediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Mediator implements IMediator {

	private List<IUser> users;
	private String name;

	public Mediator(String name) {
		this(new ArrayList<>(), name);
	}

	public Mediator(List<IUser> users, String name) {
		this.users = users;
		this.name = name;
	}

	public List<IUser> getUsers() {
		return users;
	}

	public void setUsers(List<IUser> users) {
		this.users = users;
	}

	public void addUsers(List<IUser> users) {
		this.users.addAll(users);
	}

	public void addUsers(IUser... users) {
		addUsers(Arrays.asList(users));
	}

	public boolean addUser(IUser user) {
		return users.add(user);
	}

	public boolean removeUser(IUser user) {
		return users.remove(user);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Mediator [users=" + users + ", name=" + name + "]";
	}

	@Override
	public boolean sendMessage(IUser sender, IUser receiver, String message) {
		for (IUser user : users) {
			if (Objects.equals(user, receiver)) {
				receiver.receiveMessage(sender, message);
				return true;
			}
		}
		return false;
	}

	@Override
	public void sendMessageToAllUsers(IUser sender, String message) {
		users.forEach(user -> {
			if (!Objects.equals(user, sender)) {
				user.receiveMessage(sender, message);
			}
		});
	}
}
