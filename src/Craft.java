import java.util.Scanner;

/**
 * The Craft class handles all crafting-related mechanics in the game,
 * including item selection, material selection, refinement, and validation.
 */
public class Craft {

    /**
     * Runs the full crafting process for a player.
     * Prompts the user to choose an item, select a material,
     * and refine the item to determine its quality.
     *
     * @return the crafted Item object
     */
    public static Item craftingProcess() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════╗");
        System.out.println("║    GEAR INVENTORY    ║");
        System.out.println("╚══════════════════════╝");

        for (String weapon : Customer.orders[0]) {
            System.out.println("| " + weapon);
        }

        String item;
        while (true) {
            System.out.print("> ");
            item = scanner.nextLine().trim();

            if (isValidChoice(item, Customer.orders[0])) {
                item = normalizeChoice(item, Customer.orders[0]);
                break;
            } else {
                System.out.println("Invalid choice. Pick something you have.");
            }
        }

        System.out.println("\n╔══════════════════════╗");
        System.out.println("║     MATERIAL BOX     ║");
        System.out.println("╚══════════════════════╝");
        System.out.println("Choose your materials per the customer's request!\nYou will refine your item after this step.\nHigher grade materials will be harder\nto work with.");

        for (String material : Customer.orders[1]) {
            System.out.println("| " + material);
        }

        String material;
        while (true) {
            System.out.print("> ");
            material = scanner.nextLine().trim();

            if (isValidChoice(material, Customer.orders[1])) {
                material = normalizeChoice(material, Customer.orders[1]);
                break;
            } else {
                System.out.println("Invalid choice. Pick something you have.");
            }
        }

        String quality = determineQuality(scanner, material);
        Item craftedItem = new Item(item, material, quality);

        System.out.println("\nYou crafted a "+ quality.toUpperCase() + " QUALITY " + material.toUpperCase() + " " + item.toUpperCase() + "!");
        return craftedItem;
    }

    /**
     * Allows the player to confirm or retry selling a crafted item to a customer.
     *
     * @param craftedItem the item created by the player
     * @param customer the customer requesting the item
     * @param scanner the Scanner used for user input
     * @return the final Item chosen to be sold
     */
    public static Item checkCraftedItem(Item craftedItem, Customer customer, Scanner scanner) {

        while (true) {
            System.out.println(customer.getName() + " has placed an order for a "
                    + customer.getOrderMaterial() + " " + customer.getOrder() + ".");

            System.out.println("\nAre you sure you want to sell this to them? [Sell] [Retry]");
            System.out.print("> ");

            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("sell") || input.equals("s") || input.equals("yes") || input.equals("y")) {
                return craftedItem;
            }

            if (input.equals("retry") || input.equals("r") || input.equals("no") || input.equals("n")) {
                System.out.println("Alright, let's try forging again...\n");
                craftedItem = craftingProcess();
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    /**
     * Determines the quality of a crafted item based on a guessing mini-game.
     * The player has multiple attempts to match a randomly generated target value.
     *
     * @param scanner the Scanner used for input
     * @param material the selected material, which affects difficulty
     * @return a String representing the quality level
     */
    public static String determineQuality(Scanner scanner, String material) {
        int index = getMaterialIndex(material);
        int maxRange = getRangeFromIndex(index);

        int target = (int)(Math.random() * maxRange) + 1;
        int bestDiff = Integer.MAX_VALUE;

        System.out.println("\n╔══════════════════════╗");
        System.out.println("║      REFINEMENT      ║");
        System.out.println("╚══════════════════════╝");
        System.out.println("Refine your item for bonus points!\nHigher quality results mean higher bonuses.\nOn a scale from [1 - " + maxRange + "], how hard\ndo you strike with your hammer?");

        for (int attempt = 1; attempt <= 8; attempt++) {
            System.out.print("[Attempt " + attempt + "/8] >");

            int guess;

            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. That attempt counts.");
                scanner.nextLine();
                continue;
            }

            if (guess < 1 || guess > maxRange) {
                System.out.println("Out of range! That attempt counts.");
                continue;
            }

            int diff = Math.abs(target - guess);

            if (diff < bestDiff) {
                bestDiff = diff;
            }

            if (guess < target) {
                System.out.println("Too weak...");
            } else if (guess > target) {
                System.out.println("Too strong!");
            } else {
                System.out.println("Perfect strike!");
                break;
            }
        }

        // Determine final quality from BEST attempt
        if (bestDiff <= 2) return "Artisan";
        if (bestDiff <= 5) return "High";
        if (bestDiff <= 10) return "Good";
        if (bestDiff <= 40) return "Average";
        return "Poor";
    }

    /**
     * Checks if the user's input matches any valid option.
     *
     * @param input the user's input
     * @param options the list of valid options
     * @return true if the input matches an option, false otherwise
     */
    public static boolean isValidChoice(String input, String[] options) {
        for (String option : options) {
            if (option.equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Normalizes user input to match the proper formatting of a valid option.
     *
     * @param input the user's input
     * @param options the list of valid options
     * @return the correctly formatted option if found, otherwise the original input
     */
    public static String normalizeChoice(String input, String[] options) {
        for (String option : options) {
            if (option.equalsIgnoreCase(input)) {
                return option; // return properly formatted version
            }
        }
        return input;
    }

    /**
     * Gets the index of a material within the materials array.
     *
     * @param material the material to search for
     * @return the index of the material, or -1 if not found
     */
    public static int getMaterialIndex(String material) {
        for (int i = 0; i < Customer.orders[1].length; i++) {
            if (Customer.orders[1][i].equalsIgnoreCase(material)) {
                return i;
            }
        }
        return -1; // fallback (shouldn't happen)
    }

    /**
     * Determines the difficulty range based on material index.
     * Higher-tier materials result in larger ranges and increased difficulty.
     *
     * @param index the material index
     * @return the maximum range for the refinement mini-game
     */
    public static int getRangeFromIndex(int index) {
        if (index >= 0 && index <= 1) return 100;
        if (index >= 2 && index <= 4) return 250;
        if (index >= 5 && index <= 6) return 400;
        return 100; // default fallback
    }

}
