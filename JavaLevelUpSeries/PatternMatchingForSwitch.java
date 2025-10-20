package JavaLevelUpSeries;

public class PatternMatchingForSwitch {

	    public static void main(String[] args) {
	        Object obj = "Java";

	        // 🧓 Old Way
	        if (obj instanceof String) {
	            String s = (String) obj; // manual cast
	            System.out.println("Old Way: String length = " + s.length());
	        } else if (obj instanceof Integer) {
	            Integer i = (Integer) obj;
	            System.out.println("Old Way: Double value = " + (i * 2));
	        }

	        // 🚀 New Way (Pattern Matching for switch - Java 17+)
	        switch (obj) {
	            case String s   -> System.out.println("New Way: String length = " + s.length());
	            case Integer i  -> System.out.println("New Way: Double value = " + (i * 2));
	            case null       -> System.out.println("New Way: It's null!");
	            default         -> System.out.println("New Way: Unknown type");
	        }
	    }
	}
