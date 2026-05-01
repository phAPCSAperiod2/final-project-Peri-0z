 /**
  * The Item class represents a crafted item in the ForgeCraft game.
  * Each item has a type, material, and quality level which affects scoring.
  */
public class Item {

    /** The type/name of the item (e.g., sword, axe, dagger). */
    private String item;

    /** The material the item is made from (e.g., iron, steel). */
    private String material;

    /** The quality level of the crafted item. */
    private String quality; // Will not be used until MVP is complete.

    /**
     * Constructs an Item with a specified type, material, and quality.
     *
     * @param item the type of item
     * @param material the material used to craft the item
     * @param quality the quality rating of the item
     */
    public Item(String item, String material, String quality){
        this.item = item;
        this.material = material;
        this.quality = quality.toLowerCase();
    }

    /**
     * Constructs an Item with a default quality of "good".
     *
     * @param item the type of item
     * @param material the material used to craft the item
     */
    public Item(String item, String material){
        this.item = item;
        this.material = material;
        this.quality = "good";
    }

    /**
     * Calculates the bonus score based on the item's quality.
     *
     * @return the numeric bonus value for the item's quality
     */
    public int getQualityBonus() {
        String q = quality.toLowerCase();
        if (q.equals("artisan")) {
            return 500;
        } else if (q.equals("high")) {
            return 75;
        } else if (q.equals("good")) {
            return 50;
        } else if (q.equals("average")) {
            return 15;
        } else {
            return 0; // poor or anything unexpected
        }
    }

    /**
     * Gets the type of the item.
     *
     * @return the item type
     */
    public String getItem(){
        return item;
    }

    /**
     * Gets the material used to craft the item.
     *
     * @return the material type
     */
    public String getMaterial(){
        return material;
    }

    /**
     * Gets the quality level of the item.
     *
     * @return the quality string
     */
    public String getQuality(){
        return quality;
    }
}
