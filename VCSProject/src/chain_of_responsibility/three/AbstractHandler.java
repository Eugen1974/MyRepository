package chain_of_responsibility.three;

import java.util.Objects;

public abstract class AbstractHandler implements IHandler {

	private Level level;
	private IHandler next;

	public AbstractHandler(Level level) {
		this.level = level;
	}

	abstract protected void doHandleMessage(Level level, String message);

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public IHandler getNext() {
		return next;
	}

	public void setNext(IHandler next) {
		this.next = next;
	}

	@Override
	public void handleMessage(Level level, String message) {
		if (Util.canHandleMessage(getLevel(), level)) {
			doHandleMessage(level, message);
		}
		if (Objects.nonNull(getNext())) {
			getNext().handleMessage(level, message);
		}
	}
}
