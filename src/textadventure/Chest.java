package textadventure;

// Base Chest Class
public class Chest {
    private String chestType;

    public Chest(String chestType) {
        this.chestType = chestType;
    }

    public String getChestType() {
        return chestType;
    }

    // Method to simulate opening the chest
    public String open() {
        return "The chest has been opened!";
    }
}
