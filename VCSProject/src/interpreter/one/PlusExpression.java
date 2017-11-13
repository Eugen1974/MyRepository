package interpreter.one;

public class PlusExpression extends AbstractExpression {

	public PlusExpression(IExpression left, IExpression right) {
		super(left, right);
	}

	@Override
	public int doOperation() {
		return left.doOperation() + right.doOperation();
	}
}
