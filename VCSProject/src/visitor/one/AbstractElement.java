package visitor.one;

public abstract class AbstractElement implements IElement {

	private String name;

	public AbstractElement(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
