package textadventure;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    private ArrayList<Item> items; //array list to store player items
    private Item[] equipmentSlots; //array for kinds of slots. Possibly poorly optimized or not utilized

    public Inventory() {
        items = new ArrayList<>(); //initializes the players inventory I think
        equipmentSlots = new Item[ItemSlot.values().length]; //should be the same thing but slots
    }

    public void addItem(Item item) { //add an item to the items array list
        items.add(item);
    }

    public void displayInventory() { //display the inventory. Not utilized in text adventure. I ran out of time + don't know how + chat gpt would ruin all my code
        System.out.println("Inventory Items:");
        for (int i = 0; i < items.size(); i++) { //Loop to display items. should display them all. I didn't test
            System.out.println(i + ") " + items.get(i)); //should print the items at the selected index
        }

        System.out.println("Equipped Items:");
        for (ItemSlot slot : ItemSlot.values()) { //for each statement instead of the for loop above
            int slotIndex = slot.ordinal();//get the index of the slot
            String equippedItem = equipmentSlots[slotIndex] == null ? "Empty" : equipmentSlots[slotIndex].toString();//check if the slot is empty
            System.out.println(slot + ": " + equippedItem);//print the slot name and the equipped item or empty
        }
    }

    public void equipItem(int itemIndex) { //method to equip an item
        if (itemIndex < 0 || itemIndex >= items.size()) {//check if the index is valid. Should never run!
            System.out.println("Invalid item index.");
            return;
        }

        Item itemToEquip = items.get(itemIndex); //get the item that needs to be equipped. calls on item class
        ItemSlot slot = itemToEquip.getSlot(); //find the slot of the item that needs to be equipped
        int slotIndex = slot.ordinal();//get the slot index

        Scanner scanner = new Scanner(System.in);
        if (equipmentSlots[slotIndex] != null) {//check if the slot is empty
            System.out.println("Slot " + slot + " is occupied by " + equipmentSlots[slotIndex].getName() +//print that the slot is taken
                    ". Replace it with " + itemToEquip.getName() + "? (yes/no)");//ask if the player wants to replace it. Not implemented in the game but it should work
            String response; //store the player response
            while (true) { //validate input
                response = scanner.nextLine();
                if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("no")) {
                    break;
                }
                System.out.println("Invalid response. Please type 'yes' or 'no'.");
            }
            if (response.equalsIgnoreCase("no")) { //don't equip the item
                System.out.println("Cancelled equipping.");
                return;
            }
        }

        equipmentSlots[slotIndex] = itemToEquip; //equip the item in the slot
        System.out.println("Equipped " + itemToEquip.getName() + " in slot " + slot); 
    }
}
