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
        System.out.print("> ");
        String item = scanner.nextLine();

        System.out.println("\n╔══════════════════════╗");
        System.out.println("║     MATERIAL BOX     ║");
        System.out.println("╚══════════════════════╝");

        for (String material : Customer.orders[1]) {
            System.out.println("| " + material);
        }
        System.out.print("> ");
        String material = scanner.nextLine();

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



}
