import java.util.Scanner;

public class Game {

    private static int day = 1;
    private static int customersServed = 0;
    private static int customersLost = 0;
    private static int totalCustomersServed = 0;
    private static int totalCustomersVisited = 0;
    private static int totalScore = 0;
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

    public static void startDay(Scanner scanner){
        // Scanner scanner = new Scanner(System.in);
        int customersToday;
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

        while (customersServed + customersLost < customersToday) {

            Customer customer = Customer.spawnRandom();

            boolean validInput = false;
            int bonus = 0;

            while (!validInput) {
                System.out.println("[" + customer.getName() + "]: ''Hello, I'd like a "
                + customer.getOrderMaterial() + " " + customer.getOrder() + " please.''");
                System.out.println("Serve customer? [Yes] [No]");
                System.out.print("> ");

                String input = scanner.nextLine().trim().toLowerCase();

                if (input.equals("yes") || input.equals("y")) {
                    validInput = true;

                    Item craftedItem = Craft.craftingProcess();
                    craftedItem = Craft.checkCraftedItem(craftedItem, customer, scanner);

                    boolean correctItem = craftedItem.getItem().equalsIgnoreCase(customer.getOrder());
                    boolean correctMaterial = craftedItem.getMaterial().equalsIgnoreCase(customer.getOrderMaterial());

                    if (correctItem && correctMaterial) {

                        bonus = 100;
                        customersServed++;
                        totalCustomersServed++;
                        totalCustomersVisited++;
                        totalScore += bonus;

                        System.out.println("\nPerfect! " + customer.getName() + " is happy.\n");
                        System.out.println("Score: +" + bonus + "!");
                        System.out.println("Total Score: " + totalScore);

                    }
                    else if (correctItem) {

                        bonus = 50;
                        customersServed++;
                        totalCustomersServed++;
                        totalCustomersVisited++;
                        totalScore += bonus;

                        System.out.println("\n[" + customer.getName() + "]: ''Thank you, I'll take this. I wanted it to be made with "
                            + customer.getOrderMaterial() + " though...''\n");
                        System.out.println("Score: +" + bonus + "!");
                        System.out.println("Total Score: " + totalScore);

                    }
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
        day++;
    }

}
