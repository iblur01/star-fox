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

    private void popup_joueur(Joueur JoueurX){
        // Faire une popup pour tour de joueur
        // JoueurX.getName() etc

    }

    private void TDJ (Joueur JoueurX){
        int de;
        if (true){ //Cas si le joueur est en prison
            //faire une popup sur l'animation des dés + annonce des résultats
            de = JoueurX.lance_de();
            JoueurX.avancer(de);
        }
        else
        {

        }
    }

    private void action(Joueur JoueurX, int nb_case){

        //Giga fonction

        /*
        /!\ faire 2 tableau contenant le numéros des cases maions et les cases evenments
         */

    }

}
