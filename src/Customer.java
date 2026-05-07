 /**
  * The Customer class represents a customer in the ForgeCraft game.
  * Each customer has a name, an order (item), a material preference.
  */
public class Customer {

    /** The name of the customer. */
    private String name;

    /** The item the customer wants crafted. */
    private String order;

    /** The material the customer wants the item made from. */
    private String orderMaterial;

    /**
     * A 2D array containing possible orders and materials.
     * Index 0 contains item types, index 1 contains material types.
     */
    public static String[][] orders = {
        {"Dagger", "Sword", "Katana", "Greatsword", "Rapier", "Spear", "Mace", "Hammer", "Greathammer", "Cleaver", "Axe", "Greataxe", "Claws", "Cutlass", "Halberd", "Lance", "Shield", "Greatshield", "Bow", "Longbow", "Flintlock", "Musket", "Armor", "Leggings", "Helmet"},
        {"Stone", "Flint", "Copper", "Tin", "Bronze", "Brass", "Iron", "Steel", "Silver", "Gold", "Diamond", "Platinum", "Arcanium", "Mithril", "Dragonsteel"}
    };

    /**
     * Constructs a Customer with a specified name, material, and order.
     *
     * @param name the name of the customer
     * @param orderMaterial the material the customer wants
     * @param order the item the customer wants crafted
     */
    public Customer(String name, String orderMaterial, String order){
        this.name = name;
        this.orderMaterial = orderMaterial;
        this.order = order;
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
     * Generates and returns a randomly created Customer.
     * The name, item, and material are selected randomly from predefined lists.
     *
     * @return a randomly generated Customer
     */
    public static Customer spawnRandom() {
        String[] names = {
        "Aaron", "Abel", "Adam", "Adrian", "Aidan", "Alexander", "Alfred", "Albert", "Alaric", "Aldric", "Alvaro", "Arthur", "Arnold", "Andrew", "Augustus", "Ambrose", "Amos", "Abelard", "Archibald",
        "Basil", "Bernard", "Bertram", "Beatrice", "Bianca", "Boris", "Bruno", "Bartholomew", "Benedict", "Benjamin", "Bridget", "Brian",
        "Charles", "Catherine", "Cecilia", "Cedric", "Colin", "Conrad", "Claire", "Clara", "Caroline",
        "David", "Daniel", "Damian", "Dominic", "Douglas", "Duncan", "Desmond", "Derek",
        "Edward", "Edmund", "Edwin", "Edgar", "Elias", "Elijah", "Eleanor", "Elizabeth", "Eric", "Ernest", "Eugene",
        "Felix", "Frederick", "Francis", "Frank", "Fiona", "Flora",
        "George", "Gabriel", "Gregory", "Gwen", "Greta", "Gareth",
        "Henry", "Harold", "Hugh", "Hugo", "Helena", "Helen", "Harriet", "Hector",
        "Isaac", "Ivan", "Ingrid", "Irene",
        "John", "James", "Joseph", "Jonathan", "Julian", "Julius", "Jasper",
        "Katherine", "Kate", "Karl", "Kenneth", "Kevin",
        "Leon", "Leonard", "Lawrence", "Louis", "Lucy", "Lucas", "Luke", "Lydia", "Lancelot", "Lionel",
        "Matthew", "Michael", "Marcus", "Martin", "Margaret", "Mary", "Maria", "Martha", "Maurice", "Morgan", "Milo",
        "Nicholas", "Nathan", "Nigel", "Noah", "Nora", "Norman",
        "Oliver", "Olivia", "Oscar", "Owen", "Otto",
        "Paul", "Peter", "Philip", "Patrick", "Percy", "Penelope",
        "Quinn",
        "Robert", "Richard", "Roger", "Raymond", "Ronald", "Rowan", "Roland", "Rosalind", "Rebecca", "Roderick",
        "Samuel", "Simon", "Stephen", "Sarah", "Sophia", "Stella", "Sebastian", "Scott",
        "Thomas", "Theodore", "Timothy", "Tobias", "Tristan", "Theresa",
        "Ulysses", "Ursula", "Ulrich",
        "Victor", "Vincent", "Valerie", "Veronica", "Vivian", "Viola",
        "William", "Walter", "Wallace", "Warren", "Wesley",
        "Xavier",
        "Yusuf",
        "Zachary", "Zoe"};

        String name = names[(int)(Math.random() * names.length)];
        int index = (int)(Math.random() * orders.length);

        String item = orders[0][(int)(Math.random() * orders[0].length)];
        String material = orders[1][(int)(Math.random() * orders[1].length)];

        return new Customer(name, material, item);
    }

    /**
     * Array of possible greeting dialogue lines used when customers place an order.
     * Each string contains format specifiers for material (%s) and item (%s).
     * Some greetings are preset with certain weapons for additional story immersion.
     */
    public static String[] greetings = {
        "Hello there! Could you forge me a %s %s?",
        "Greetings, smith. I need a %s %s.",
        "Hey! I'm looking for a %s %s.",
        "Think you can make me a %s %s?",
        "I've got shillings if you've got a %s %s.",
        "Traveler here-I'm in need of a reliable %s %s.",
        "A job well done earns shillings: craft me a %s %s.",
        "My journey demands a strong %s %s.",
        "The road is dangerous... I require a %s %s.",
        "A noble request: fashion me a %s %s.",
        "For a service, I need a %s %s.",
        "No questions asked-just make me a %s %s."
    };

    /**
     * Array of possible dialogue lines used when a customer receives a perfect item.
     */
    public static String[] reactionsPerfect = {
        "This is perfect! Exactly what I wanted!",
        "Incredible craftsmanship!",
        "You've got real talent, smith.",
        "Worth every shilling.",
        "Have you considered getting your name noticed by the king?",
        "You should come to the Azura Province! We could use people like you.",
        "Wow, thanks!",
        "Here, will you take anything extra from me as gratitude? No? Shame... You really deserve it!",
        "It's nice to know that thanks to people like you, Aetheria will not only be well-supplied, but also well-defended.",
        "I love it!",
        "Literal miracle worker. Awesome job.",
        "Keep this up, and I'm sure you'll be famous in no time!",
    };

    /**
    * Array of possible dialogue lines used when a customer receives a partially correct item.
    */
    public static String[] reactionsPartial = {
       "It'll do... but not quite right.",
       "Hmm... not the material I asked for.",
       "Close enough, I suppose.",
       "Mediocre at best, subpar at worst.",
       "...I'll consider coming back here. Maybe. Probably not.",
       "Try a little harder next time. I'll still pay for this, but I'm not happy.",
       "And you charge this much for this crap!? Whatever. Take my money.",
       "You should REALLY pay attention next time.",
       "My friend, really? This is the best you can do? I'll take it... I guess.",
       "Have you considered trying something else? Something better?",
       "Ehhhhhh... okay.",
       "I don't know if this will be necessary for it to be made out of this..."
    };

    /**
     * Array of possible dialogue lines used when a customer receives an incorrect item.
    */
    public static String[] reactionsFail = {
        "What is this supposed to be?!",
        "This isn't what I ordered!",
        "Completely wrong!",
        "Are you blind AND deaf!?",
        "Are you TRYING to run a business or a scam?",
        "I hope your business goes under.",
        "Do I look like some kind of fool to you?",
        "Real nice talent! You've got a bright future... being burned at the stake for your incompetence.",
        "Trying to pull a fast one over me, huh?",
        "How disappointing...",
        "Why, I oughta smack some sense into you!",
        "I'm leaving, and I'm not paying for this.",
    };

    /**
     * Array of possible dialogue lines used when a customer is turned down before service.
    */
    public static String[] reactionsTurnedDown = {
        "Seriously? I needed that...",
        "Wow. Terrible service.",
        "I'll take my business elsewhere.",
        "Unbelievable... I thought this was a forge.",
        "Fine. I didn't need it anyway.",
        "Guess I'll find a real blacksmith.",
        "What a waste of time.",
        "Turning me away? For what reason!?",
        "Would you still be doing the same if you knew I was important...?",
        "You just lost a customer!",
        "Idiot.",
        "Whatever, I'm going to the tavern. Didn't need anything from you anyways.",
    };

    /**
    * Returns a random string from the provided array of dialogue lines.
    *
     * @param lines the array of possible dialogue strings
    * @return a randomly selected string from the array
    */
    public static String getRandomLine(String[] lines) {
        return lines[(int)(Math.random() * lines.length)];
    }


    /**
     * Debug method that spawns a predefined customer named John.
     *
     * @return a Customer named John with a fixed order
     */
    public static Customer spawnJohn(){
        return new Customer("John", "Bronze", "Sword");
    }

    /**
     * Returns a string representation of the customer.
     *
     * @return a formatted string containing customer details
     */
    @Override
    public String toString(){
        return name + " | Order: " + order;
    }
}
