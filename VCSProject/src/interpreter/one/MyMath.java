package interpreter.one;

public class MyMath {

	private MyMath() {
	}

	public static IExpression calculation(String expression) {
		expression = expression.replace(" ", "");
		int position = expression.length() - 1;
		while (position > 0) {
			char c = expression.charAt(position);
			if (Character.isDigit(c)) {
				position--;
			} else {
				IExpression left = calculation(expression.substring(0, position));
				IExpression right = new NumberExpression(Integer.valueOf(expression.substring(position + 1)));
				if (c == '+') {
					return new PlusExpression(left, right);
				} else if (c == '-') {
					return new MinusExpression(left, right);
				} else {
					throw new IllegalArgumentException("Doesn't operated case for symbol " + c + " !");
				}
			}
		}
		return new NumberExpression(Integer.valueOf(expression));
	}
}
