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

    ArrayList<Terrains> list_t = new ArrayList<>();
    ArrayList<Evenements> list_e = new ArrayList<>();

    Joueur Joueur1 = new Joueur("Joueur1","#0000fe", 1);
    Joueur Joueur2 = new Joueur("Joueur2", "#ff0101", 2);
    Joueur Joueur3 = new Joueur("Joueur3", "#fcdd00", 3);
    Joueur Joueur4 = new Joueur("Joueur4", "#34623f", 4);

    public void init_TDJ(int nb_j){
        init_PlateauLogic();

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



    private void TDJ (Joueur JoueurX){
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

        int type_case = which_type(nb_case);
        int placement_in_list = placement(nb_case);
        //


        //Giga fonction
        if (type_case == 1){
            Terrains terrains = list_t.get(placement_in_list);
            popup_action.achat_terrain_popup(JoueurX, terrains);
        }
        else if (type_case == 2){
            Evenements evenements = list_e.get(placement_in_list);
            Random random = new Random();
            int nb_carte = 0 + random.nextInt(15-0);

            if (ChanceorCommu(evenements) == 1){
                popup_chance.afficher_popup(nb_carte);
                popup_chance.action_carte(nb_carte);
            }
            else {
                popup_commu.afficher_popup(nb_carte);
                popup_commu.action_carte(nb_carte);
            }
        }
        //
        // /!\ faire 2 tableau contenant le numéros des cases maions et les cases evenments

    }

    private void init_PlateauLogic(){
        Rues rue1 = new Rues (1, "O'Tacos");
        Gares gare1 = new Gares(5, "Le TONTON");
        Compagnies compagnie1 = new Compagnies(12, "La 7eme Compagnie");
        list_t.add(rue1);
        list_t.add(gare1);
        list_t.add(compagnie1);

        Chance chance1 = new Chance();
        Communaute communaute1 = new Communaute();
        list_e.add(chance1);
        list_e.add(communaute1);
    }

    private int which_type (int nb_case){

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

    private int placement (int nb_case){

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

    private int ChanceorCommu(Evenements evenements){
        int type = 0;

        for (int i = 0; i<list_e.size(); i++){
            evenements = list_e.get(i);
            if (evenements.getEmplacement() == 7 || evenements.getEmplacement() == 22 || evenements.getEmplacement() == 36){
                type = 1;
            }
            else{
                type = 2;
            }
        }

        return type;
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
