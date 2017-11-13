package visitor.two;

public class Point3d extends AbstractPoint {

	private int z;

	public Point3d(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	@Override
	public void accept(IVisitor v) {
		v.visit(this);
	}

	public int getZ() {
		return z;
	}
}
