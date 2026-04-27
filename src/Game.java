import java.util.Scanner;

public class Game {

    private static int day = 1;
    private static int customersServed = 0;
    private static int customersLost = 0;
    private static int totalCustomersServed = 0;
    private static int totalCustomersVisited = 0;
    public static void main(String[] args) throws Exception {

        System.out.println("=========================================");
        System.out.println("ForgeCraft v0.0.3");
        System.out.println("=========================================");

        boolean playing = true;
        Scanner scanner = new Scanner(System.in);

        while (playing){
            startDay(scanner);
            System.out.println("=========================================");
            System.out.println("Day " + (day - 1) + " finished!");
            System.out.println("Total customers served: " + totalCustomersServed + "/" + totalCustomersVisited);
            System.out.println("=========================================");

            System.out.println("Continue to next day? [Yes] [No]");
            System.out.print("> ");

            String input = scanner.nextLine().toLowerCase();

            if (!input.equals("yes") && !input.equals("y")) {
                playing = false;
                System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~ GAME FINISHED ~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

            System.out.println();
        }
        scanner.close();

    }

    public static void startDay(Scanner scanner){
        // Scanner scanner = new Scanner(System.in);
        int customersToday;
        if (day == 1) {
            customersToday = (int)(Math.random() * 4 - 2 + 1) + 2; // Range 2-4.
        } else {
            customersToday = (int)(Math.random() * 8 - 6 + 1) + 6; // Range 6-8
        }

        customersServed = 0;
        customersLost = 0;

        System.out.println("Day " + day);
        System.out.println("Customers Today: " + customersToday);
        System.out.println();

        while(customersServed + customersLost < customersToday){

            // Convert into gameplay loop when MVP is met.
            Customer customer = Customer.spawnRandom();
            System.out.println("[" + customer.getName() + "]: ''Hello, I'd like a " + customer.getOrderMaterial() + " " + customer.getOrder() + " please.''");
            System.out.println("Serve customer? [Yes] [No]");
            System.out.print(">");

            // Scan for user input. If "yes" flag as a served customer. If "no", do not count as customer served.
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes") || input.equals("y")){
                Item craftedItem = Craft.craftingProcess();
                craftedItem = Craft.checkCraftedItem(craftedItem, customer, scanner);

                // Check if correct item was crafted
                if (craftedItem.getItem().equalsIgnoreCase(customer.getOrder()) &&
                    craftedItem.getMaterial().equalsIgnoreCase(customer.getOrderMaterial())) {

                    customersServed++;
                    totalCustomersServed++;
                    totalCustomersVisited++;

                    System.out.println("\nPerfect! " + customer.getName() + " is happy.\n");
                } else {
                    customersLost++;
                    totalCustomersVisited++;

                    System.out.println("\n[" + customer.getName() + "]: ''That's not what I ordered!''\n");
                }

    System.out.println("(" + customersServed + "/" + customersToday + " Orders Fulfilled.)");
                if (customersServed + customersLost < customersToday){
                    System.out.println("Another customer approaches your shop...");
                    System.out.println();
                } else {
                    System.out.println("Seems like nobody else is coming to your shop.");
                    System.out.println();
                }
            } else if (input.equals("no") || input.equals("n")){
                customersLost++;
                totalCustomersVisited++;
                System.out.println("\n" + customer.getName() + " left unhappy. (" + customersServed + "/" + customersToday + " Orders Fulfilled.)");
                if (customersServed + customersLost < customersToday){
                    System.out.println("Another customer approaches your shop...");
                    System.out.println();
                } else {
                    System.out.println("Seems like nobody else is coming to your shop.");
                    System.out.println();
                }
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }

        day++;
    }

}
