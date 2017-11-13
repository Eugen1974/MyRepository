package interpreter.two;

public abstract class AbstractExpression implements IExpression {

	protected int number;

	public AbstractExpression(int number) {
		this.number = number;
	}
}
