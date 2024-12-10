package textadventure;

import java.util.Random;
import java.util.Scanner;

class BronzeChest extends Chest {

    private static final String[] ITEMS = {
        "Chipped Sword",
        "Cracked Helmet",
        "Lesser Health Potion",
        "Copper Ring"
    };

    public BronzeChest() {
        super("Bronze Chest"); // Correctly passing a single String
    }

    @Override
    public String open() {
        Random random = new Random();
        int index = random.nextInt(ITEMS.length); // Randomly select an item
        return ITEMS[index];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory(); // Assuming Inventory class exists

        // Create a Bronze Chest and open it
        BronzeChest bronzeChest = new BronzeChest();
        String droppedItem = bronzeChest.open();
        System.out.println("The Bronze Chest contains: " + droppedItem);

        // Prompt player to add the item to their inventory
        while (true) {
            System.out.println("Do you want to add the " + droppedItem + " to your inventory? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("yes")) {
                inventory.addEquipment(droppedItem);
                System.out.println(droppedItem + " has been added to your inventory.");
                break;
            } else if (response.equals("no")) {
                System.out.println("You chose not to add the " + droppedItem + " to your inventory.");
                break;
            } else {
                System.out.println("Invalid response. Please enter 'yes' or 'no'.");
            }
        }

        // Display the inventory after the interaction
        inventory.displayInventory();
    }
}
