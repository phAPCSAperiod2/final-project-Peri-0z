public class Craft {
    private String item;
    private String material;
    private String quality; // Will not be used until MVP is complete.

    public Craft(String item, String material, String quality){
        this.item = item;
        this.material = material;
        this.quality = quality;
    }

    public Craft(String item, String material){
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
