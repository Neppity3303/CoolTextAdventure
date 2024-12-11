package textadventure;

import java.util.Random;

public class Goblin implements Monster {
    private String playerName;
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    private int critrate;
    private int speed;
    private int experience;
    
    public Goblin(String name) {
        playerName = name;  // Set the player's name
        health = 15;        // Set initial health
        maxHealth = 15;     // Set max health
        attack = 5;         // Set attack value
        defense = 0;        // Set defense value
        critrate = 5;       // Set Critical Hit Rate
        speed = 5;          // Set speed value
        experience = 15;     // Set experience dropped
    }
    
    public int getHealth(){ //returns the stats for everything
        return health;
    }
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public int getExperience(){
        return experience;
    }
    public String getName(){
        return playerName;
    }
    public int getSpeed(){
        return speed;
    }
    
    public void attack(Player player) { //the same attack method as a wolf. For more information check the wolf class
        Random crit = new Random();
        int damage;

        if (crit.nextInt(100) < critrate) {
            // Critical hit logic
            damage = (this.attack * 2) - player.getDefense(); // Double damage on crit
            if (damage > 0) {
                player.takeDamage(damage);
                System.out.println(this.playerName + " attacks " + player.getName() + " for " + damage + " damage (Critical hit)!");
            } else {
                System.out.println(this.playerName + " attacks " + player.getName() + " but it does no damage (Critical hit).");
            }
        } else {
            // Normal attack logic
            damage = this.attack - player.getDefense();
            if (damage > 0) {
                player.takeDamage(damage);
                System.out.println(this.playerName + " attacks " + player.getName() + " for " + damage + " damage.");
            } else {
                System.out.println(this.playerName + " attacks " + player.getName() + " but it does no damage.");
            }
        }
    }
    
    public void takeDamage(int damage){ //takes damage. Same as all other living things
        this.health -= damage;
        if (this.health < 0){
            this.health = 0;
        }
    }
    public boolean isAlive(){ //checks if its alive
        if (this.health > 0){
            return true;
        } else {
            return false;
        }
    }
}