package strategy;

public class Add implements IMath {
	@Override
	public float calculation(float n1, float n2) {
		return n1 + n2;
	}
}
