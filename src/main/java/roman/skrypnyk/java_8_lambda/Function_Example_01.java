package roman.skrypnyk.java_8_lambda;

import java.util.function.Function;

public class Function_Example_01 {

	public static void main(String[] args) {
		//Ex1
		Function<Integer, Integer> function1 = x -> x*x+1;
		System.out.println(function1.apply(2));

		Function<String,Integer> function2 = String::length;
		System.out.println("The length of given string is: " + function2.apply( "Europe"));

		//Ex2
		Function<Integer,Integer> function3 = x -> x*2;
		Function<Integer,Integer> function4 = x -> x*x*x;

		System.out.println(function3.andThen(function4).apply(2)); // f3 to f4
		System.out.println(function3.compose(function4).apply(2));// f4 to f3

	}

}
