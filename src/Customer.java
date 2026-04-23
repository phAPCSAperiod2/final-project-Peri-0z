public class Customer {

    private String name;
    private String order;
    private String orderMaterial;
    private int satisfaction;
    public static String[][] orders = {
        {"Dagger", "Sword", "Katana", "Scimitar", "Saber", "Greatsword", "Cleaver", "Rapier", "Lance", "Spear", "Mace", "Staff", "Hammer", "Greathammer", "Axe", "Greataxe", "Halberd", "Claws", "Shield", "Greatshield", "Bow", "Longbow", "Flintlock", "Musket", "Falchion"},
        {"Stone", "Copper", "Bronze", "Iron", "Steel", "Silver", "Gold", "Diamond", "Obsidian", "Titanium"}
    };

    // Constructor for end product customer.
    public Customer(String name, String orderMaterial, String order, int satisfaction){
        this.name = name;
        this.orderMaterial = orderMaterial;
        this.order = order;
        this.satisfaction = satisfaction;
    }

    // [Debug] Constructor for MVP Customer.
    public Customer (String name, String order){
        this.name = name;
        this.order = order;
        this.satisfaction = 0;
    }

    public String getName(){
        return name;
    }

    public String getOrderMaterial(){
        return orderMaterial;
    }

    public String getOrder(){
        return order;
    }

    public int getSatisfaction(){
        return satisfaction;
    }

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

    // [Debug] John Debug
    public static Customer spawnJohn(){
        return new Customer("John", "Bronze", "Sword", 3);
    }

    @Override
    public String toString(){
        return name + " | Order: " + order + " | Satisfaction: " + satisfaction + "/5 ";
    }
}
