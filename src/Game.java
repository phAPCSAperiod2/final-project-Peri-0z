import java.util.Scanner;

public class Game {

    private static int day = 1;
    private static int customersServed = 0;
    private static int customersLost = 0;
    public static void main(String[] args) throws Exception {
        System.out.println("=========================================");
        System.out.println("ForgeCraft v0.0.3");
        System.out.println("=========================================");

        startDay();

    }

    public static void startDay(){
        Scanner scanner = new Scanner(System.in);

        int customersToday = (int)(Math.random() * 3) + 2; // Range 2-4.

        System.out.println("Day " + day);
        System.out.println("Customers Today: " + customersToday);
        System.out.println();

        while(customersServed + customersLost < customersToday){

            // Convert into gameplay loop when MVP is met.
            Customer customer = Customer.spawnJohn();
            System.out.println("[Customer]: Hello, I'd like a " + customer.getOrderMaterial() + " " + customer.getOrder() + " please.");
            System.out.println("Serve customer? [Yes] [No]");
            System.out.print(">");

            // Scan for user input. If "yes" flag as a served customer. If "no", do not count as customer served.
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes") || input.equals("y")){
                customersServed++;
                System.out.println("Customer served! (" + customersServed + "/" + customersToday + " Orders Fulfilled.)");
                System.out.println();
            } else if (input.equals("no") || input.equals("n")){
                customersLost++;
                System.out.println("Customer left unhappy. (" + customersServed + "/" + customersToday + " Orders Fulfilled.)");
                System.out.println();
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }

        day++;
        scanner.close();
    }
}
