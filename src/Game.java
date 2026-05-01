import java.util.Scanner;

/**
 * The Game class runs the main loop for the ForgeCraft simulation game.
 * It manages days, customers, scoring, and overall game progression.
 */
public class Game {

    /** The current in-game day. */
    private static int day = 1;

    /** Number of customers successfully served in the current day. */
    private static int customersServed = 0;

    /** Number of customers lost in the current day. */
    private static int customersLost = 0;

    /** Total number of customers served across all days. */
    private static int totalCustomersServed = 0;

    /** Total number of customers who visited across all days. */
    private static int totalCustomersVisited = 0;

    /** The player's total accumulated score. */
    private static int totalScore = 0;

    /**
     * The main method that starts the game and controls the overall game loop.
     *
     * @param args command-line arguments (not used)
     * @throws Exception if an unexpected error occurs
     */
    public static void main(String[] args) throws Exception {

        System.out.println("=========================================");
        System.out.println("ForgeCraft v0.0.3");
        System.out.println("=========================================");
        System.out.println("You are a novice blacksmith in the kingdom of Aetheria.\nServe as many customers as you can to the best of your ability.\nThe more accurate and higher quality your crafted items are, the better your score will be.\nGet the highest score possible!\n");

        boolean playing = true;
        Scanner scanner = new Scanner(System.in);

        while (playing){
            startDay(scanner);
            System.out.println("=========================================");
            System.out.println("Day " + (day - 1) + " finished!");
            System.out.println("Total customers served: " + totalCustomersServed + "/" + totalCustomersVisited);
            if (totalScore < 0){
                totalScore = 0;
            }
            System.out.println("Total Score: " + totalScore);
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

    /**
     * Simulates a single day in the game.
     * Generates customers, processes player decisions, and updates scores.
     *
     * @param scanner the Scanner object used for user input
     */
    public static void startDay(Scanner scanner){
        // Scanner scanner = new Scanner(System.in);

        int customersToday;

        // Determine number of customers based on the day
        if (day <= 1) {
            customersToday = (int)(Math.random() * 3) + 2; // Range 2-4.
        } else {
            customersToday = (int)(Math.random() * 3) + 6; // Range 6-8
        }

        customersServed = 0;
        customersLost = 0;

        System.out.println("Day " + day);
        System.out.println("Customers Today: " + customersToday);
        System.out.println();

        // Loop through all customers for the day
        while (customersServed + customersLost < customersToday) {

            Customer customer = Customer.spawnRandom();

            boolean validInput = false;
            int bonus = 0;

            // Handle player decision for each customer
            while (!validInput) {
                System.out.println("[" + customer.getName() + "]: ''Hello, I'd like a "
                + customer.getOrderMaterial() + " " + customer.getOrder() + " please.''");
                System.out.println("Serve customer? [Yes] [No]");
                System.out.print("> ");

                String input = scanner.nextLine().trim().toLowerCase();

                if (input.equals("yes") || input.equals("y")) {
                    validInput = true;

                    // Begin crafting process
                    Item craftedItem = Craft.craftingProcess();
                    craftedItem = Craft.checkCraftedItem(craftedItem, customer, scanner);

                    boolean correctItem = craftedItem.getItem().equalsIgnoreCase(customer.getOrder());
                    boolean correctMaterial = craftedItem.getMaterial().equalsIgnoreCase(customer.getOrderMaterial());

                    // Perfect match: correct item and material
                    if (correctItem && correctMaterial) {

                        bonus = 100 + craftedItem.getQualityBonus();
                        customersServed++;
                        totalCustomersServed++;
                        totalCustomersVisited++;
                        totalScore += bonus;

                        System.out.println("\nPerfect! " + customer.getName() + " is happy.\n");
                        System.out.println("Score: +" + bonus + "!");
                        System.out.println("Total Score: " + totalScore);

                    }
                    // Partial match: correct item only
                    else if (correctItem) {

                        bonus = 50 + craftedItem.getQualityBonus();
                        customersServed++;
                        totalCustomersServed++;
                        totalCustomersVisited++;
                        totalScore += bonus;

                        System.out.println("\n[" + customer.getName() + "]: ''Thank you, I'll take this. I wanted it to be made with "
                            + customer.getOrderMaterial() + " though...''\n");
                        System.out.println("Score: +" + bonus + "!");
                        System.out.println("Total Score: " + totalScore);

                    }
                    // Incorrect item
                    else {

                        bonus = -100;
                        customersLost++;
                        totalCustomersVisited++;
                        totalScore += bonus;

                        System.out.println("\n[" + customer.getName() + "]: ''That's not what I ordered!''\n");
                        System.out.println("Score: " + bonus + "!");
                        System.out.println("Total Score: " + totalScore);
                    }

                } else if (input.equals("no") || input.equals("n")) {
                    validInput = true;

                    customersLost++;
                    totalCustomersVisited++;

                    System.out.println("\n" + customer.getName() + " left unhappy.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            }

            System.out.println("(" + customersServed + "/" + customersToday + " Orders Fulfilled.)");

            if (customersServed + customersLost < customersToday) {
                System.out.println("Another customer approaches your shop...\n");
            } else {
                System.out.println("Seems like nobody else is coming to your shop.\n");
            }
        }

        // Move to the next day
        day++;
    }

}
