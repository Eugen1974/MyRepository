package visitor.two;

public class Main {

	public static void main(String[] args) {
		AbstractPoint point = new Point2d(1, 2);

		point.accept(new Euclid());
		System.out.println("Euclid 2d = " + point.getResult());

		point.accept(new Chebyshev());
		System.out.println("Chebyshev 2d = " + point.getResult());

		point = new Point3d(1, 2, 3);

		point.accept(new Euclid());
		System.out.println("Euclid 3d = " + point.getResult());

		point.accept(new Chebyshev());
		System.out.println("Chebyshev 3d = " + point.getResult());
	}
}
