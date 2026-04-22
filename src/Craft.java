import java.util.Scanner;

public class Craft{
    private String item;
    private String material;

    public Craft(String item, String material) {
        this.item = item;
        this.material = material;
    }

    public static Craft craftingProcess(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to craft? (Sword / Axe / Shield)");
        System.out.print("> ");
        String item = scanner.nextLine();

        System.out.println("Choose the " + item + "'s material: (Bronze / Iron / Steel)");
        System.out.print("> ");
        String material = scanner.nextLine();

        // String quality = calculateQuality(item, material); AFTER MVP

        Craft craft = new Craft(item, material);

        System.out.println("\nYou crafted a " + material + " " + item + "!");
        // System.out.println("Quality: " + quality); AFTER MVP

        return craft;
    }

    public static Craft checkCraftedItem(Craft craftedItem, Customer customer, Scanner scanner){
        while (true){
            System.out.println(customer.getName() + " has placed an order for a "
            + customer.getOrderMaterial() + " " + customer.getOrder() + ".");

            System.out.println("\nAre you sure you want to sell this to them? [Sell] [Retry]");
            System.out.print("> ");

            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("sell") || input.equals("s")) {
                return craftedItem;
            }
            else if (input.equals("retry") || input.equals("r")) {
                System.out.println("Alright, let's try forging again...\n");
                craftedItem = craftingProcess(); // restart crafting
            }
            else {
                System.out.println("Invalid input. Try again.");
                }
            }
        }

    public String getItem() {
        return item;
    }

    public String getMaterial() {
        return material;
    }
}
