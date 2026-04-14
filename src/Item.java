public class Item {
    /* SAVE THIS FOR MVP.
     THE ENTIRE ITEM.JAVA CLASS IS USELESS
     UNTIL YOU DECIDE TO ADD IN ITEM QUALITY
    */
    private String item;
    private String material;
    private String quality; // Will not be used until MVP is complete.

    public Item(String item, String material, String quality){
        this.item = item;
        this.material = material;
        this.quality = quality;
    }

    public Item(String item, String material){
        this.item = item;
        this.material = material;
        this.quality = "good";
    }

    public String getItem(){
        return item;
    }

    public String getMaterial(){
        return material;
    }

    public String getQuality(){
        return quality;
    }
}
