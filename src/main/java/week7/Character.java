package main.java.week7;
// File name: Character.java

public class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = Math.max(0, maxHealth);
        this.health = this.maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            health = Math.max(0, health - amount);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health = Math.min(maxHealth, health + amount);
        }
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("Health: " + c.getHealth());

        c.heal(50);
        System.out.println("Health: " + c.getHealth());

        c.takeDamage(150);
        System.out.println("Health: " + c.getHealth());
    }
}