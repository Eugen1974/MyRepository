package interpreter.two;

public class IntToHexExpression extends AbstractExpression {

	public IntToHexExpression(int number) {
		super(number);
	}

	@Override
	public String interpret(Context context) {
		return context.getHexadecimalFormat(number);
	}
}
