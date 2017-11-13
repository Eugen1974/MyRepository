package strategy;

public class Main {

	public static void main(String[] args) {
		float n1 = 2.1F, n2 = 3.4F;

		MathOperation operation = new MathOperation(new Add());
		System.out.println(n1 + " + " + n2 + " = " + operation.doCalculation(n1, n2));

		operation.setOperation(new Multiply());
		System.out.println(n1 + " * " + n2 + " = " + operation.doCalculation(n1, n2));

		n2 = 0;
		operation.setOperation(new Divide());
		float rezultDivide = operation.doCalculation(n1, n2);
		System.out.println(n1 + " / " + n2 + " = " + rezultDivide + " " + Float.isInfinite(rezultDivide));
	}
}
