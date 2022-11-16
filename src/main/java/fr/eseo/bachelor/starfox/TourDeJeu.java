package fr.eseo.bachelor.starfox;

import fr.eseo.bachelor.starfox.Joueurs.Joueur;
import fr.eseo.bachelor.starfox.affichage.Plateau;
import fr.eseo.bachelor.starfox.cases.Cases;
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

    private void TDJ (Joueur JoueurX, ArrayList<Terrains> list_t, ArrayList<Evenements> list_e){
        int nb_case;


        if (true){ //Cas si le joueur est en prison
            //faire une popup sur l'animation des dés + annonce des résultats
            JoueurX.lance_de();
            nb_case = JoueurX.getPosition();
            action(JoueurX, nb_case, list_t, list_e);
            this.joueur_actuel++;
            if (this.joueur_actuel > this.nb_max_j){
                this.joueur_actuel = 1;
            }
        }
        else
        {

        }
    }

    private void action(Joueur JoueurX, int nb_case, ArrayList<Terrains> list_t, ArrayList<Evenements> list_e){

        //Init fonction
        int type_case = which_type(list_t, list_e, nb_case);
        int placement_in_list = placement(list_t, list_e, nb_case);
        Terrains terrains;
        Evenements evenements;
        //


        //Giga fonction
        if (type_case == 1){
            terrains = list_t.get(placement_in_list);
        }
        else if (type_case == 2){
            evenements = list_e.get(placement_in_list);
        }
        else JoueurX.passe_ton_tours();
        //
        // /!\ faire 2 tableau contenant le numéros des cases maions et les cases evenments

    }


    private int which_type (ArrayList<Terrains> list_t, ArrayList<Evenements> list_e, int nb_case){

        int check = 0;
        Terrains terrains;
        Evenements evenements;


        for (int i = 0; i<list_t.size(); i++){

            terrains = list_t.get(i);
            if ( terrains.getEmplacement() == nb_case){
                check = 1;
            }
        }

        for (int j = 0; j < list_e.size(); j++) {

            evenements = list_e.get(j);
            if (evenements.getEmplacement() == nb_case) {
                check = 2;
            }
        }

        return check;
    }

    private int placement (ArrayList<Terrains> list_t, ArrayList<Evenements> list_e, int nb_case){

        int position = 0;
        Terrains terrains;
        Evenements evenements;


        for (int i = 0; i<list_t.size(); i++){

            terrains = list_t.get(i);
            if ( terrains.getEmplacement() == nb_case){
                position = i;
            }
        }

        for (int j = 0; j < list_e.size(); j++) {

            evenements = list_e.get(j);
            if (evenements.getEmplacement() == nb_case) {
                position = j;
            }
        }

        return position;
    }

}
