package fr.eseo.bachelor.starfox;

import fr.eseo.bachelor.starfox.Joueurs.Joueur;
import fr.eseo.bachelor.starfox.affichage.Plateau;

public class TourDeJeu {

    int joueur_actuel;

    public void init_TDJ(int nb_j){
        Plateau plateau = new Plateau();

        if (nb_j>0){
            Joueur Joueur1 = new Joueur();
        }
        if (nb_j>1){
            Joueur Joueur2 = new Joueur();
        }
        if (nb_j>2){
            Joueur Joueur3 = new Joueur();
        }
        if (nb_j>3){
            Joueur Joueur4 = new Joueur();
        }

        joueur_actuel = 1;
    }

    public void popup_joueur(Joueur JoueurX){
        // Faaire une popup pour tour de joueur
        //JoueurX.getName() etc

    }
}
