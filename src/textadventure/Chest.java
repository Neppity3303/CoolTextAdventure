package textadventure;
//pretty sure I'm not using this properly but I am too afraid to delete it.
// Base Chest Class
public class Chest {
    private String chestType;

    public Chest(String chestType) { //initialize the chest type. This is not properly utilized in the bronze chest class.
        this.chestType = chestType;
    }

    public String getChestType() { //this would be useful if I had more chests, but I am a humble java 1 student
        return chestType;
    }
}
