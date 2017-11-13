package strategy;

public class MathOperation {

	private IMath operation;

	public MathOperation(IMath operation) {
		this.operation = operation;
	}

	public IMath getOperation() {
		return operation;
	}

	public void setOperation(IMath operation) {
		this.operation = operation;
	}

	public float doCalculation(float n1, float n2) {
		return operation.calculation(n1, n2);
	}
}
