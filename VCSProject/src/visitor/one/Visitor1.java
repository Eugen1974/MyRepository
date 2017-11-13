package visitor.one;

public class Visitor1 implements IVisitor {

	@Override
	public void visit(Element1 element) {
		System.out.println("Visitor1::visit element=" + element);
	}

	@Override
	public void visit(Element2 element) {
		System.out.println("Visitor1::visit element=" + element);
	}
}
