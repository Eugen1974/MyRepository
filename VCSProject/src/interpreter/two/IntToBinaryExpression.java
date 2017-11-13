package interpreter.two;

public class IntToBinaryExpression extends AbstractExpression {

	public IntToBinaryExpression(int number) {
		super(number);
	}

	@Override
	public String interpret(Context context) {
		return context.getBinaryFormat(number);
	}
}
