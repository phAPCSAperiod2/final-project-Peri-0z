public class Game {

    private static int day = 1;
    public static void main(String[] args) throws Exception {
        System.out.println("ForgeCraft v0.0.1");

        startDay();
    }

    public static void startDay(){
        int customersToday = (int)(Math.random() * 3) + 2; // Range 2-4.

        System.out.println("Day " + day);
        System.out.println("Customers Today: " + customersToday);

        day++;
    }
}
