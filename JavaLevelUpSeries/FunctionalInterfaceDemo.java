package JavaLevelUpSeries;


@FunctionalInterface
interface GreetingService {
    void greet(String name);
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        // OLD WAY: Anonymous Inner Class
        GreetingService oldGreeting = new GreetingService() {
            @Override
            public void greet(String name) {
                System.out.println("Hello, " + name + "! (Old Way)");
            }
        };
        oldGreeting.greet("Pavan");

        // NEW WAY: Lambda Expression
        GreetingService newGreeting = (name) -> System.out.println("Hello, " + name + "! (Lambda Way)");
        newGreeting.greet("Developers");
    }

}