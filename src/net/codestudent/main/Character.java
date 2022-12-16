package net.codestudent.main;

public abstract class Character {

    // Variables, Attributs que les persos ont
    public String name;
    public int maxHp, hp, xp;

    // Constructor for character
    public Character(String name, int maxHp, int xp) {
        this.name = name;
        this.maxHp = maxHp;
        this.xp = xp;
        this.hp = maxHp;
    }
    // Methodes que les persos ont
    public abstract int attack();
    public abstract int defend();
}

