package memento.one;

import memento.two.Data;

/**
 * Создатель
 */
public class Originator {

	private Data data;

	public Originator(Data data) {
		this.data = data;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Memento createMemento() {
		return new Memento(data);
	}

	public void setMemento(Memento memento) {
		data = memento.getData();
	}
}
