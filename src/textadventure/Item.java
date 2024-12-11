package textadventure;
public class Item { //A super epic class that makes adding stats to items functional
    private String name;
    private int attackBonus;
    private int defenseBonus;
    private int healthBonus;
    private int speedBonus;
    private int critrateBonus;
    private ItemSlot slot;
    
    public Item(String name, int attackBonus, int defenseBonus, int healthBonus, int speedBonus, int critrateBonus, ItemSlot slot){
        this.name = name;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
        this.healthBonus = healthBonus;
        this.speedBonus = speedBonus;
        this.critrateBonus = critrateBonus;
        this.slot = slot;
    }
    
    public String getName(){
        return name;
    }
    public int getAttackBonus(){
        return attackBonus;
    }
    public int getDefenseBonus(){
        return defenseBonus;
    }
    public int getHealthBonus(){
        return healthBonus;
    }
    public int getSpeedBonus(){
        return speedBonus;
    }
    public int getCritRateBonus(){
        return critrateBonus;
    }
    public ItemSlot getSlot(){
        return slot;
    }
    @Override
    public String toString(){
        return name + " (ATK: " + attackBonus + ", DEF: " +defenseBonus + ", HP: " + healthBonus + ", SPD: " + speedBonus + ", CRT: " + critrateBonus + ")";
    }
}
