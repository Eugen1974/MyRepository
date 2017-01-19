package inner_classes;

public class Main3 {
	public static void main(String[] args) {
		new Main3().show();
	}

	public void show() {
		class Class9 {
			void f() {
				System.out.println("Class9  f()");
			}

			class Class10 {
				void f() {
					System.out.println("Class10 f()");
				}

				class Class11 {
					void f() {
						System.out.println("Class11 f()");
					}

					class Class12 {
						void f() {
							Class9.this.f();
							Class10.this.f();
							Class11.this.f();
							System.out.println("Class12 f()");
						}
					}
				}
			}
		}
		new Class9().new Class10().new Class11().new Class12().f();
	}
}
