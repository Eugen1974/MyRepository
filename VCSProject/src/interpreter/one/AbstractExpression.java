package interpreter.one;

public abstract class AbstractExpression implements IExpression {

	protected IExpression left;
	protected IExpression right;

	public AbstractExpression(IExpression left, IExpression right) {
		this.left = left;
		this.right = right;
	}
}
