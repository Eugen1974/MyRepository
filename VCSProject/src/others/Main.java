package others;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Main {
	public static void main(String[] args) {
		f();
		f1();
		f2();
		f3();
		callAdd();
	}

	public static <T extends Appendable> void f() {
		try {
			T ob = (T) StringBuffer.class.newInstance();
			ob.append("111");
			System.out.println(ob);

			ob = (T) StringBuilder.class.newInstance();
			ob.append("222");
			System.out.println(ob);

			ob = (T) StringWriter.class.newInstance();
			ob.append("333");
			System.out.println(ob);

		} catch (InstantiationException | IllegalAccessException | IOException e) {
			e.printStackTrace();
		}
	}

	public static <T> void f1() {
		T ob = (T) new Object();
		System.out.println(ob);
	}

	public static <T extends Number> void f2() {
		List<T> list = new ArrayList<>();
		list.add((T) new Integer(1));
		list.add((T) new Float(2.2));
		list.add((T) new Double(3.3));
		System.out.println(list + " " + list.get(0).intValue());
	}

	public static void f3() {
		List<? super Number> list = new ArrayList<>();
		list.add(new Integer(4));
		list.add(new Float(5.5));
		list.add(new Double(6.6));
		System.out.print(list + " ");

		Object ob = list.get(0);
		if (ob instanceof Integer) {
			System.out.println(((Integer) ob).intValue());
		}

		list = new ArrayList<Object>();
	}

	public static void callAdd() {
		System.out.println("\nString=" + add("AA", "BB"));
		System.out.println("Byte=" + add((byte) 1, (byte) 2));
		System.out.println("Short=" + add((short) 3, (short) 4));
		System.out.println("Integer=" + add(Integer.valueOf(16), Integer.valueOf(17)));
		System.out.println("Long=" + add(5L, 6L));
		System.out.println("Float=" + add(7.7F, 8.8F));
		System.out.println("Double=" + add(9.9D, 11.11D));
		System.out.println("BigInteger=" + add(BigInteger.valueOf(12), BigInteger.valueOf(13)));
		System.out.println("BigDecimal=" + add(BigDecimal.valueOf(14.14), BigDecimal.valueOf(15.15)));
	}

	@SuppressWarnings("finally")
	public static <T> T add(T ob1, T ob2) {
		if (ob1 instanceof String && ob2 instanceof String) {
			return (T) (ob1.toString() + ob2.toString());
		} else if (ob1 instanceof Byte && ob2 instanceof Byte) {
			return (T) Byte.valueOf((byte) ((Byte) ob1 + (Byte) ob2));
		} else if (ob1 instanceof Short && ob2 instanceof Short) {
			return (T) Short.valueOf((short) ((Short) ob1 + (Short) ob2));
		} else if (ob1 instanceof Integer && ob2 instanceof Integer) {
			return (T) Integer.valueOf((Integer) ob1 + (Integer) ob2);
		} else if (ob1 instanceof Long && ob2 instanceof Long) {
			return (T) Long.valueOf((Long) ob1 + (Long) ob2);
		} else if (ob1 instanceof Float && ob2 instanceof Float) {
			return (T) Float.valueOf((Float) ob1 + (Float) ob2);
		} else if (ob1 instanceof Double && ob2 instanceof Double) {
			return (T) Double.valueOf((Double) ob1 + (Double) ob2);
		} else if (ob1 instanceof BigInteger && ob2 instanceof BigInteger) {
			return (T) BigInteger.valueOf((((BigInteger) ob1).longValue() + ((BigInteger) ob2).longValue()));
		} else if (ob1 instanceof BigDecimal && ob2 instanceof BigDecimal) {
			return (T) BigDecimal.valueOf((((BigDecimal) ob1).doubleValue() + ((BigDecimal) ob2).doubleValue()));
		}
		try {
			return null;
		} finally {
			throw new IllegalArgumentException(
					"Wrong types " + ob1.getClass().getName() + " and " + ob2.getClass().getName() + " !");
		}
	}
}