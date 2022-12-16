package net.codestudent.main;

public class Ennemi extends Character{

    //variable to store the players current xp
     int playerXp;

    //enemy specific constructor
    public Ennemi(String name, int playerXp) {
        super(name, (int) (Math.random() * playerXp + (playerXp / 3) + 5), (int) (Math.random() * (playerXp / 4 + 2) + 1));
        // assigning variables
        this.playerXp = playerXp;
    }

    //enemy specific attack and defense calculations
    @Override
    public int attack() {
        return (int) (Math.random() * (playerXp / 4 + 1) + xp / 4 + 3);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * (playerXp / 4 + 1) + xp / 4 + 3);
    }
}
