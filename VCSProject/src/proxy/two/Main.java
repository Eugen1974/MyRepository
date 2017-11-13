package proxy.two;

public class Main {

	public static void main(String[] args) {
		int n1 = 4, n2 = -2;

		MathProxy proxy = new MathProxy();
		proxy.setMath(new Math1());

		System.out.println(n1 + " + " + n2 + " = " + proxy.add(n1, n2));
		System.out.println(n1 + " - " + n2 + " = " + proxy.subtraction(n1, n2));

		n1 = -4;
		proxy.setMath(new Math2());
		System.out.println("\nabs(" + n1 + ") + abs(" + n2 + ") = " + proxy.add(n1, n2));
		System.out.println("abs(" + n1 + ") - abs(" + n2 + ") = " + proxy.subtraction(n1, n2));
	}
}
