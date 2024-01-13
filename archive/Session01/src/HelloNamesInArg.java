public class HelloNamesInArg {
    public static void main(String[] args) {
        System.out.println("Welcome to Hello Names application.");

        for (String name : args) {
            System.out.println(" - Hello dear " + name);
        }

        System.out.println("Have a nice day!");
    }
}
