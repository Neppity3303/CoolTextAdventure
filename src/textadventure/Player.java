package textadventure;

import java.util.Random;

public class Player {
    private String playerName;
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    private int critrate;
    private int speed;
    private int level;
    private int experience;
    
    public Player(String name) {
        playerName = name;  // Set the player's name
        health = 20;        // Set initial health
        maxHealth = 20;     // Set max health
        attack = 5;         // Set attack value
        defense = 1;        // Set defense value
        critrate = 5;       // Set Critical Hit Rate
        speed = 5;          // Set speed value
        level = 1;          // Set initial level
        experience = 0;     // Set initial experience
    }
    
    public void increaseAttack(int increaseAmount){
        this.attack += increaseAmount;
    }
    
    public void gainExperience(int exp){
        this.experience += exp;
    }
    
    public void levelUp(){
        level++;
        attack += 2;
        health = maxHealth + 10;
    }
    
    public void displayStats() {
        System.out.println("Player: " + playerName);
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);
        System.out.println("Level: " + level);
        System.out.println("Experience: " + experience);
    }
    
    public void takeDamage(int damage){
        this.health -= damage;
        if (this.health < 0){
            this.health = 0;
        }
    }
    
    public void attack(Monster monster) {
        Random crit = new Random();
        int damage;

        if (crit.nextInt(100) < critrate) {
            // Critical hit logic
            damage = (this.attack * 2) - monster.getDefense(); // Double damage on crit
            if (damage > 0) {
                monster.takeDamage(damage);
                System.out.println(this.playerName + " attacks " + monster.getName() + " for " + damage + " damage (Critical hit)!");
            } else {
                System.out.println(this.playerName + " attacks " + monster.getName() + " but it does no damage (Critical hit).");
            }
        } else {
            // Normal attack logic
            damage = this.attack - monster.getDefense();
            if (damage > 0) {
                monster.takeDamage(damage);
                System.out.println(this.playerName + " attacks " + monster.getName() + " for " + damage + " damage.");
            } else {
                System.out.println(this.playerName + " attacks " + monster.getName() + " but it does no damage.");
            }
        }
    }
    
    public boolean isAlive(){
        if (this.health > 0){
            return true;
        } else {
            return false;
        }
    }
    
    public int getDefense(){
        return defense;
    }
    public int getAttack(){
        return attack;
    }
    public String getName(){
        return playerName;
    }
    public int getSpeed(){
        return speed;
    }
    public int getHealth(){
        return health;
    }
}
