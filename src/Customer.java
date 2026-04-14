public class Customer {

    private String name;
    private String order;
    private String orderMaterial;
    private int satisfaction;

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
        String[] materials = {"Bronze", "Iron", "Steel"};
        String[] items = {"Sword", "Shield", "Axe"};

        String name = names[(int)(Math.random() * names.length)];
        String material = materials[(int)(Math.random() * materials.length)];
        String item = items[(int)(Math.random() * items.length)];

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
