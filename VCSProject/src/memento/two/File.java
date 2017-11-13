package memento.two;

/**
 * Опекун
 */
public class File {

	private Save save;

	public File(Save save) {
		this.save = save;
	}

	public Save getSave() {
		return save;
	}

	public void setSave(Save save) {
		this.save = save;
	}
}
