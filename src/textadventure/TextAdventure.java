package textadventure;

import java.util.Random;
import java.util.Scanner;


 // @author Neppuwu

public class TextAdventure {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Text Adventure with a Cool Name!");
        System.out.println("Please enter a name for your Hero: ");
        String name = input.nextLine(); //input a name for the player
        Player player = new Player(name); //initialize the player with inputed name
        Inventory inventory = new Inventory(); //initialize inventory

        System.out.println(name + " finds themselves on a suspicious path, a heavy downpour soaks " + name + " to the bone, behind " + name + " are a pack of wolves, hunting. The only sensible option seems to enter the cave ahead of you and wait it out.");
        System.out.println("1) Enter the cave"); // Beginning the story
        System.out.println("2) Go back");

        String a1;
        while (true) { //validate that the player input is valid. I could put this in a method but I am too lazy
            System.out.print("Choose an option (1 or 2): ");
            a1 = input.nextLine(); // Store user input

            if (a1.equals("1") || a1.equals("2")) {
                break; // Exit the loop if the input is valid
            }
            System.out.println("Invalid input, please choose a valid option (1 or 2)."); //print if input is invalid
        }
        switch (a1){ //switch to figure out what the player wants to do
            case "1"://initial text for main storyline
                System.out.println("You rush into the cave, the wolves seem to have lost your scent.");
                break;
            case "2"://wolf fight, guaranteed loss
                Wolf wolf = new Wolf("Wolf"); //initialize the wolf for the fight
                System.out.println("A Wolf has appeared, it's hungry.");
                combat(player, wolf); //call the combat class with the player and the wolf
                break;
            default://unforseen error
                System.out.println("The while loop is broken"); //this should never happen
        }
        //Main story continued
        System.out.println("As " + name + " explores further into the cave, they realize this system is much larger than expected. The promise of adventure pushes them  forward.");
        System.out.println("The cave branches ahead, neither tunnel is particularly different from the other. Which way should " + name + " go?");
        System.out.println("1) Left");
        System.out.println("2) Right");
        
        String a2 = input.nextLine(); //store user input
        // Validate input
        while (!a2.equals("1") && !a2.equals("2")) { //also validates user input. I would benefit greatly from a method
           System.out.println("Invalid input, please choose a valid option (1 or 2).");
           a2 = input.nextLine();
        }
        
        switch (a2){
            case "1"://goblin fight
                System.out.println("A Goblin ambushes you!");
                Goblin goblin = new Goblin("Goblin"); //initialize goblin
                combat(player, goblin); //call combat for player vs Goblin
                player.displayStats(); //display the player stats
                break;
            case "2"://chest
                BronzeChest bronzeChest = new BronzeChest();//initialize bronze chest
                Item droppedItem = bronzeChest.open(); //store the random item in a string
                System.out.println("You find a chest in the chamber");
                System.out.println("You open the chest and find a " + droppedItem); //print the dropped item
                inventory.addItem(droppedItem); //add the random item to the inventory in the appropriate slot
        }
        
            
    }
    public static void combatTurn(Player player, Monster monster){
        //compare speed to determine who moves first
        if (player.getSpeed() > monster.getSpeed()){ //check if the player is faster
            player.attack(monster); //call the attack method in the player class
            monsterHealthUpdate(monster); //display the monsters updated health
            if (monster.getHealth() > 0){ //check if the monster is alive
                monster.attack(player); //call the attack method in the monster class
                playerHealthUpdate(player); //display updated player health
            }
        } else if (player.getSpeed() < monster.getSpeed()){ //reverse order of the first statement
            monster.attack(player);
            playerHealthUpdate(player);
            if (player.getHealth() > 0){
                player.attack(monster);
                monsterHealthUpdate(monster);
            }
        } else {
            //speed is the same, player goes first
            player.attack(monster); //same as the first statement
            monsterHealthUpdate(monster);
            if (monster.getHealth() > 0){
                monster.attack(player);
                playerHealthUpdate(player);
            }
        }
    }
    public static void combat(Player player, Monster monster) { //combat between mentioned player and monster
    Scanner input = new Scanner(System.in);
    boolean ran = false; //initialize the run option

    while (monster.isAlive() && !ran) { // Keeps combat going as long as the monster is alive
    System.out.println("1) Attack");
    System.out.println("2) Inventory");
    System.out.println("3) Run");

    String b1 = input.nextLine();

    // Validate input
    while (!b1.equals("1") && !b1.equals("2") && !b1.equals("3")) {
        System.out.println("Invalid input, please choose a valid option (1, 2, or 3).");
        b1 = input.nextLine();
    }

    // Process valid input
    switch (b1) {
        case "1": // Attack
            combatTurn(player, monster); //call combat turn for the player and monster
            if (!monster.isAlive()) { //check if the monster died
                System.out.println("You have killed the " + monster.getName() + " and gained " + monster.getExperience() + " experience."); //print the experience from the kill
                player.gainExperience(monster.getExperience()); //give the player some experience
            }
            break;

        case "2": // Inventory
            System.out.println("Inventory");
            // Implement inventory handling here
            //I don't have the time or patience to add this :(
            break;

        case "3": // Run
            if (player.getSpeed() > monster.getSpeed()) { //if player is faster than monster
                ran = true; //make the player run
                System.out.println("You successfully escaped your opponent.");
            } else {
                System.out.println("You were unable to escape the monster.");
                monster.attack(player); //monster attacks the player if you fail to escape
                playerHealthUpdate(player); // Update player health
            }
            break;

        default: // This should never occur due to input validation
            System.out.println("Unexpected error occurred.");
    }


        // Check if the player has died after the combat turn
        if (player.getHealth() <= 0) { //player died
            System.out.println("You have died.");
            System.exit(0); //exit the program
        }
    }
    System.out.println("Combat is over.");
    
    }

    public static void monsterHealthUpdate(Monster monster){
        System.out.println("The " + monster.getName() + " has " + monster.getHealth() + " HP remaining."); //finds the monsters current health
    }
    public static void playerHealthUpdate(Player player){
        System.out.println(player.getName() + " has " + player.getHealth() + " HP remaining."); //finds your players health
    }
}