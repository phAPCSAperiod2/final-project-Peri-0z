import java.util.Scanner;

public class Craft{
    private String item;
    private String material;

    public Craft(String item, String material) {
        this.item = item;
        this.material = material;
    }

    public static String craftingProcess(){
        System.out.println("What do you want to craft? (Sword / Axe / Shield)");
        System.out.print("> ");
        String item = scanner.nextLine();

        System.out.println("Choose material (Bronze / Iron / Steel)");
        System.out.print("> ");
        String material = scanner.nextLine();

        // String quality = calculateQuality(item, material); AFTER MVP

        Craft craft = new Craft(item, material);

        System.out.println("You crafted a " + material + " " + item + "!");
        // System.out.println("Quality: " + quality); AFTER MVP

        return craft;
    }

    public String getItem() {
        return item;
    }

    public String getMaterial() {
        return material;
    }
}
