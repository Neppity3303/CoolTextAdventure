package textadventure;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    private ArrayList<Item> items;
    private Item[] equipmentSlots;

    public Inventory() {
        items = new ArrayList<>();
        equipmentSlots = new Item[ItemSlot.values().length];
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayInventory() {
        System.out.println("Inventory Items:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ") " + items.get(i));
        }

        System.out.println("\nEquipped Items:");
        for (ItemSlot slot : ItemSlot.values()) {
            int slotIndex = slot.ordinal();
            String equippedItem = equipmentSlots[slotIndex] == null ? "Empty" : equipmentSlots[slotIndex].toString();
            System.out.println(slot + ": " + equippedItem);
        }
    }

    public void equipItem(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= items.size()) {
            System.out.println("Invalid item index.");
            return;
        }

        Item itemToEquip = items.get(itemIndex);
        ItemSlot slot = itemToEquip.getSlot();
        int slotIndex = slot.ordinal();

        Scanner scanner = new Scanner(System.in);
        if (equipmentSlots[slotIndex] != null) {
            System.out.println("Slot " + slot + " is occupied by " + equipmentSlots[slotIndex].getName() +
                    ". Replace it with " + itemToEquip.getName() + "? (yes/no)");
            String response;
            while (true) {
                response = scanner.nextLine();
                if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("no")) {
                    break;
                }
                System.out.println("Invalid response. Please type 'yes' or 'no'.");
            }
            if (response.equalsIgnoreCase("no")) {
                System.out.println("Cancelled equipping.");
                return;
            }
        }

        equipmentSlots[slotIndex] = itemToEquip;
        System.out.println("Equipped " + itemToEquip.getName() + " in slot " + slot);
    }
}
