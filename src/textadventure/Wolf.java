package textadventure;

import java.util.Random;

public class Wolf implements Monster {
    private String playerName;
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    private int critrate;
    private int speed;
    private int experience;
    
    public Wolf(String name) {
        playerName = name;  // Set the player's name
        health = 15;        // Set initial health
        maxHealth = 15;     // Set max health
        attack = 10;         // Set attack value
        defense = 3;        // Set defense value
        critrate = 10;       // Set Critical Hit Rate
        speed = 10;          // Set speed value
        experience = 35;     // Set the amount of experience that will be dropped
    }
    
    public int getHealth(){ //Methods to get the current health of the wolf.
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
    
    public void attack(Player player){ //attacks the selected player
        Random crit = new Random();
        if(crit.nextInt(100) < critrate){ //random crits. The chance of a crit SHOULD be the same as critrate. I did not test this to be true.
            int damage = (this.attack * 2) - player.getDefense(); //add a probably non balanced attack modifier and sees if it gets past the defense
            if (damage > 0){ 
                 player.takeDamage(damage); //subtracts the players health
                 System.out.println("Critical hit!");
                 System.out.println("The wolf attacks " + player.getName() + " for " + damage + " damage");
              } else {
            System.out.println("The wolf attacks " + player.getName() + "but it does no damage");}
        } else { //non critical hit
           int damage = this.attack - player.getDefense();
           if (damage > 0){
               player.takeDamage(damage);
               System.out.println("The wolf attacks " + player.getName() + " for " + damage + " damage");
           } else {
              System.out.println("The wolf attacks " + player.getName() + "but it does no damage");
           
        }
    }
}

    public void takeDamage(int damage){ //method to take damage.
        this.health -= damage;
        if (this.health < 0){ //this returns the current instance. It should avoid errors
            this.health = 0;
        }
    }
    public boolean isAlive(){ //method to check if the wolf is alive.
        if (this.health > 0){
            return true;
        } else {
            return false;
        }
    }
}