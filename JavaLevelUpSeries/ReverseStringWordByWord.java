package JavaLevelUpSeries;

public class ReverseStringWordByWord {
	public static void main(String[] args) {
		String str = "java fullstack development";

		String reversed = reverseWordByWord(str);
		System.out.println("Reversed using loops: " + reversed);

		String streamReversed = reverseUsingStreams(str);
		System.out.println("Reversed using streams: " + streamReversed);
	}

	// Approach 1- Reverses each word in the string using traditional for-loop.
	public static String reverseWordByWord(String str) {
		String[] words = str.split(" ");

		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			for (int i = word.length() - 1; i >= 0; i--) {
				sb.append(word.charAt(i));
			}
			sb.append(" ");
		}
		return sb.toString().trim();
	}

	// Approach 2- Reverses each word in the string using Java Streams.
	private static String reverseUsingStreams(String str) {
//		return Arrays.stream(str.split(" ")).map(word -> new StringBuilder(word).reverse().toString())
//				.collect(Collectors.joining(" "));

		return new StringBuilder(str).reverse().toString();
	}

}
