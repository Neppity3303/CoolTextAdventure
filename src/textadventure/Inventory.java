package textadventure;
import java.util.ArrayList;

public class Inventory {

    private ArrayList<String> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void displayInventory() {
        System.out.println("Inventory Items:");
        for (int i = 0 ; i < items.size() ; i++) {
            System.out.println(i + ") " + items.get(i));
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem("Sword");
        inventory.addItem("Shield");
        inventory.addItem("Potion");

        inventory.displayInventory();
    }
}