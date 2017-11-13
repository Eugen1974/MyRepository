package memento.one;

/**
 * Опекун
 */
public class Caretaker {

	private Memento memento;

	public Caretaker(Memento memento) {
		this.memento = memento;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}
