package textadventure;
public class Equipment {
    //Helper class to represent a slot and its item
    private String slot;
    private String item;

    public Equipment(String slot, String item) {
        this.slot = slot;
        this.item = item;
    }

    public String getSlot() {
        return slot;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
