package fr.eseo.bachelor.starfox;

import fr.eseo.bachelor.starfox.Joueurs.Joueur;
import fr.eseo.bachelor.starfox.affichage.Chance_Popup;
import fr.eseo.bachelor.starfox.affichage.Commu_Popup;
import fr.eseo.bachelor.starfox.affichage.Plateau;
import fr.eseo.bachelor.starfox.affichage.Terrain_Popup;
import fr.eseo.bachelor.starfox.cases.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class TourDeJeu {
    private Plateau plateau = new Plateau();
    private Logic_Plateau logic_plateau =  new Logic_Plateau();
    private ArrayList<Compagnies> list_compagnies = logic_plateau.getCompagnies();
    private ArrayList<Gares> list_gares = logic_plateau.getGares();
    private ArrayList<Rues> list_rues = logic_plateau.getRues();
    private Chance logic_chance = new Chance();
    private Communaute logic_communaute = new Communaute();
    private int joueur_actuel;
    private int nb_max_j;
    private Button rollDices = new Button("DICEEEEEES");
    private  Boolean dice_button;


    Joueur Joueur1 = new Joueur("Joueur1","#0000fe", 1);
    Joueur Joueur2 = new Joueur("Joueur2", "#ff0101", 2);
    Joueur Joueur3 = new Joueur("Joueur3", "#fcdd00", 3);
    Joueur Joueur4 = new Joueur("Joueur4", "#34623f", 4);


    public void init_TDJ(int nb_j, String name1, String name2,String name3,String name4 ){

        logic_plateau.init_cases();

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



    private void popup_joueur(Joueur joueurX){

        Alert popup = new Alert(Alert.AlertType.NONE,"default Dialog", ButtonType.OK);
        popup.setTitle("Nouveau Tour");
        popup.setHeaderText("Il s'agit du tour de "+ joueurX.getName() +".");
        popup.setContentText("Vous avez " + joueurX.getCompte() + ".");
        popup.showAndWait();
    }

    private void TDJ (Joueur JoueurX){

        if (JoueurX.getEnable() == TRUE){

            int nb_case;
            popup_joueur(JoueurX);
            int de;

            de = JoueurX.lance_de();
            /*de = 7;
            JoueurX.avancer(7);*/ //pratique pour le debug
            nb_case = JoueurX.getPosition();
            action(JoueurX, nb_case, de);
        }

        else {


        }





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

    private void action(Joueur JoueurX, int nb_case, int de){

        //Init fonction
        Terrain_Popup popup_action = new Terrain_Popup();
        Chance_Popup popup_chance = new Chance_Popup();
        Commu_Popup popup_commu = new Commu_Popup();

        Compagnies compagnie;
        Gares gare;
        Rues  rue;

        //


        //Giga fonction

        if (nb_case == 0 || nb_case == 4 || nb_case == 38){
            JoueurX.event();
            System.out.println("Le joueur" + JoueurX.getName() + " est sur une case event");
        }

        else if (nb_case == 10){
            JoueurX.setPosition(50);
            System.out.println("Le joueur" + JoueurX.getName() + " est sur la prison");
        }

        else if (nb_case == 7 || nb_case == 22 || nb_case == 36){ //case chance
            Random random = new Random();
            int num_carte =  0 + random.nextInt(15-0);
            popup_chance.afficher_popup(num_carte);
            logic_chance.action_carte(num_carte, JoueurX);
            System.out.println("Le joueur" + JoueurX.getName() + " est sur une case chance");
        }

        else if (nb_case == 2 || nb_case == 17 || nb_case == 33) { //case communaute
            Random random = new Random();
            int num_carte =  0 + random.nextInt(15-0);
            popup_commu.afficher_popup(nb_case);
            logic_communaute.action_carte(num_carte, JoueurX);
            System.out.println("Le joueur" + JoueurX.getName() + " est sur une case communaute");
        }
        //
        else {
            int type = wichType(nb_case);

            if (type == 1){
                System.out.println("Le joueur" + JoueurX.getName() + " est sur une compagnie");
                for (int i = 0; i<list_compagnies.size(); i++){
                    compagnie = list_compagnies.get(i);
                    if (compagnie.getEmplacement() == nb_case){
                        if(compagnie.getEnable() == false){
                            fairePayerCompagnies(compagnie, JoueurX, de);
                        }
                        else{
                            popup_action.achat_terrain_popup(nb_case);
                            JoueurX.acheter(compagnie);
                        }
                    }
                }
            }

            else if (type == 2){
                System.out.println("Le joueur" + JoueurX.getName() + " est sur une gare");
                for (int j = 0; j<list_gares.size(); j++){
                    gare = list_gares.get(j);
                    if (gare.getEmplacement() == nb_case){
                        if (gare.getEnable() == false){
                            fairePayerGares(gare, JoueurX);
                        }
                        else{
                            popup_action.achat_terrain_popup(nb_case);
                            JoueurX.acheter(gare);
                        }
                    }
                }
            }

            else if (type == 3){
                for (int k = 0; k<list_rues.size(); k++){
                    rue = list_rues.get(k);
                    if (rue.getEmplacement() == nb_case){
                        if (rue.getEnable() == false){
                            fairePayerRue(rue, JoueurX);
                        }
                        else{
                            popup_action.achat_terrain_popup(nb_case);
                            JoueurX.acheter(rue);
                        }
                    }
                }
            }
            //else if (type == 0) System.out.println("ERROR !");
        }

        //
        // /!\ faire 2 tableau contenant le numéros des cases maions et les cases evenments

    }

    private int fonctionPuissance(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result = base * result;
        }
        return result;
    }

    private int wichType (int nb_case){

        int check = 0;

        if (nb_case == 12 || nb_case == 28){
            check = 1;
        }
        else if (nb_case == 5 || nb_case == 15 || nb_case == 25 || nb_case == 35){
            check = 2;
        }
        else{
            check = 3;
        }

        return check;
    }

    private void fairePayerGares(Gares gare_actuel, Joueur JoueurX){
        int montant = 0;

        montant = cmb_gare(gare_actuel);
        if (gare_actuel.getProprietaire() == 1){

            Joueur1.recevoir(montant);
        }
        else if (gare_actuel.getProprietaire() == 2){
            Joueur2.recevoir(montant);
        }
        else if (gare_actuel.getProprietaire() == 3){
            Joueur3.recevoir(montant);
        }
        else if (gare_actuel.getProprietaire() == 4){
            Joueur4.recevoir(montant);
        }

        System.out.println("Le joueur " + JoueurX.getName() + " doit payer " + montant);
        JoueurX.payer(montant);
    }
    private int cmb_gare (Gares gare_actuel){
        int num = 0;
        Gares gare_checker;
        int apayer = 0;

        for (int i = 0; i<list_gares.size(); i++){
            gare_checker = list_gares.get(i);
            if (gare_actuel.getProprietaire() == gare_checker.getProprietaire()){
                num = num + 1;
            }
        }

        apayer = 25*fonctionPuissance(2, (num - 1));

        return apayer;
    }

    private void fairePayerCompagnies(Compagnies compagnie_actuel, Joueur JoueurX, int de){
        int montant = 0;

        montant = cmb_compagnie(compagnie_actuel, de);
        if (compagnie_actuel.getProprietaire() == 1){
            Joueur1.recevoir(montant);
        }
        else if (compagnie_actuel.getProprietaire() == 2){
            Joueur2.recevoir(montant);
        }
        else if (compagnie_actuel.getProprietaire() == 3){
            Joueur3.recevoir(montant);
        }
        else if (compagnie_actuel.getProprietaire() == 4){
            Joueur4.recevoir(montant);
        }

        JoueurX.payer(montant);
    }
    private int cmb_compagnie(Compagnies compagnie_actuel, int de){
        Compagnies compagnie_checker;
        int apayer = 0;
        int num =0;

        for (int i = 0; i<list_compagnies.size(); i++){
            compagnie_checker = list_compagnies.get(i);
            if (compagnie_actuel.getProprietaire() == compagnie_checker.getProprietaire()){
                num = num + 1;
            }

            if (num == 1) apayer = 4*de;
            else if (num == 2) apayer = 10*de;

        }

        return apayer;
    }

    private void fairePayerRue(Rues rue_actuel, Joueur JoueurX){
        int montant = 0;

        montant = cmb_rue(rue_actuel);
        if (rue_actuel.getProprietaire() == 1){
            Joueur1.recevoir(montant);
        }
        else if (rue_actuel.getProprietaire() ==2){
            Joueur2.recevoir(montant);
        }
        else if (rue_actuel.getProprietaire() == 3){
            Joueur3.recevoir(montant);
        }
        else if (rue_actuel.getProprietaire() == 4){
            Joueur4.recevoir(montant);
        }

        JoueurX.payer(montant);
    }
    private int cmb_rue(Rues rue_actuel){
        int apayer = 0;
        int num = 0;
        Rues rue_checker;
        ArrayList<Rues> listRues_couleur = new ArrayList<>();

        for (int i = 0; i<list_rues.size(); i++){
            rue_checker = list_rues.get(i);
            if (rue_actuel.getCouleur() == rue_checker.getCouleur()){
                listRues_couleur.add(rue_checker);
            }
        }

        for (int j = 0; j<listRues_couleur.size(); j++){
            rue_checker = listRues_couleur.get(j);
            if (rue_actuel.getProprietaire() == rue_checker.getProprietaire()){
                num = num + 1;
            }
        }

        if (listRues_couleur.size() == num){
            apayer = (rue_actuel.getLoyer() * 2);
        }
        else{
            apayer = rue_actuel.getLoyer();
        }

        return apayer;
    }

    public HBox setPlateau(){

        int dice_joueur = 0;

        HBox stage = new HBox();
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        Button rollDices = new Button("DICEEEEEES");





        vbox1.getChildren().addAll(rollDices, plateau.user_space(Joueur1, joueur_actuel),plateau.user_space(Joueur4, joueur_actuel));
        vbox2.getChildren().addAll(plateau.user_space(Joueur2, joueur_actuel),plateau.user_space(Joueur3, joueur_actuel));
        stage.getChildren().addAll(vbox1,plateau.getPlateau(Joueur1, Joueur2, Joueur3, Joueur4),vbox2);

        return stage;

    }




    public void test_game(int nb_j){

        boolean win = FALSE;

        int tour = 0;





        Joueur2.acheter(list_gares.get(0));
        Joueur2.acheter(list_gares.get(1));
        Joueur2.acheter(list_gares.get(2));
        Joueur2.acheter(list_gares.get(3));

        Joueur2.acheter((list_rues.get(0)));
        Joueur2.acheter((list_rues.get(1)));

        Joueur2.acheter(list_compagnies.get(0));
        Joueur2.acheter(list_compagnies.get(1));


        while (win == FALSE){




            /*rollDices.setOnAction(event -> {
                TDJ(Joueur1);
            });

            rollDices.setOnAction(event -> {
                TDJ(Joueur2);
            });*/

            System.out.println("Compte : " + Joueur1.getCompte());
            TDJ(Joueur1);
            System.out.println("Compte : " + Joueur1.getCompte());

            System.out.println("\nTour numero " + tour + ".");


            tour ++;

            if (Joueur1.getEnable() == FALSE && Joueur2.getEnable() == FALSE && Joueur3.getEnable() == FALSE && Joueur4.getEnable() == TRUE) {
                win = TRUE;
                System.out.println("\nLe joueur numéro 4 à gagné !");

            }
            else if (Joueur1.getEnable() == TRUE && Joueur2.getEnable() == FALSE && Joueur3.getEnable() == FALSE && Joueur4.getEnable() == FALSE) {
                win = TRUE;
                System.out.println("\nLe joueur numéro 1 à gagné !");
            if (tour == 1) win = TRUE;

            }
            else if (Joueur1.getEnable() == FALSE && Joueur2.getEnable() == TRUE && Joueur3.getEnable() == FALSE && Joueur4.getEnable() == FALSE) {
                win = TRUE;
                System.out.println("\nLe joueur numéro 2 à gagné !");

            }
            else if (Joueur1.getEnable() == FALSE && Joueur2.getEnable() == FALSE && Joueur3.getEnable() == TRUE && Joueur4.getEnable() == FALSE) {
                win = TRUE;
                System.out.println("\nLe joueur numéro 3 à gagné !");

            }
            else {
                win = FALSE;
            }
        }


    public HBox setPlateau(){
        HBox stage = new HBox();
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        rollDices.setOnAction(e -> {
            dice_button = true;
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2500),
                    ae -> dice_button = false));
            timeline.play();
        });




    }

}
