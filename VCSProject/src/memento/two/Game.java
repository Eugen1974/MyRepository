package memento.two;

/**
 * Создатель
 */
public class Game {

	private Data data;

	public Game(Data data) {
		this.data = data;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Save save() {
		return new Save(data);
	}

	public void load(Save file) {
		data = file.getData();
	}
}
