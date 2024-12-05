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
        experience = 35;     // Set initial experience
    }
    
    public int getHealth(){
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
    
    public void attack(Player player){
        Random crit = new Random();
        if(crit.nextInt(100) < critrate){
            int damage = (this.attack * 2) - player.getDefense();
            if (damage > 0){
                 player.takeDamage(damage);
                 System.out.println("The wolf attacks " + player.getName() + " for " + damage + " damage");
              } else {
            System.out.println("The wolf attacks " + player.getName() + "but it does no damage");}
        } else {
           int damage = this.attack - player.getDefense();
           if (damage > 0){
               player.takeDamage(damage);
               System.out.println("The wolf attacks " + player.getName() + " for " + damage + " damage");
           } else {
              System.out.println("The wolf attacks " + player.getName() + "but it does no damage");
           
        }
    }
}

    public void takeDamage(int damage){
        this.health -= damage;
        if (this.health < 0){
            this.health = 0;
        }
    }
    public boolean isAlive(){
        if (this.health > 0){
            return true;
        } else {
            return false;
        }
    }
}