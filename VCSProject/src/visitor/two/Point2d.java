package visitor.two;

public class Point2d extends AbstractPoint {

	public Point2d(int x, int y) {
		super(x, y);
	}

	@Override
	public void accept(IVisitor v) {
		v.visit(this);
	}
}
