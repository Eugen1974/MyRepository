package default_method;

public interface IB {
	default void f() {
		System.out.println("IB::f");
	}
}
