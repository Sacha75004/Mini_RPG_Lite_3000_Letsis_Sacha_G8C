package net.codestudent.main;
import java.util.Scanner;

public class GameLogic{
    static Scanner scanner = new Scanner (System.in);

    static Player player;

    public static boolean isRunning;

    // random encounters
    public static String[] encounters = {"Bataille", "Bataille", "Bataille", "Repos", "Repos"};

    public static String[] ennemis = {"Gobelin", "Ogre géant", "Fantôme", "Squelette", "Serviteur de l'EMPEREUR"};

    // story elements
    public static int place = 0, act = 1;
    public static String[] places = {"Montagnes du Destin", "Terres Hantées", "Grand Château de l'EMPEREUR", "Salle du Trône"};

    // methode pour avoir l'entree utilisateur de la console
    public static int readInt (String prompt, int userChoices) {
        int input;

        do {
            System.out.println(prompt);
                try{
                    input = Integer.parseInt(scanner.next());
                }catch(Exception e){
                    input = -1;
                    System.out.println("Entrez un nombre!");
                }
        }while(input < 1 || input > userChoices);
        return input;
    }

    // methode pour simuler le clear de la console
    public static void clearConsole(){
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    // methode pour afficher un seperator avec length n
    public static void printSeperator(int n){
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    // methode pour afficher un Heading
    public static void printHeading(String title){
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }

    // methode pour arreter le jeu jusqu'a l'utilisateur n'entre rien
    public static void anythingToContinue(){
        System.out.println("\nAppuiez sur n'importe quelle touche pour continuer ...");
        scanner.next();
    }

    // method to start the game
    public static void startGame() {
        boolean nameSet = false;
        String name;

        //print title screen
        clearConsole();
        printSeperator(40);
        printSeperator(30);
        System.out.println("L'Ere du terrible Maurice");
        System.out.println("Fait par Sacha Letsis");
        printSeperator(30);
        printSeperator(40);
        anythingToContinue();

        //getting the player name
        do {
            clearConsole();
            printHeading("Quel est votre nom ?");
            name = scanner.next();
            // asking the player if he wants to correct his choice
            clearConsole();
            printHeading("Votre nom est " + name + ".\nC'est bien ça ?");
            System.out.println("(1) Oui ! ");
            System.out.println("(2) Non, je veux changer mon prénom. ");
            int input = readInt("->", 2);
            if (input == 1)
                nameSet = true;
        } while (!nameSet);

            // print story intro
            Histoire.printIntro();

            // create new object with the name
            player = new Player(name);

            // print story 1er acte
            Histoire.printIntroPremierActe();

            // setting isRunning to true, pour que la boucle continue
            isRunning = true;

            // start main game loop
            gameLoop();
        }

        // method that change the game's value based on player xp
        public static void checkActe(){
            // changer les actes en fonction de l'xp
            if(player.xp >= 10 && act == 1){
                // increment act and place
                act = 2;
                place = 1;
                // story
                Histoire.printOutroPremierActe();
                // level up
                player.chooseTrait();
                // story
                Histoire.printIntroDeuxiemeActe();
                // new values to enemies
                ennemis[0] = "Gobelin";
                ennemis[1] = "Fantôme";
                ennemis[2] = "Squelette";
                ennemis[3] = "Ogre géant";
                // rencontres
                encounters[0] = "Bataille";
                encounters[1] = "Bataille";
                encounters[2] = "Repos";
                encounters[3] = "Boutique";
            }
            else if(player.xp >= 50 && act == 2){
                // increment act and places
                act = 3;
                place = 2;
                // Story
                Histoire.printOutroDeuxiemeActe();
                // level up
                player.chooseTrait();
                // Story
                Histoire.printIntroTroisiemeActe();
                ennemis[0] = "Serviteur de l'EMPEREUR";
                ennemis[1] = "Serviteur de l'EMPEREUR";
                ennemis[2] = "Serviteur de l'EMPEREUR";
                ennemis[3] = "Serviteur de l'EMPEREUR";

                encounters[0] = "Bataille";
                encounters[1] = "Bataille";
                encounters[2] = "Bataille";
                encounters[3] = "Boutique";
                // soigner le player
                player.hp = player.maxHp;
            }
            else if(player.xp >= 100 && act == 3){
                // act and place
                act = 4;
                place = 3;
                // story
                Histoire.printOutroTroisiemeActe();
                // lvl up
                player.chooseTrait();
                // Story
                Histoire.printIntroActeFinal();
                // soigner le player
                player.hp = player.maxHp;
                // calling the final battle
                batailleFinale();
            }
        }

        // method to calculate a random encounter
        public static void randomEncounter(){
            // random number between 0 and the length of the encounters array
            int encounter = (int) (Math.random()* encounters.length);
            // calling the respective methods
            if(encounters[encounter].equals("Bataille")){
                randomBattle();
            }
            else if(encounters[encounter].equals("Repos")){
                takeRest();
            }
            else{
                shop();
            }
        }

        // method to continue the journey
        public static void continueJourney(){
            // check if act must be increased
            checkActe();
            // check if game isn't in last act
            if(act != 4){
                randomEncounter();

            }
        }

        // printing out the most important info about the player character
        public static void characterInfo(){
            clearConsole();
            printHeading("INFORMATIONS DU PERSONNAGE");
            System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
            printSeperator(20);
            // player xp and gold
            System.out.println("XP: " + player.xp + "\nOr: " + player.or);
            printSeperator(20);
            // number of potions
            System.out.println("Nombre de Potions: " + player.potions);
            printSeperator(20);

        // printing the choosen traits
        if(player.numAtkUpgrades > 0){
            System.out.println("Capacité offensive: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeperator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Capacité défensive: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }
        anythingToContinue();
    }

        // shopping / encountering a marchant
        public static void shop(){
        clearConsole();
        printHeading("Vous avez rencontré un mystérieux marchand. Il vous propose une offre:");
        int price = (int) (Math.random() * (10 + player.potions * 3) + 10 + player.potions);
        System.out.println("- Potion Magique: " + price + " d'or.");
        printSeperator(20);
        // ask the player to buy one
        System.out.println("Marchand :'Bonjour cher aventurier! Voulez-vous payer une magnifique potion magique qui a le pouvoir de soigner intégralement toutes vos blessures?'\n(1) Oui !\n(2) Non merci.");
        int input = readInt("->", 2);
        // check if player wants to buy
        if (input == 1){
            clearConsole();
            // check if player has enough gold
            if (player.or >= price){
                printHeading("Vous avez acheté une potion magique pour un total de " + price + "d'or.");
                player.potions++;
                player.or -= price;
                }else
                    printHeading("Vous n'avez pas assez d'or pour payer ça...");
                anythingToContinue();
            }
        }

        // taking a rest
        public static void takeRest(){
            clearConsole();
            if (player.reposRestants >= 1){
                printHeading("Voulez-vous vous reposer ? (" + player.reposRestants + " repos restant(s)).");
                System.out.println("(1) Oui\n(2) Non, pas maintenant.");
                int input  = readInt("->", 2);
                if (input == 1){
                    // player actually takes rest
                    clearConsole();
                    if (player.hp < player.maxHp){
                         int hpRestored = (int) (Math.random() * (player.xp / 4 + 1) + 10);
                         player.hp += hpRestored;
                         if (player.hp > player.maxHp)
                             player.hp = player.maxHp;
                            System.out.println("Vous vous êtes reposé et avez récupéré " + hpRestored + "points de vie.");
                            System.out.println("Vous avez maintenant " + player.hp + "/" + player.maxHp + " points de vie.");
                            player.reposRestants--;
                    }
                }else
                    System.out.println("Vous avez toute votre vie. Vous n'avez pas besoin de reposer maintenant!");
                anythingToContinue();
            }
        }

        // creating a random battle
        public static void randomBattle(){
            clearConsole();
            printHeading("Vous venez de rencontrer un ennemi. Vous devez l'affronter !");
            anythingToContinue();
            // creating new enemy with random name
            bataille(new Ennemi(ennemis[(int) (Math.random() * ennemis.length)], player.xp));
        }

        // main BATTLE method
        public static void bataille(Ennemi ennemi){
            //main battle loop
            while(true){
                clearConsole();
                printHeading(ennemi.name + "\nHP" + ennemi.hp + "/" + ennemi.maxHp);
                printHeading(player.name + "\nHP" + player.hp + "/" + player.maxHp);
                System.out.println("Choisissez une action: ");
                printSeperator(20);
                System.out.println("(1) Combattre\n(2) Utiliser une potion\n(3) Fuir");
                int input = readInt("->", 3);
                // react accordingly to player input
                if (input == 1){
                    //COMBATTRE
                    // calculate dmg and dmgTook (dmg enemy deals with player)
                    int dgt = player.attack() - ennemi.defend();
                    int dgtPris = ennemi.attack() - player.defend();
                    // check that dmg and dmgTook isn't negative
                    if (dgtPris < 0){
                        // add some dmg if player defends very well
                        dgt -= dgtPris / 2;
                        dgtPris = 0;
                    }
                    if (dgt < 0){
                        dgt = 0;
                    }
                    // deal dgt to both parties
                    player.hp -= dgtPris;
                    ennemi.hp -= dgt;
                    // print the info of this battle round
                    clearConsole();
                    printHeading("BATAILLE");
                    System.out.println("Vous avez fait " + dgt + " dégats à l'ennemi " + ennemi.name + ".");
                    printSeperator(15);
                    System.out.println("L'ennemi " + ennemi.name + "vous a fait " + dgtPris + " dégats sur vous.");
                    anythingToContinue();
                    // check if player is still alive or died
                    if (player.hp <= 0){
                        playerDied(); // method to end the game
                        break;

                    }else if (ennemi.hp <= 0){
                        // tell the player he won
                        clearConsole();
                        printHeading("Vous avez battu l'ennemi " + ennemi.name + "!");
                        // increase player xp
                        player.xp += ennemi.xp;
                        System.out.println("Vous avez gagné " + ennemi.xp + "XP !");
                        // random drops
                        boolean addRest =  (Math.random() * 5 + 1 <= 2.25);
                        int goldEarned = (int) (Math.random() * ennemi.xp);
                        if (addRest){
                            player.reposRestants++;
                            System.out.println("Vous avez la chance de gagner une récompense supplémentaire!");
                        }
                        if (goldEarned >0){
                            player.or += goldEarned;
                            System.out.println("Vous avez récupéré " + goldEarned + " d'or sur le corps de l'ennemi " + ennemi.name + ".");
                        }
                        anythingToContinue();
                        break;
                    }
                }else if (input == 2){
                    // Utiliser une potion
                    clearConsole();
                    if (player.potions > 0 && player.hp < player.maxHp){
                        // player CAN take a potion
                        // make sure player wants to take a potion
                        printHeading("Voulez-vous prendre une potion ? ("+ player.potions +" left).");
                        System.out.println("(1) Oui\n (2) Non, peut-être plus tard");
                        input = readInt("->", 2);
                        if (input == 1){
                            // player actually took it
                            player.hp = player.maxHp;
                            clearConsole();
                            printHeading("Vous avez bu une potion magique. Elle a rétabli votre santé a " + player.maxHp);
                            anythingToContinue();
                        }
                    }else{
                        // player CANNOT take a potion
                        printHeading("Vous n'avez plus de potions ou vous avez déjà votre vie pleine.");
                        anythingToContinue();
                    }

                }else{
                    // Fuir
                    clearConsole();
                    // check that player isn't in final act (final boss battle)
                    if (act != 4){
                        // chance of 35% to escape
                        if (Math.random() * 10 + 1 <= 3.5){
                            printHeading("Vous avez fui de l'ennemi " + ennemi.name + "!");
                            anythingToContinue();
                            break;
                        }else{
                            printHeading("Nous n'avez pas réussi à fuir.");
                            // calculate dmg the players takes
                            int dgtPris = ennemi.attack();
                            System.out.println("Vous avez pris " + dgtPris + " dégats !");
                            anythingToContinue();
                            // check if player is still alive
                            if (player.hp <= 0)
                                playerDied();
                        }
                    }else{
                        printHeading("Vous ne pouvez pas fuir le Grand Empereur !!");
                        anythingToContinue();
                    }

                }
            }
        }

        // printing the menu
        public static void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choisis une action:");
        printSeperator(20);
        System.out.println("(1) Continuer l'aventure");
        System.out.println("(2) Informations du personnage");
        System.out.println("(3) Quitter le jeu");
        }

        // the final (last) battle of the game
        public static void batailleFinale(){
            // creating the boss and letting player fight against him
            bataille(new Ennemi("LE GRAND EMPEREUR", 300));
            // printing the proper ending
            Histoire.printEnd(player);
            isRunning = false;
        }

        // method that gets called when the player is dead
        public static void playerDied(){
            clearConsole();
            printHeading("Vous êtes mort ...");
            printHeading("Vous avez gagné " + player.xp + "XP durant votre aventure. Vous ferez mieux la prochaine fois !");
            System.out.println("Merci d'avoir joué à mon jeu ! J'espère que cela vous à plu :)");
            isRunning = false;
        }

        // main game loop
        public static void gameLoop(){
            while(isRunning){
                printMenu();
                int input = readInt("->",3);
                if (input == 1)
                    continueJourney();
                else if(input == 2)
                    characterInfo();
                else
                    isRunning = false;
            }
        }
}