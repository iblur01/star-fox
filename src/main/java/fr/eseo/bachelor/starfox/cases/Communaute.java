package fr.eseo.bachelor.starfox.cases;

import fr.eseo.bachelor.starfox.Joueurs.Joueur;

public class Communaute extends Evenements{

    public void action_carte(int nb_cartes, Joueur JoueurX){

        if (nb_cartes == 0){
            //Le joueur actuel va à la case depart
            JoueurX.setPosition(0);
        }
        else if(nb_cartes == 1){
            //Joueur actuel +200€
            JoueurX.recevoir(200);
        }
        else if(nb_cartes == 2){
            //Joueur actuel -50€
            JoueurX.payer(50);
        }
        else if(nb_cartes == 3){
            //Joueur actuel +50€
            JoueurX.recevoir(50);
        }
        else if(nb_cartes == 4){
            //Joueur actuel +carte libérer polytech
        }
        else if(nb_cartes == 5){
            //Joueur actuel va à Polytech
            JoueurX.setPosition(50);
        }
        else if(nb_cartes == 6){
            int avancement = 0;
            //Joueur actuel va à la case Tacos
            avancement = 1 - JoueurX.getPosition();
            if (avancement <0) JoueurX.recevoir(200);
            JoueurX.setPosition(1);
        }
        else if(nb_cartes == 7){
            //Joueur actuel +100€
            JoueurX.recevoir(100);
        }
        else if(nb_cartes == 8){
            //Joueur actuel +(10*nombre joueur)€
            //Tout les joueurs -10€
        }
        else if(nb_cartes == 9){
            //Joueur actuel +20€
            JoueurX.recevoir(20);
        }
        else if(nb_cartes == 10){
            //Joueur actuel +25€
            JoueurX.recevoir(25);
        }
        else if(nb_cartes == 11){
            //Joueur actuel -50€
            JoueurX.payer(50);
        }
        else if(nb_cartes == 12){
            //Joueur actuel -(20*nombre joueur)€
            //Tout les joueurs -20€
        }
        else if(nb_cartes == 13){
            int avancement = 0;
            //Joueur actuel va à la case bar la plus proche
            // if (case depart sur le chemin)
            //joueur actuel + 200€
            for (int i = 1; i<36; i++) {
                if (i == 5 || i == 15 || i == 25 || i == 35) {
                    avancement = i - JoueurX.getPosition();
                    if (avancement < 0) {
                        JoueurX.recevoir(200);
                        JoueurX.setPosition(i);
                    }
                    JoueurX.setPosition(i);
                }
            }
        }
        else if(nb_cartes == 14){
            //Joueur actuel +10€
            JoueurX.recevoir(10);
        }
        else if(nb_cartes == 15){
            //Joueur actuel +100€
            JoueurX.recevoir(100);
        }
    }

}
