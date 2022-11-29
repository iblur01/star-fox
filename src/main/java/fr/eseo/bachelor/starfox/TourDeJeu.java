package fr.eseo.bachelor.starfox;

import fr.eseo.bachelor.starfox.Joueurs.Joueur;
import fr.eseo.bachelor.starfox.affichage.Chance_Popup;
import fr.eseo.bachelor.starfox.affichage.Commu_Popup;
import fr.eseo.bachelor.starfox.affichage.Plateau;
import fr.eseo.bachelor.starfox.affichage.Terrain_Popup;
import fr.eseo.bachelor.starfox.cases.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class TourDeJeu {
    Plateau plateau = new Plateau();
    int joueur_actuel;
    int nb_max_j;


    Joueur Joueur1 = new Joueur("Joueur1","#0000fe", 1);
    Joueur Joueur2 = new Joueur("Joueur2", "#ff0101", 2);
    Joueur Joueur3 = new Joueur("Joueur3", "#fcdd00", 3);
    Joueur Joueur4 = new Joueur("Joueur4", "#34623f", 4);


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

        Joueur1.lance_de();
        Joueur1.lance_de();


    }



    private void TDJ (Joueur JoueurX){

        Alert popup = new Alert(Alert.AlertType.NONE,"default Dialog", ButtonType.OK);
        popup.setTitle("DEBUT DE TOUR");
        popup.setContentText("C'est au" + JoueurX.getName() + "de jouer. \nLancez les dès.");
        popup.showAndWait();

        int nb_case;

        if (true){ //Cas si le joueur est en prison
            //faire une popup sur l'animation des dés + annonce des résultats
            JoueurX.lance_de();
            nb_case = JoueurX.getPosition();
            action(JoueurX, nb_case);
            this.joueur_actuel++;
            if (this.joueur_actuel > this.nb_max_j){
                this.joueur_actuel = 1;
            }
        }
        else
        {

        }
    }

    private void action(Joueur JoueurX, int nb_case){

        //Init fonction
        Terrain_Popup popup_action = new Terrain_Popup();
        Chance_Popup popup_chance = new Chance_Popup();
        Commu_Popup popup_commu = new Commu_Popup();

        //


        //Giga fonction

        if (nb_case == 0 || nb_case == 4 || nb_case == 38) JoueurX.event();

        else if (nb_case == 10) JoueurX.lance_de();

        else if (nb_case == 7 || nb_case == 22 || nb_case == 36){ //case chance
            popup_chance.afficher_popup(nb_case);
        }

        else if (nb_case == 2 || nb_case == 17 || nb_case == 33) { //case communaute
            popup_commu.afficher_popup(nb_case);
        }

        else {
            popup_action.terrain_popup(nb_case);
        }

        //
        // /!\ faire 2 tableau contenant le numéros des cases maions et les cases evenments

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
        stage.getChildren().addAll(vbox1,plateau.getPlateau(Joueur1, Joueur2, Joueur3, Joueur4),vbox2);

        return stage;

    }

}
