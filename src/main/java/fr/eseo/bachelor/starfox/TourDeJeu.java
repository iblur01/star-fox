package fr.eseo.bachelor.starfox;

import fr.eseo.bachelor.starfox.Joueurs.Joueur;
import fr.eseo.bachelor.starfox.affichage.Plateau;
import fr.eseo.bachelor.starfox.cases.Evenements;
import fr.eseo.bachelor.starfox.cases.Terrains;

import java.util.ArrayList;
import java.util.Collection;

public class TourDeJeu {

    int joueur_actuel;
    int nb_max_j;

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

    private void TDJ (Joueur JoueurX, ArrayList<Terrains> terrains, ArrayList<Evenements> evenements){
        int de;



        if (true){ //Cas si le joueur est en prison
            //faire une popup sur l'animation des dés + annonce des résultats
            de = JoueurX.lance_de();
            JoueurX.avancer(de);
            action(JoueurX, de, terrains, evenements);
            this.joueur_actuel++;
            if (this.joueur_actuel > this.nb_max_j){
                this.joueur_actuel = 1;
            }
        }
        else
        {

        }
    }

    private void action(Joueur JoueurX, int nb_case, ArrayList<Terrains> terrains, ArrayList<Evenements> evenements){

        //Giga fonction
        nb_case = 1; //pour test

        if ( check_list(evenements, terrains, nb_case) ){

        }

        /*else if (  ){

        }*/
        /*
        /!\ faire 2 tableau contenant le numéros des cases maions et les cases evenments
         */

    }


    private boolean check_list (ArrayList<Evenements> list_e, ArrayList<Terrains> list_t, int nb_case){

        boolean check = false;


        for (int i = 0; i< list_t.size(); i++){
            list_t.get(i);
        }

        return check;
    }

}
