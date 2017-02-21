package other;

import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		String[] array = { "_@BEST", "vovan", "vo", "Z@OZA" };
		for (String s : array) {
			System.out.println(checkWithRegExp(s) + "\t" + checkWithoutRegExp(s));
		}

//		or a or b or c <=> any char from a to c
		System.out.println(Pattern.matches("[abc]", "b") + "\n" +	 //true
						   Pattern.matches("[a-c]", "b"));			 //true

//		 any numbers from 0 to 9 from 1 to 3 times
		 System.out.println(Pattern.matches("[0-9]{1,3}", "6789")); //false
		
//		any digits any times >= 0
		System.out.println(Pattern.matches("[0-9]*", "6789")); //true
		
//		any digit either zero or one times
		System.out.println(Pattern.matches("[0-9]?", "3")); //true
		
//		any non digit symbol
		System.out.println(Pattern.matches("[^0-9]", "A")); //true

//		 any symbols from left, after it point and to end: or com or ru or ua
		 System.out.println(Pattern.matches(".+\\.(com|ru|ua)", "eugen@mail.ru")); // true
		
//		any space left or right or fully worlds BACON, bacon 
		String pattern = " *(BACON|bacon) *";
		System.out.println(Pattern.matches(pattern, "BACON")     	   + "\n" + //true
						   Pattern.matches(pattern, "  BACON")   	   + "\n" + //true
						   Pattern.matches(pattern, "BACON  ")   	   + "\n" + //true
						   Pattern.matches(pattern, "  BACON  ") 	   + "\n" + //true
						   Pattern.matches(pattern, "^BACON$")   	   + "\n" + //false
						   Pattern.matches(pattern, "  BACONbacon ")   + "\n" + //false
						   Pattern.matches(pattern, "bacon")); 					//true
		
//		 one from two chars: or "Т" or "т", or "и" or "й". Equals to group
//		 (Таиланд|Тайланд|таиланд|тайланд)
		pattern="[Тт]а[ий]ланд";
		System.out.println(Pattern.matches(pattern, "Таиланд")	+"\n"+	//true
						   Pattern.matches(pattern, "Тайланд")	+"\n"+	//true
						   Pattern.matches(pattern, "таиланд")	+"\n"+	//true
						   Pattern.matches(pattern, "тайланд"));		//true
		
//		 check IP address: any digits from 1 to 3 times and point. 4 times
		System.out.println(Pattern.matches("[0-9]{1,3}\\."
										 + "[0-9]{1,3}\\."
										 + "[0-9]{1,3}\\."
										 + "[0-9]{1,3}", "10.216.4.47")); //true
		
//		 any symbols more or equal one time and after it @mail.ru
		System.out.println(Pattern.matches(".+@mail.ru", "eugen_ua123@mail.ru"));
	}

	public static boolean checkWithRegExp(String userName) {
		return Pattern.matches("[a-z0-9_]{3,15}", userName);
	}

	public static boolean checkWithoutRegExp(String userName) {
		if (userName.length() < 3 || userName.length() > 15) {
			return false;
		}
		String pattern = "abcdefghijklmnopqrstuvwxyz0123456789_";
		for (char c : userName.toCharArray()) {
			if (pattern.indexOf(c) == -1)
				return false;
		}
		return true;
	}
}