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

    // [Debug] John Debug
    public static Customer spawnJohn(){
        return new Customer("John", "Bronze", "Sword", 3);
    }

    @Override
    public String toString(){
        return name + " | Order: " + order + " | Satisfaction: " + satisfaction + "/5 ";
    }
}
