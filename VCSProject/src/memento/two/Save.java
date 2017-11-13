package memento.two;

/**
 * Хранитель предыдущего состояния объекта
 */
public class Save {

	private Data data;

	public Save(Data data) {
		this.data = data;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
