package others;

public class Main1 {

	public static void main(String[] args) {
		try (AutoCloseable autoCloseable = () -> System.out.println("close()")) {
			System.out.println(5 / 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}