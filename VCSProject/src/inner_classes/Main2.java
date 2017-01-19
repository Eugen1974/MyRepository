package inner_classes;

public class Main2 {

	static class Class5 {
		void f() {
			System.out.println("Class5 f()");
		}

		class Class6 {
			void f() {
				System.out.println("Class6 f()");
			}

			class Class7 {
				void f() {
					System.out.println("Class7 f()");
				}

				class Class8 {
					void f() {
						Class5.this.f();
						Class6.this.f();
						Class7.this.f();
						System.out.println("Class8 f()");
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Class5().new Class6().new Class7().new Class8().f();
	}
}
