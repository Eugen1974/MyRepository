package visitor.two;

public class Chebyshev implements IVisitor {

	@Override
	public void visit(Point2d p) {
		p.setResult(Math.max(p.getX(), p.getY()));
	}

	@Override
	public void visit(Point3d p) {
		p.setResult(Math.max(Math.max(p.getX(), p.getY()), p.getZ()));
	}
}
