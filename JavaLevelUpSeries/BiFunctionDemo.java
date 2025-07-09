package JavaLevelUpSeries;

import java.util.function.BiFunction;

//BiFunction to add two numbers.
public class BiFunctionDemo {
	public static void main(String[] args) {

		BiFunction<Integer, Integer, Integer> adder = (a, b) -> a + b;
		Integer result = adder.apply(10, 25);

		System.out.println("Result of our BiFunction: " + result);
	}

}
