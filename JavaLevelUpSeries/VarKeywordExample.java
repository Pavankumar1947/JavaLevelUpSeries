package JavaLevelUpSeries;

import java.util.HashMap;
import java.util.Map;

public class VarKeywordExample {
    public static void main(String[] args) {

        //  Old Way
        Map<String, Integer> userAges = new HashMap<String, Integer>();
        userAges.put("Pavan", 25);
        userAges.put("Raj", 28);

        //  New Way (Java 10+)
        var cityPopulation = new HashMap<String, Integer>();
        cityPopulation.put("Bangalore", 10000000);
        cityPopulation.put("Hyderabad", 8000000);

        System.out.println("User Ages: " + userAges);
        System.out.println("City Population: " + cityPopulation);

        // Works for other types too 
        var message = "Hello, Java!";
        var number = 42;

        System.out.println(message + " Your number is " + number);
    }
}
