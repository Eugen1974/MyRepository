package inner_classes;

public class Class1 {
	public void f() {
		System.out.println("Class1 f()");
	}

	class Class2 {
		public void f() {
			System.out.println("Class2 f()");
		}

		class Class3 {
			public void f() {
				System.out.println("Class3 f()");
			}

			class Class4 {
				public void f() {
					Class1.this.f();
					Class2.this.f();
					Class3.this.f();
					System.out.println("Class4 f()");
				}
			}
		}
	}
}
