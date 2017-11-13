package interpreter.one;

public class Main {

	public static void main(String[] args) {
		// String expression = "12 - 34 + 5"; // -17
		String expression = " -1 - 3 + 9"; // 5
		IExpression result = MyMath.calculation(expression);
		int intResult = result.doOperation();
		System.out.println(expression + " = " + intResult);
	}
}
