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

    public void increaseAttack(int increaseAmount) { //a method to easily add attack whether through an intem or level up
        this.attack += increaseAmount;
    }

    private int experienceThreshold = 10; // Initial experience needed to level up

    public void gainExperience(int exp) {
        this.experience += exp;

        // Check for leveling up
        while (this.experience >= experienceThreshold) {
            this.experience -= experienceThreshold; // Carry over excess experience
            levelUp();
            // Adjust the threshold dynamically after each level-up
            experienceThreshold = calculateExperienceThreshold();
        }
    }

    public void levelUp() {
        level++;
        attack += 2;
        maxHealth += 10; // Increase max health when leveling up
        health = maxHealth; // Restore health to the new max health
        System.out.println("Congratulations! You leveled up to Level " + level + "!");
    }

    private int calculateExperienceThreshold() { //calculate the experience needed to level up
        return 10 * level; // Adjust as needed for game balance
    }

    public void displayStats() { //displays player stats if decided
        System.out.println("Player: " + playerName);
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);
        System.out.println("Level: " + level);
        System.out.println("Experience: " + experience);
    }

    public void takeDamage(int damage) { //a method making decreasing hp easier
        this.health -= damage; //this refers to the current instance. It doesn't really do anything for the player but it helps with the monster classes.
        if (this.health < 0) {
            this.health = 0; //prevents health from being negative.
        }
    }

    public void attack(Monster monster) { //method to attack the selected monster
        Random crit = new Random();
        int damage;

        if (crit.nextInt(100) < critrate) {
            // Critical hit logic
            damage = (this.attack * 2) - monster.getDefense(); // Double damage on crit. Also checks if attack is greater than defense
            if (damage > 0) { 
                monster.takeDamage(damage);//monster takes double damage
                System.out.println(this.playerName + " attacks " + monster.getName() + " for " + damage + " damage (Critical hit)!");
            } else {
                System.out.println(this.playerName + " attacks " + monster.getName() + " but it does no damage (Critical hit).");
            }
        } else {
            // Normal attack logic
            damage = this.attack - monster.getDefense(); //checks if damage is greater than defense
            if (damage > 0) {
                monster.takeDamage(damage);//monster takes damage
                System.out.println(this.playerName + " attacks " + monster.getName() + " for " + damage + " damage.");
            } else {
                System.out.println(this.playerName + " attacks " + monster.getName() + " but it does no damage.");
            }
        }
    }

    public boolean isAlive() { //checks if the player has more than 0 health
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getDefense() { //methods to call stats.
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return playerName;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }
}
