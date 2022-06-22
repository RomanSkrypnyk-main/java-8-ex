package roman.skrypnyk.java_8_lambda;

import java.util.function.Predicate;

public class Predicate_Example_01 {

	public static void main(String[] args) {
		//Ex1 num(x) is grater than given num
		Predicate<Integer> integerPredicate = x -> (x > 3);
		System.out.println(integerPredicate.test(10)); //true
		System.out.println(integerPredicate.test(-1)); //false

		//Ex2 length string(str) grater than
		Predicate<String> stringPredicate1 = str -> (str.length() > 0 );
		System.out.println(stringPredicate1.test("")); //false
		System.out.println(stringPredicate1.test("0")); //true

		//Ex3
		Predicate<String> stringPredicate2 = str -> (str.length() > 2 && str.contains("a"));
		String[] stringArray = {"aaa", "bbb", "ccc", "cba", ""};
		for(String s : stringArray){
			if(stringPredicate2.test(s)){
				System.out.println(s);
			}
		}
	}

}
