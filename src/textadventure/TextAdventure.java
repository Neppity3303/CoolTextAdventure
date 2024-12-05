package textadventure;

import java.util.Random;
import java.util.Scanner;


 // @author Neppuwu

public class TextAdventure {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Text Adventure with a Cool Name!");
        System.out.println("Please enter a name for your Hero: ");
        String name = input.nextLine();
        Player player = new Player(name);
        System.out.println(name + " finds themselves on a suspicious path, behind " + name + " are a pack of wolves, hunting. The only sensible option seems to enter the cave ahead of you and wait it out.");
        System.out.println("1) Enter the cave");
        System.out.println("2) Go back");
        int a1 = input.nextInt();
        switch (a1){
            case 1:
                System.out.println("something later");
                break;
            case 2:
                Wolf wolf = new Wolf("Wolf");
                System.out.println("A Wolf has appeared, it's hungry.");
                combat(player, wolf);
                break;
            default:
                System.out.println("Invalid input, please choose a valid option");
        }
            
        
            
    }
    public static void combatTurn(Player player, Monster monster){
        //compare speed to determine who moves first
        if (player.getSpeed() > monster.getSpeed()){
            player.attack(monster);
            monsterHealthUpdate(monster);
            if (monster.getHealth() > 0){
                monster.attack(player);
                playerHealthUpdate(player);
            }
        } else if (player.getSpeed() < monster.getSpeed()){
            monster.attack(player);
            playerHealthUpdate(player);
            if (player.getHealth() > 0){
                player.attack(monster);
                monsterHealthUpdate(monster);
            }
        } else {
            //speed is the same, player goes first
            player.attack(monster);
            monsterHealthUpdate(monster);
            if (monster.getHealth() > 0){
                monster.attack(player);
                playerHealthUpdate(player);
            }
        }
    }
    public static void combat(Player player, Monster monster) {
    Scanner input = new Scanner(System.in);
    boolean ran = false;

    while (monster.isAlive() && !ran) {
        System.out.println("1) Attack");
        System.out.println("2) Inventory");
        System.out.println("3) Run");
        int b1 = input.nextInt();

        switch (b1) {
            case 1:
                combatTurn(player, monster);
                if (!monster.isAlive()) {
                    System.out.println("You have killed the " + monster.getName() + " and gained " + monster.getExperience() + "experience.");
                    player.gainExperience(monster.getExperience());
                }
                break;
            case 2:
                System.out.println("WIP");
                break;
            case 3:
                if (player.getSpeed() > monster.getSpeed()) {
                    ran = true;
                    System.out.println("You successfully escaped your opponent.");
                } else {
                    System.out.println("You were unable to escape the monster.");
                    monster.attack(player);
                    playerHealthUpdate(player);
                }
                break;
            default:
                System.out.println("Invalid input, please choose a valid option.");
        }

        // Check if the player has died after the combat turn
        if (player.getHealth() <= 0) {
            System.out.println("You have died.");
            System.exit(0);
        }
    }
    System.out.println("Combat is over.");
}
    public static void monsterHealthUpdate(Monster monster){
        System.out.println("The " + monster.getName() + " has " + monster.getHealth() + " HP remaining.");
    }
    public static void playerHealthUpdate(Player player){
        System.out.println(player.getName() + " has " + player.getHealth() + " HP remaining.");
    }

    
}
    

