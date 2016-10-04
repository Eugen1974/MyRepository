package others;

public class My {
	private int n;

	public My(int n) {
		this.n = n;
	}

	@Override
	public String toString() {
		return "My [n=" + n + "]";
	}

	// actions when garbage collector deleting object
	@Override
	public void finalize() {
		System.out.println("Deleting " + toString());
	}
}
