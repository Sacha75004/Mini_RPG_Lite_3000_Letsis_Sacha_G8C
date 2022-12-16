package net.codestudent.main;

// classe qui imprime chaque partie de l'histoire
public class Histoire {
    public static void printIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("L'Histoire");
        GameLogic.printSeperator(30);
        System.out.println("Dans un monde post-apocalytpique, Vous faites partie des derniers survivants, tout ceci déclenché par le terrible EMPEREUR.");
        System.out.println("A cause de lui, vos amis, votre famille, tous vos proches sont morts.");
        System.out.println("Vous devez à tout prix partir à l'aventure, parcourir des terres oubliées afin de venger tous vos proches de l'EMPEREUR.");
        GameLogic.anythingToContinue();
    }

    public static void printIntroPremierActe(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Premier Acte : Intro");
        GameLogic.printSeperator(30);
        System.out.println("Votre aventure commmence dès maintenant. Vous devrez passer par la grande forêt avant d'arpenter les Montagnes du Destin.");
        System.out.println("Ces montagnes sont connues pour être très dangereuses. On dit que personne n'en est ressorti vivant.");
        System.out.println("Après avoir parcouru toute la forêt, vous arrivez enfin au pied de la première montagne.");
        System.out.println("Vous décidez donc d'y aller malgré les rumeurs dont vous avez entendu parler, après tout, vous devez battre l'EMPEREUR !");
        System.out.println("\nPS : Vous devrez accumuler un total de 10 niveaux d'expérience pour accéder à la zone suivante.");
        GameLogic.anythingToContinue();
    }

    public static void printOutroPremierActe(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Premier Acte : Outro");
        GameLogic.printSeperator(30);
        System.out.println("BRAVO ! Vous avez réussi à passer les montagnes du destin.");
        System.out.println("Vous descendez donc de la dernière pente, et vous arrivez enfin sur la terre ferme.");
        System.out.println("\n Grâce à l'experience que vous avez accumulée durant tout le voyage vous permet d'aller à la zone suivante, mais aussi d'apprendre une nouvelle capacité !");
        GameLogic.anythingToContinue();
    }

    public static void printIntroDeuxiemeActe(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Deuxieme Acte : Intro");
        GameLogic.printSeperator(30);
        System.out.println("Vous voyagez donc dans cette campagne autrefois très peuplée, mais qui maintenant est hantée par de nombreuses créatures.");
        System.out.println("Vous récoltez des ressources ainsi que de l'or sur des créatures et des monstres tués sur votre chemin.");
        System.out.println("Tout à coup, un marchand se dirige vers vous pour vous échanger de l'éuipement contre de l'or");
        System.out.println("Afin de vous préparer pour la bataille finale. MAIS AVANT, il va falloir que vous traversiez ces Terres Hantées...");
        System.out.println("\nPS : Contrairement à la zone précédente, vous devrez rassembler 50 niveaux d'expérience pour accéder à la prochaine zone. Bonne chasse !");
        GameLogic.anythingToContinue();
    }

    public static void printOutroDeuxiemeActe(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Deuxieme Acte : Outro");
        GameLogic.printSeperator(30);
        System.out.println("Vous êtes vivant même après avoir traversé les Terres Hantées, BRAVO !");
        System.out.println("Vous n'êtes maintenant qu'à quelques heures de marche de votre destination finale : le Grand Château de l'EMPEREUR.");
        System.out.println("Cependant, vous avez besoin d'un peu de repos avant de repartir, vous décidez donc de vous reposer un peu.");
        System.out.println("\nPar la même occasion, vous avez acquis assez d'expérience pour aller au Château du Grand Empereur, mais également apprendre une nouvelle capacité !");
        GameLogic.anythingToContinue();
    }

    public static void printIntroTroisiemeActe(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Troisieme Acte : Intro");
        GameLogic.printSeperator(30);
        System.out.println("Vous pouvez maintenant voir le Grand Château de l'EMPEREUR au loin.");
        System.out.println("A partir du moment où vous passez la grande entrée du domaine de l'EMPEREUR, vous savez qu'il n'y aura plus de retour en arrière.");
        System.out.println("En y entrant, vous trouvez une tenue de serviteur, vous l'enfilez et partez en mission infiltration dans le Grand Château de l'EMPEREUR.");
        System.out.println("Vous passez par la porte principale sans vous faire repérer, mais juste après l'avoir passé, vous tombez nez-à-nez sur toute une légion de serviteurs...");
        System.out.println("\nPS : Vous pourrez accéder à la zone finale en accumulant 100 d'expérience.");
        GameLogic.anythingToContinue();
    }

    public static void printOutroTroisiemeActe(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Troisieme Acte : Outro");
        GameLogic.printSeperator(30);
        System.out.println("BRAVO ! Non seulement Vous avez réussi a vous défaire de tous les serviteurs, mais en plus vous avez réuni 100 niveaux d'expérience !");
        System.out.println("Vous arrivez donc juste devant la porte du trône de l'EMPEREUR.");
        System.out.println("Vous rassemblez tous vos objets de combat et dernières forces, puis d'un coup sec, vous ouvrez la porte...");
        System.out.println("\n MAIS AVANT, vous devez choisir la dernière capacité que vous pouvez apprendre de TOUTE l'aventure !");
        GameLogic.anythingToContinue();
    }

    public static void printIntroActeFinal(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Acte Final : Intro");
        GameLogic.printSeperator(30);
        System.out.println("Vous entrez donc dans la salle du combat final, la Salle du Trône !");
        System.out.println("Vous le voyez assis sur son trône et vous vous fixez dans les yeux, avec un regard aussi noir que l'obscurité de la nuit.");
        System.out.println("IL s'est levé, et vous attaque directement, en vous retirant votre magnifique épée de vos mains.");
        System.out.println("Vous devez donc vous battre pour votre vie si vous voulez vous défaire de l'EMPEREUR...");
        GameLogic.anythingToContinue();
    }

    public static void printEnd(Player player){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("FELICITATIONS, " + player.name + "! Vous avez vaincu le grand EMPEREUR et amené la paix dans le monde !");
        GameLogic.printSeperator(30);
        System.out.println("Jeu développé entièrement par Sacha Letsis pour le module d'Algorithme et Programmation !");
        System.out.println("Merci, et à bientôt pour de prochains projets !! :)");
    }
}
