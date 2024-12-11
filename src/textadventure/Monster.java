package textadventure;

public interface Monster {
    // Common methods for all monsters
    //Chat GPT said this would make monster classes easier.
    void takeDamage(int damage);
    int getHealth();
    int getAttack();
    int getDefense();
    String getName();
    int getExperience();
    int getSpeed();
    void attack(Player player);
    boolean isAlive();
}
