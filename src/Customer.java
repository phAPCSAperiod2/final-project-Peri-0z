 /**
  * The Customer class represents a customer in the ForgeCraft game.
  * Each customer has a name, an order (item), a material preference,
  * and a satisfaction level.
  */
public class Customer {

    /** The name of the customer. */
    private String name;

    /** The item the customer wants crafted. */
    private String order;

    /** The material the customer wants the item made from. */
    private String orderMaterial;

    /** The customer's satisfaction level. */
    private int satisfaction;

    /**
     * A 2D array containing possible orders and materials.
     * Index 0 contains item types, index 1 contains material types.
     */
    public static String[][] orders = {
        {"Dagger", "Sword", "Katana", "Greatsword", "Rapier", "Spear", "Mace", "Hammer", "Greathammer", "Axe", "Greataxe", "Claws", "Shield", "Greatshield", "Bow", "Longbow", "Flintlock", "Musket", "Armor"},
        {"Copper", "Bronze", "Iron", "Steel", "Silver", "Gold", "Diamond"}
    };

    /**
     * Constructs a Customer with a specified name, material, order, and satisfaction.
     *
     * @param name the name of the customer
     * @param orderMaterial the material the customer wants
     * @param order the item the customer wants crafted
     * @param satisfaction the initial satisfaction level of the customer
     */
    public Customer(String name, String orderMaterial, String order, int satisfaction){
        this.name = name;
        this.orderMaterial = orderMaterial;
        this.order = order;
        this.satisfaction = satisfaction;
    }

    /**
     * Debug constructor for creating a simplified customer with only a name and order.
     *
     * @param name the name of the customer
     * @param order the requested item
     */
    public Customer (String name, String order){
        this.name = name;
        this.order = order;
        this.satisfaction = 0;
    }

    /**
     * Gets the customer's name.
     *
     * @return the name of the customer
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the material the customer requested.
     *
     * @return the requested material
     */
    public String getOrderMaterial(){
        return orderMaterial;
    }

    /**
     * Gets the item the customer requested.
     *
     * @return the requested item
     */
    public String getOrder(){
        return order;
    }

    /**
     * Gets the customer's satisfaction level.
     *
     * @return the satisfaction value
     */
    public int getSatisfaction(){
        return satisfaction;
    }

    /**
     * Generates and returns a randomly created Customer.
     * The name, item, and material are selected randomly from predefined lists.
     *
     * @return a randomly generated Customer
     */
    public static Customer spawnRandom() {
        String[] names = {"Aarav", "Anna", "Borin", "Marcus", "Lena",
    "Kai", "Amara", "Darius", "Elena", "Hassan",
    "Iris", "Jasper", "Kira", "Leo", "Maya",
    "Nina", "Omar", "Rhea", "Soren", "Talia",
    "Viktor", "Zara",
    "Elias", "Freya", "Gideon", "Hana", "Idris",
    "Jonas", "Livia", "Milo", "Noor", "Orin",
    "Piper", "Quinn", "Rafael", "Selene", "Theo",
    "Uma", "Vera", "Wren", "Xander", "Yara",
    "Zayn",
    "Aria", "Blaise", "Celine", "Dante", "Esme",
    "Felix", "Gwen", "Hugo", "Ines", "Juno",
    "Keira", "Lucian", "Mira", "Nico", "Opal",
    "Paolo", "Reina", "Silas", "Tobias", "Valen",
    "Willow", "Yusuf"};
        String name = names[(int)(Math.random() * names.length)];
        int index = (int)(Math.random() * orders.length);

        String item = orders[0][(int)(Math.random() * orders[0].length)];
        String material = orders[1][(int)(Math.random() * orders[1].length)];

        return new Customer(name, material, item, 3);
    }

    /**
     * Debug method that spawns a predefined customer named John.
     *
     * @return a Customer named John with a fixed order
     */
    public static Customer spawnJohn(){
        return new Customer("John", "Bronze", "Sword", 3);
    }

    /**
     * Returns a string representation of the customer.
     *
     * @return a formatted string containing customer details
     */
    @Override
    public String toString(){
        return name + " | Order: " + order + " | Satisfaction: " + satisfaction + "/5 ";
    }
}
