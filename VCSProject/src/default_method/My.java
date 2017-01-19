package default_method;

public class My implements IA, IB {
	@Override
	public void f() {
		System.out.println("My::f");
	}

	public void show() {
		IA.super.f();
		IB.super.f();
		f();
	}
}
