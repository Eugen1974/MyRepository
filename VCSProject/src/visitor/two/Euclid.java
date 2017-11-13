package visitor.two;

public class Euclid implements IVisitor {

	@Override
	public void visit(Point2d p) {
		p.setResult(p.getX() + p.getY());
	}

	@Override
	public void visit(Point3d p) {
		p.setResult(p.getX() + p.getY() + p.getZ());
	}
}
