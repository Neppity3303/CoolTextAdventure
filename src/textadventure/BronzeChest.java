package textadventure;

import java.util.Random;

class BronzeChest extends Chest {

    // A list of items that can be dropped
    private static final Item[] ITEMS = {
        new Item("Chipped Sword", 5, 0, 0, 0, 2, ItemSlot.WEAPON),
        new Item("Cracked Helmet", 0, 3, 0, 0, 0, ItemSlot.HELMET),
        new Item("Lesser Health Potion", 0, 0, 5, 0, 0, ItemSlot.CONSUMABLE),
        new Item("Copper Ring", 0, 1, 0, 2, 2, ItemSlot.ACCESSORY)
    };

    public BronzeChest() {
        super("Bronze Chest"); // Calls on the parent Chest class
    }

    public Item open() {
        Random random = new Random();
        int index = random.nextInt(ITEMS.length); // Randomly select an item
        Item droppedItem = ITEMS[index];
        return droppedItem;
    }
}
