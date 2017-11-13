package interpreter.one;

public class MinusExpression extends AbstractExpression {

	public MinusExpression(IExpression left, IExpression right) {
		super(left, right);
	}

	@Override
	public int doOperation() {
		return left.doOperation() - right.doOperation();
	}
}
