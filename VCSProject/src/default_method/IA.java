package default_method;

public interface IA {
	default void f() {
		System.out.println("IA::f");
	}
}
