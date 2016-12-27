package others;

public class Main {
	public static void main(String[] args) {
		IEx<?> ob = new ArrayEx();
		System.out.println(ob.getList());

		ob = new ListEx();
		System.out.println(ob.getList());

		ob = new MapEx();
		System.out.println(ob.getList());
	}
}
