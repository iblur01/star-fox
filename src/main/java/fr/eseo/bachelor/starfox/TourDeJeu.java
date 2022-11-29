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


    Joueur Joueur1 = new Joueur("NULL","#0000fe", 1);
    Joueur Joueur2 = new Joueur("NULL", "#ff0101", 2);
    Joueur Joueur3 = new Joueur("NULL", "#fcdd00", 3);
    Joueur Joueur4 = new Joueur("NULL", "#34623f", 4);


    public void init_TDJ(int nb_j, String name1, String name2,String name3,String name4 ){

        init_cases();
        if (nb_j>1){

            Joueur1.setEnable(true);
            Joueur2.setEnable(true);

            if (name1 == "")
            {
                Joueur1.setName("Joueur1");
            }
            else if (name1 != "")
            {
                Joueur1.setName(name1);
            }
            if (name2 == "")
            {
                Joueur2.setName("Joueur2");
            }
            else if (name2 != "")
            {
                Joueur2.setName(name2);
            }
        }
        if (nb_j>2){
            Joueur3.setEnable(true);
            if (name3 == "")
            {
                Joueur3.setName("Joueur3");
            }
            else if (name3 != "")
            {
                Joueur3.setName(name3);
            }
        }
        if (nb_j>3){
            Joueur4.setEnable(true);
            if (name4 == "")
            {
                Joueur4.setName("Joueur4");
            }
            else if (name4 != "")
            {
                Joueur4.setName(name4);
            }
        }


        joueur_actuel = 1;
    }

    public void init_cases(){
        init_compagnies();
        init_rues();
        init_gares();
    }

    public void init_rues(){

        Rues rue1 = new Rues(1,"O'Tacos",60,30);
        Rues rue2 = new Rues(3,"McDo",60,30);
        Rues rue3 = new Rues(6,"Point Chicken",100,350);
        Rues rue4 = new Rues(8,"Food 49",100,50);
        Rues rue5 = new Rues(9,"Mc Donner",120,60);
        Rues rue6 = new Rues(11,"La Chapelle",140,70);
        Rues rue7 = new Rues(13,"Le Carré",140,70);
        Rues rue8 = new Rues(14,"Le Mid Star",160,80);
        Rues rue9 = new Rues(16,"Le Prime",180,90);
        Rues rue10 = new Rues(18,"So Sushi",180,90);
        Rues rue11 = new Rues(19,"Fresh Burritos",200,100);
        Rues rue12 = new Rues(21,"L'Atoll",220,110);
        Rues rue13 = new Rues(23,"L'esapce Anjou",220,110);
        Rues rue14 = new Rues(24,"Grand Maine",240,120);
        Rues rue15 = new Rues(26,"Lac de Maine",260,130);
        Rues rue16 = new Rues(27,"Aqua Vita",260,130);
        Rues rue17 = new Rues(29,"Les sablières",280,140);
        Rues rue18 = new Rues(31,"Le jardin des Plantes",300,150);
        Rues rue19 = new Rues(32,"Le jardin du Mail",300,150);
        Rues rue20 = new Rues(34,"Terra Botanica",320,160);
        Rues rue21 = new Rues(37,"Le Chateau d'Angers",350,175);
        Rues rue22 = new Rues(39,"ESEO",400,200);

    }
    public void init_gares(){


    }
    public void init_compagnies(){


    }

    private void popup_joueur(Joueur joueurX){

        Alert popup = new Alert(Alert.AlertType.NONE,"default Dialog", ButtonType.OK);
        popup.setTitle("Nouveau Tour");
        popup.setHeaderText("Il s'agit du tour de "+ joueurX.getName() +".");
        popup.setContentText("Vous avez " + joueurX.getCompte() + ".");
        popup.showAndWait();
    }





    private void TDJ (Joueur JoueurX){

        int nb_case;

        popup_joueur(JoueurX);

        JoueurX.lance_de();
        System.out.println("C'est a " + JoueurX.getName() + " de jouer, il avance de " +JoueurX.getPosition() + ".");
        nb_case = JoueurX.getPosition();
        action(JoueurX, nb_case);



        /*if (true){ //Cas si le joueur est en prison
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

        }*/
    }

    private void action(Joueur JoueurX, int nb_case){

        //Init fonction
        Terrain_Popup popup_action = new Terrain_Popup();
        Chance_Popup popup_chance = new Chance_Popup();
        Commu_Popup popup_commu = new Commu_Popup();

        ArrayList<Integer> list_gare;
        //


        //Giga fonction

        if (nb_case == 0 || nb_case == 4 || nb_case == 38) JoueurX.event();

        else if (nb_case == 10) JoueurX.setPosition(50);

        else if (nb_case == 7 || nb_case == 22 || nb_case == 36){ //case chance
            popup_chance.afficher_popup(nb_case);
        }

        else if (nb_case == 2 || nb_case == 17 || nb_case == 33) { //case communaute
            popup_commu.afficher_popup(nb_case);
        }

        else {
            int type;
            type = popup_action.achat_terrain_popup(nb_case);
        }

        //
        // /!\ faire 2 tableau contenant le numéros des cases maions et les cases evenments

    }


    public void test_game(){

        TDJ(Joueur1);
        TDJ(Joueur2);


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
