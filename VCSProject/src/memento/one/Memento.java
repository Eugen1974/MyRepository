package memento.one;

import memento.two.Data;

/**
 * Хранитель предыдущего состояния объекта
 */
public class Memento {

	private Data data;

	public Memento(Data data) {
		this.data = data;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
