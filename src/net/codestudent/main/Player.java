package net.codestudent.main;

public class Player extends Character{

    // integers to store numbers of upgrades/skills in each part
    public int numAtkUpgrades, numDefUpgrades;

    // additional player stats
    int or, potions, reposRestants;

    // Arrays to store skills names
    public String[] atkUpgrades = {" Force", " Pouvoir Magique", " Puissance", " Force Surhumaine"};
    public String[] defUpgrades = {" Os Résistants", " Peau de roc", " Armure de fer", " Aura divine"};

    // Player specific constructor
    public Player(String name) {

        // calling constructor of superclass
        super(name, 100, 0);

        // Setting # of upgrades to 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;

        // set additional stats
        this.or = 5;
        this.reposRestants = 1;
        this.potions = 0;

        // let the player choose a trait when creating a new character
        chooseTrait();

    }

    // Player specific methods
    @Override
    public int attack() {
        return (int) (Math.random() * (xp/4 + numAtkUpgrades * 3 + 3) + xp/10 + numAtkUpgrades * 2 + numDefUpgrades + 1);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * (xp/4 + numDefUpgrades * 3 + 3) + xp/10 + numDefUpgrades * 2 + numDefUpgrades + 1);
    }

    // let the player choose a trait of either skill path
    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choisissez une capacité :");
        System.out.println((1) + atkUpgrades[numAtkUpgrades]);
        System.out.println((2) + defUpgrades[numDefUpgrades]);

        // get the player choice
        int input = GameLogic.readInt("->", 2);
        GameLogic.clearConsole();

        // deal with both cases
        if(input == 1) {
            GameLogic.printHeading("Vous avez choisi" + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        }else {
            GameLogic.printHeading("Vous avez choisi" + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();

    }

}
