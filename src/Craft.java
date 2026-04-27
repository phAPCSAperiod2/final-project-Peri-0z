import java.util.Scanner;

public class Craft {

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

        Item craftedItem = new Item(item, material);

        System.out.println("\nYou crafted a " + material.toUpperCase() + " " + item.toUpperCase() + "!");

        return craftedItem;
    }

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

    public static boolean isValidChoice(String input, String[] options) {
        for (String option : options) {
            if (option.equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }

    public static String normalizeChoice(String input, String[] options) {
        for (String option : options) {
            if (option.equalsIgnoreCase(input)) {
                return option; // return properly formatted version
            }
        }
        return input;
    }

}
