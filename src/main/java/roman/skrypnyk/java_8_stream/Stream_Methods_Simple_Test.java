package roman.skrypnyk.java_8_stream;

import java.util.*;

public class Stream_Methods_Simple_Test {

	public static void main(String[] args) {
		//Ex1 sum, min, max
		List<Integer> numsArray = Arrays.asList(1,null,2);
		int sum1 = numsArray.stream().filter(x -> x != null).mapToInt(Integer::intValue).sum();
		int sum2 = numsArray.stream().filter(x -> x != null).reduce(0,(a,b) -> a + b);

		Optional<Integer> minVal = numsArray.stream().filter(Objects::nonNull).min((val1, val2) -> {
																					return val1.compareTo(val2);
																					});

		Optional<Integer> maxVal = numsArray.stream().filter(Objects::nonNull).max((val1, val2) -> {
																						return val1.compareTo(val2);
																					});

		System.out.println("min: " + minVal.get());
		System.out.println("max: " + maxVal.get());
		System.out.println("stream map sum: " + sum2);

		//Ex2 reduce to one str and rotate
		List<String> strList = Arrays.asList("A","B","C","1");
		Optional<String> reducedStr = strList.stream().reduce((firtsVal, secondVal) -> secondVal + firtsVal);

		System.out.println("reduced and rotate: " + reducedStr.get());

		//Ex3 stream for Map
		Map<Integer, String> map = Map.of(
				0, "abc",
				1, "abc",
				2, "defg",
				3, "1234",
				4, "pqrst",
				5, "uvw",
				6, "xyz",
				7, "abc");

		long mapEvenCount = map.values().stream().filter(str -> str.length() % 2 == 0).count();
		long mapSumEvenCountLength = map.values().stream().filter(x -> x.length() % 2 == 0).mapToInt(String::length).sum();
														//distinct - remove duplicates
		Object[] resArrDistCount = map.values().stream().distinct().limit(7).toArray();
		List<String> listArrDistCount = map.values().stream().distinct().limit(100).toList();

		System.out.println("count of even length str: " + mapEvenCount);
		System.out.println("sum of the lengths of all even length strings (values): " + mapSumEvenCountLength);
		System.out.println("Array distinct limit:" + Arrays.toString(resArrDistCount));
		System.out.println("List distinct limit:" + listArrDistCount);

	}

}
