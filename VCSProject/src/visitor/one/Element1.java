package visitor.one;

public class Element1 extends AbstractElement {

	public Element1(String name) {
		super(name);
	}

	@Override
	public void accept(IVisitor visitor) {
		System.out.print("Element1::accept  ");
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Element1 [name=" + getName() + "]";
	}
}
