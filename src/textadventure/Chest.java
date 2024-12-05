
package textadventure;

import java.util.Random;

public class Chest {
    private String[] items; //array to hold items
    
    public Chest(String[] items){
        this.items = items;
    }
    
    //method to open a chest
    public String opencChest(){
        Random random = new Random();
        int index = random.nextInt(items.length);
        return items[index];
    }
}
