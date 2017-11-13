package interpreter.two;

public class Client {

	private Context context;

	public Client(Context context) {
		this.context = context;
	}

	public String interpret(String str) {
		IExpression exp;
		// create rules for expressions
		if (str.contains("Hexadecimal")) {
			exp = new IntToHexExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
		} else if (str.contains("Binary")) {
			exp = new IntToBinaryExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
		} else {
			throw new IllegalArgumentException("Doesn't operated case for " + str);
		}
		return exp.interpret(context);
	}
}