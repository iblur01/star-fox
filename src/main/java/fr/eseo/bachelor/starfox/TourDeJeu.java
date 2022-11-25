package fr.eseo.bachelor.starfox;

import fr.eseo.bachelor.starfox.Joueurs.Joueur;
import fr.eseo.bachelor.starfox.affichage.Plateau;
import fr.eseo.bachelor.starfox.cases.Cases;
import fr.eseo.bachelor.starfox.cases.Evenements;
import fr.eseo.bachelor.starfox.cases.Terrains;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collection;

public class TourDeJeu {
    Plateau plateau = new Plateau();
    int joueur_actuel;
    int nb_max_j;

    Joueur Joueur1 = new Joueur("Unknown", "#0000fe", 2);
    Joueur Joueur2 = new Joueur("Unknown", "#ff0101", 2);
    Joueur Joueur3 = new Joueur("Unknown", "#fcdd00", 2);
    Joueur Joueur4 = new Joueur("Unknown", "#34623f", 2);

    public void init_TDJ(int nb_j){


        if (nb_j>1){
            Joueur1.setEnable(true);
            Joueur2.setEnable(true);
        }
        if (nb_j>2){
            Joueur3.setEnable(true);
        }
        if (nb_j>3){
            Joueur4.setEnable(true);
        }

        joueur_actuel = 1;
    }

    private void popup_joueur(Joueur joueurX){

        Alert popup = new Alert(Alert.AlertType.NONE,"default Dialog", ButtonType.OK);
        popup.setTitle("Nouveau Tour");
        popup.setHeaderText("Il s'agit du tour de "+ joueurX.getName() +".");
        popup.setContentText("Vous avez " + joueurX.getCompte() + ".");
        popup.showAndWait();
    }

    public void test_game(){

        this.popup_joueur(Joueur1);
        this.popup_joueur(Joueur2);
        this.popup_joueur(Joueur3);
        this.popup_joueur(Joueur4);
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

    public void setNameAll(String name1, String name2,String name3,String name4 ){
        Joueur1.setName(name1);
        Joueur2.setName(name2);
        Joueur3.setName(name3);
        Joueur4.setName(name4);

    }

    public HBox setPlateau(){
        HBox stage = new HBox();
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();

        vbox1.getChildren().addAll(plateau.user_space(Joueur1, joueur_actuel),plateau.user_space(Joueur4, joueur_actuel));
        vbox2.getChildren().addAll(plateau.user_space(Joueur2, joueur_actuel),plateau.user_space(Joueur3, joueur_actuel));
        stage.getChildren().addAll(vbox1,plateau.getPlateau(Joueur1,Joueur2,Joueur3,Joueur4),vbox2);

        return stage;

    }

}
