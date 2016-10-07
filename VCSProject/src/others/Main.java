package others;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) {
		Method method = My.class.getDeclaredMethods()[0];
		Annotation annotation = method.getDeclaredAnnotations()[0];
		System.out.println(method.getName() + "\t" + annotation);
	}
}
