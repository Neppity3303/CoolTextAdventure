package textadventure;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    private ArrayList<Equipment> equipmentList;

    public Inventory() {
        equipmentList = new ArrayList<>();
    }

    // Adds equipment and confirms replacement if the slot is already occupied
    public void addEquipment(String slot, String item) {
        Scanner scanner = new Scanner(System.in);

        for (Equipment equipment : equipmentList) {
            if (equipment.getSlot().equalsIgnoreCase(slot)) {
                System.out.println("The " + slot + " slot already has " + equipment.getItem() + ".");

                String response;
                do {
                    System.out.println("Do you want to replace it with " + item + "? (yes/no)");
                    response = scanner.nextLine().trim().toLowerCase();

                    if (response.equalsIgnoreCase("yes")) {
                        equipment.setItem(item);
                        System.out.println("Replaced " + equipment.getItem() + " with " + item + " in the " + slot + " slot.");
                        return;
                    } else if (response.equalsIgnoreCase("no")) {
                        System.out.println("Keeping " + equipment.getItem() + " in the " + slot + " slot.");
                        return;
                    } else {
                        System.out.println("Invalid response. Please type 'yes' or 'no'.");
                    }
                } while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no"));
            }
        }

        System.out.println("Equipping " + item + " in the " + slot + " slot.");
        equipmentList.add(new Equipment(slot, item));
    }

    // Display equipped items
    public void displayInventory() {
        System.out.println("Equipped Items:");
        if (equipmentList.isEmpty()) {
            System.out.println("No items equipped.");
        } else {
            for (Equipment equipment : equipmentList) {
                System.out.println(equipment.getSlot() + ": " + equipment.getItem());
            }
        }
    }
}