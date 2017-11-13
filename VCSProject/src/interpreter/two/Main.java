package interpreter.two;

public class Main {

	public static void main(String args[]) {
		String str1 = "28 in Binary";
		String str2 = "28 in Hexadecimal";

		Client client = new Client(new Context());
		String result1 = client.interpret(str1);
		String result2 = client.interpret(str2);

		System.out.println(str1 + "= " + result1);
		System.out.println(str2 + "= " + result2);
	}
}
