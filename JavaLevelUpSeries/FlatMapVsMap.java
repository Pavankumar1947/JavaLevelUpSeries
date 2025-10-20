package JavaLevelUpSeries;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapVsMap {
	public static void main(String[] args) {
		List<List<String>> data = Arrays.asList(Arrays.asList("Apple", "Banana"),
								  				Arrays.asList("Orange", "Mango"),
								  				Arrays.asList("Grapes", "Pineapple")
								  				);

		// Using map() → Stream<List<String>>
		List<List<String>> mappedList = data.stream().map(list -> list).collect(Collectors.toList());
		System.out.println(mappedList);

		// Using flatMap() → Stream<String>
		List<String> flatMappedList = data.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(flatMappedList);
	}
}
