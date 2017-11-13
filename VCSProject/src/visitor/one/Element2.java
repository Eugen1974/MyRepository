package visitor.one;

public class Element2 extends AbstractElement {

	public Element2(String name) {
		super(name);
	}

	@Override
	public void accept(IVisitor visitor) {
		System.out.print("Element2::accept  ");
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Element2 [name=" + getName() + "]";
	}
}
