package fr.eseo.bachelor.starfox.cases;

import fr.eseo.bachelor.starfox.Joueurs.Joueur;

public class Chance extends Evenements{
    public void action_carte(int nb_cartes, Joueur JoueurX){
        if (nb_cartes == 0){
            //Le joueur actuel va à la case eseo
            JoueurX.setPosition(39);
        }
        else if(nb_cartes == 1){
            //Le joueur actuel va à la case depart
            JoueurX.setPosition(0);
        }
        else if(nb_cartes == 2){
            int avancement = 0;
            //Le joueur actuel va à la case grand maine
            // if (case depart sur le chemin)
            //joueur actuel + 200€
            avancement = 24 - JoueurX.getPosition();
            if (avancement < 0) JoueurX.recevoir(200);
            JoueurX.setPosition(24);
        }
        else if(nb_cartes == 3){
            //Le joueur actuel va à la case chapelle
            // if (case depart sur le chemin)
            //joueur actuel + 200€
        }
        else if(nb_cartes == 4){
            //Joueur actuel -((40*nombre_maison)+(115*nombre_hotels))
        }
        else if(nb_cartes == 5){
            int avancement = 0;
            //Le joueur actuel va à la case bar Maestro
            // if (case depart sur le chemin)
            //joueur actuel + 200€
            avancement = 15 - JoueurX.getPosition();
            if (avancement < 0) JoueurX.recevoir(200);
            JoueurX.setPosition(15);
        }
        else if(nb_cartes == 6){
            //Joueur actuel +100€
            JoueurX.recevoir(100);
        }
        else if(nb_cartes == 7){
            //Joueur actuel +50€
            JoueurX.recevoir(50);
        }
        else if(nb_cartes == 8){
            //Joueur actuel +carte libérer polytech

        }
        else if(nb_cartes == 9){
            int position = 0;
            //Position Joueur actuel = Position Joueur actuel - 3
            position = JoueurX.getPosition() - 3;
            JoueurX.setPosition(position);
        }
        else if(nb_cartes == 10){
            //Joueur actuel va à Polytech
            JoueurX.setPosition(50);
        }
        else if(nb_cartes == 11){
            //Joueur actuel -((50*nombre_maison)+(110*nombre_hotels))
        }
        else if(nb_cartes == 12){
            //Joueur actuel -40€
            JoueurX.payer(40);
        }
        else if(nb_cartes == 13){
            //Joueur actuel -50€
            JoueurX.payer(50);
        }
        else if(nb_cartes == 14){
            //Joueur actuel -40€
            JoueurX.payer(40);
        }
        else if(nb_cartes == 15){
            //Joueur actuel +150€
            JoueurX.recevoir(150);
        }
    }

}
