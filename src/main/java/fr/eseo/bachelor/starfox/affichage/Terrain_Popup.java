package fr.eseo.bachelor.starfox.affichage;

import fr.eseo.bachelor.starfox.Joueurs.Joueur;
import fr.eseo.bachelor.starfox.cases.Terrains;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.Optional;

import static java.lang.Boolean.TRUE;

public class Terrain_Popup {
    ArrayList<String> carte_terrain = new ArrayList<>();
    ArrayList<String> prix_terrain = new ArrayList<>();
    ArrayList<String> loyer_terrain = new ArrayList<>();
    ArrayList<String> maison1_terrain = new ArrayList<>();
    ArrayList<String> maison2_terrain = new ArrayList<>();
    ArrayList<String> maison3_terrain = new ArrayList<>();

    ArrayList<String> maison4_terrain = new ArrayList<>();
    ArrayList<String> hotel_terrain = new ArrayList<>();
    ArrayList<String> hypotheque_terrain = new ArrayList<>();

    public void terrain_popup(int emplacement){

        this.generation_terrain();
        this.generation_hotel();
        this.generation_prix();
        this.generation_loyer();
        this.generation_maison1();
        this.generation_maison2();
        this.generation_maison3();
        this.generation_maison4();
        this.generation_hypotheque();

        if (emplacement == 12 || emplacement == 28)
        {
            Alert popup = new Alert(Alert.AlertType.NONE,"default Dialog",ButtonType.OK);
            popup.setTitle(this.carte_terrain.get(emplacement));
            popup.setHeaderText("" +
                    "                            Relancez les dès : \n\n" +
                    "                      Si vous possèdez une seul \n " +
                    "                   compagnie, le loyer est 4 fois  \n " +
                    "                   le montant indiqué par les dès. \n \n " +
                    "                      Si vous possèdez les deux  \n " +
                    "                     cartes compagnies, le loyer \n" +
                    "                    est 10 fois le montant indiqué\n" +
                    "                                par les dès.\n \n" +
                    "                           Valeur Hypothécaire\n" +
                    "                                     € 75");
            popup.setContentText("");
            popup.showAndWait();
        }

        else if(emplacement == 5 || emplacement == 15 || emplacement == 25 || emplacement == 35)
        {
            Alert popup = new Alert(Alert.AlertType.NONE,"default Dialog",ButtonType.OK);
            popup.setTitle(this.carte_terrain.get(emplacement));
            popup.setHeaderText("" +
                    "                          Valeur d'achat : 200€ \n\n" +
                    "                             LOYER             25\n " +
                    "                            Avec 2 Bars     50 \n " +
                    "                            Avec 3 Bars     100 \n " +
                    "                            Avec 4 Bars     200 \n " +
                    "                          Valeur Hypothécaire \n" +
                    "                                       € 100");
            popup.setContentText("");
            popup.showAndWait();

        }
        else if (emplacement == 0 || emplacement == 2 ||emplacement == 4 || emplacement == 7 ||emplacement == 10 || emplacement == 17 ||emplacement == 20 || emplacement == 22 ||emplacement == 30 || emplacement == 33 ||emplacement == 36 || emplacement == 38)
        {
            Alert popup = new Alert(Alert.AlertType.NONE,"default Dialog",ButtonType.OK);
            popup.setTitle(this.carte_terrain.get(emplacement));
            popup.setHeaderText(this.carte_terrain.get(emplacement));
            popup.setContentText("");
            popup.showAndWait();


        }
        else
        {
            Alert popup = new Alert(Alert.AlertType.NONE,"default Dialog",ButtonType.OK);
            popup.setTitle(this.carte_terrain.get(emplacement));
            popup.setHeaderText("" +
                    "                          Valeur d'achat : "+ this.prix_terrain.get(emplacement) +"€\n\n" +
                    "                                                         €\n" +
                    "         LOYER         Terrain nu            "+this.loyer_terrain.get(emplacement)+"\n " +
                    "                            Avec 1 maison     "+this.maison1_terrain.get(emplacement)+" \n " +
                    "                            Avec 2 maison     "+this.maison2_terrain.get(emplacement)+" \n " +
                    "                            Avec 3 maison     "+this.maison3_terrain.get(emplacement)+" \n " +
                    "                            Avec 4 maison     "+this.maison4_terrain.get(emplacement)+" \n " +
                    "                            Avec HÔTEL         "+this.hotel_terrain.get(emplacement)+" \n\n " +
                    "                           Valeur Hypothécaire\n" +
                    "                                       € "+this.hypotheque_terrain.get(emplacement)+"");
            popup.setContentText("");
            popup.showAndWait();

        }


    }

    public void achat_terrain_popup(Joueur JoueurX, Terrains terrains){

        this.generation_terrain();
        this.generation_hotel();
        this.generation_prix();
        this.generation_loyer();
        this.generation_maison1();
        this.generation_maison2();
        this.generation_maison3();
        this.generation_maison4();
        this.generation_hypotheque();

        int emplacement = terrains.getEmplacement();
        boolean enable_terrain = terrains.getEnableTerrain();

        if (emplacement == 12 || emplacement == 28)
        {
            Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
            dialogC.setTitle(this.carte_terrain.get(emplacement));
            dialogC.setHeaderText("" +
                    "                            Relancez les dès : \n\n" +
                    "                      Si vous possèdez une seul \n " +
                    "                   compagnie, le loyer est 4 fois  \n " +
                    "                   le montant indiqué par les dès. \n \n " +
                    "                      Si vous possèdez les deux  \n " +
                    "                     cartes compagnies, le loyer \n" +
                    "                    est 10 fois le montant indiqué\n" +
                    "                                par les dès.\n \n" +
                    "                           Valeur Hypothécaire\n" +
                    "                                     € 75");
            if (enable_terrain == TRUE) {
                dialogC.setContentText("Voulez-vous acheter ce terrain ?");
                Optional<ButtonType> answer = dialogC.showAndWait();
                if(answer.get() == ButtonType.OK) {
                    //fonction.achetercompagnie();
                    JoueurX.acheter(terrains);
                } else {

                }
            }
            else {
                dialogC.setContentText("Ce terrain appartient au joueur");
            }


        }

        else if(emplacement == 5 || emplacement == 15 || emplacement == 25 || emplacement == 35)
        {
            Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
            dialogC.setTitle(this.carte_terrain.get(emplacement));
            dialogC.setHeaderText("" +
                    "                          Valeur d'achat : 200€ \n\n" +
                    "                             LOYER             25\n " +
                    "                            Avec 2 Bars     50 \n " +
                    "                            Avec 3 Bars     100 \n " +
                    "                            Avec 4 Bars     200 \n " +
                    "                          Valeur Hypothécaire \n" +
                    "                                       € 100");
            dialogC.setContentText("Voulez-vous acheter ce terrain ?");
            Optional<ButtonType> answer = dialogC.showAndWait();
            if(answer.get() == ButtonType.OK) {
                //fonction.acheter gare();
                JoueurX.acheter(terrains);
            } else {

            }

        }
        else if (emplacement == 0 || emplacement == 2 ||emplacement == 4 || emplacement == 7 ||emplacement == 10 || emplacement == 17 ||emplacement == 20 || emplacement == 22 ||emplacement == 30 || emplacement == 33 ||emplacement == 36 || emplacement == 38)
        {
            Alert popup = new Alert(Alert.AlertType.NONE,"default Dialog",ButtonType.OK);
            popup.setTitle(this.carte_terrain.get(emplacement));
            popup.setHeaderText(this.carte_terrain.get(emplacement));
            popup.setContentText("");
            popup.showAndWait();


        }
        else
        {
            Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
            dialogC.setTitle(this.carte_terrain.get(emplacement));
            dialogC.setHeaderText("" +
                    "                          Valeur d'achat : "+ this.prix_terrain.get(emplacement) +"€\n\n" +
                    "                                                         €\n" +
                    "         LOYER         Terrain nu            "+this.loyer_terrain.get(emplacement)+"\n " +
                    "                            Avec 1 maison     "+this.maison1_terrain.get(emplacement)+" \n " +
                    "                            Avec 2 maison     "+this.maison2_terrain.get(emplacement)+" \n " +
                    "                            Avec 3 maison     "+this.maison3_terrain.get(emplacement)+" \n " +
                    "                            Avec 4 maison     "+this.maison4_terrain.get(emplacement)+" \n " +
                    "                            Avec HÔTEL         "+this.hotel_terrain.get(emplacement)+" \n\n " +
                    "                           Valeur Hypothécaire\n" +
                    "                                       € "+this.hypotheque_terrain.get(emplacement)+"");
            dialogC.setContentText("Voulez-vous acheter ce terrain ?");
            Optional<ButtonType> answer = dialogC.showAndWait();
            if(answer.get() == ButtonType.OK) {
                //fonction.acheter();
                JoueurX.acheter(terrains);
            } else {

            }

        }


    }

    private void generation_terrain(){

        carte_terrain.add("Depart");
        carte_terrain.add("Tacos");
        carte_terrain.add("Caisse Communauté");
        carte_terrain.add("Mc Do");
        carte_terrain.add("Problème de CAF");
        carte_terrain.add("Bar du Tonton Foch");
        carte_terrain.add("Point Chicken");
        carte_terrain.add("Chance");
        carte_terrain.add("Food 49");
        carte_terrain.add("Mc Donner");
        carte_terrain.add("Polytech");
        carte_terrain.add("La Chapelle");
        carte_terrain.add("La 7ème compagnie");
        carte_terrain.add("Le Carré");
        carte_terrain.add("Le Mid");
        carte_terrain.add("Bar du Maestro");
        carte_terrain.add("Le Prime");
        carte_terrain.add("Caisse Communauté");
        carte_terrain.add("So Sushi");
        carte_terrain.add("Fresh Burritos");
        carte_terrain.add("La Cafet");
        carte_terrain.add("L'Atoll");
        carte_terrain.add("Chance");
        carte_terrain.add("Espace Anjou");
        carte_terrain.add("Grand Maine");
        carte_terrain.add("Bar du James Joyces");
        carte_terrain.add("Lac de Maine");
        carte_terrain.add("Aqua Vita");
        carte_terrain.add("La 7ème compagnie");
        carte_terrain.add("Les Sablières");
        carte_terrain.add("Allez à Polytech");
        carte_terrain.add("Jardin des Plantes");
        carte_terrain.add("Jardin du Mail");
        carte_terrain.add("Caisse Communauté");
        carte_terrain.add("Terra Botanica");
        carte_terrain.add("Bar du Delirium");
        carte_terrain.add("Chance");
        carte_terrain.add("Le Château d'Angers");
        carte_terrain.add("Grève du Crous");
        carte_terrain.add("ESEO");



    }

    private void generation_prix(){

        prix_terrain.add("");
        prix_terrain.add("60");
        prix_terrain.add(" ");
        prix_terrain.add("60");
        prix_terrain.add("");
        prix_terrain.add("");
        prix_terrain.add("100");
        prix_terrain.add("");
        prix_terrain.add("100");
        prix_terrain.add("120");
        prix_terrain.add("");
        prix_terrain.add("140");
        prix_terrain.add("");
        prix_terrain.add("140");
        prix_terrain.add("160");
        prix_terrain.add("");
        prix_terrain.add("180");
        prix_terrain.add("");
        prix_terrain.add("180");
        prix_terrain.add("200");
        prix_terrain.add("");
        prix_terrain.add("220");
        prix_terrain.add("");
        prix_terrain.add("220");
        prix_terrain.add("240");
        prix_terrain.add("");
        prix_terrain.add("260");
        prix_terrain.add("260");
        prix_terrain.add("");
        prix_terrain.add("280");
        prix_terrain.add("");
        prix_terrain.add("300");
        prix_terrain.add("300");
        prix_terrain.add("");
        prix_terrain.add("320");
        prix_terrain.add("");
        prix_terrain.add("");
        prix_terrain.add("350");
        prix_terrain.add("");
        prix_terrain.add("400");
    }

    private void generation_loyer(){

        loyer_terrain.add("");
        loyer_terrain.add("2");
        loyer_terrain.add("");
        loyer_terrain.add("4");
        loyer_terrain.add("");
        loyer_terrain.add("");
        loyer_terrain.add("6");
        loyer_terrain.add("");
        loyer_terrain.add("6");
        loyer_terrain.add("8");
        loyer_terrain.add("");
        loyer_terrain.add("10");
        loyer_terrain.add("");
        loyer_terrain.add("10");
        loyer_terrain.add("12");
        loyer_terrain.add("");
        loyer_terrain.add("14");
        loyer_terrain.add("");
        loyer_terrain.add("14");
        loyer_terrain.add("16");
        loyer_terrain.add("");
        loyer_terrain.add("18");
        loyer_terrain.add("");
        loyer_terrain.add("18");
        loyer_terrain.add("20");
        loyer_terrain.add("");
        loyer_terrain.add("22");
        loyer_terrain.add("22");
        loyer_terrain.add("");
        loyer_terrain.add("24");
        loyer_terrain.add("");
        loyer_terrain.add("26");
        loyer_terrain.add("26");
        loyer_terrain.add("");
        loyer_terrain.add("28");
        loyer_terrain.add("");
        loyer_terrain.add("");
        loyer_terrain.add("35");
        loyer_terrain.add("");
        loyer_terrain.add("50");
    }

    private void generation_maison1(){

        maison1_terrain.add("");
        maison1_terrain.add("10");
        maison1_terrain.add("");
        maison1_terrain.add("20");
        maison1_terrain.add("");
        maison1_terrain.add("");
        maison1_terrain.add("30");
        maison1_terrain.add("");
        maison1_terrain.add("30");
        maison1_terrain.add("40");
        maison1_terrain.add("");
        maison1_terrain.add("50");
        maison1_terrain.add("");
        maison1_terrain.add("50");
        maison1_terrain.add("60");
        maison1_terrain.add("");
        maison1_terrain.add("70");
        maison1_terrain.add("");
        maison1_terrain.add("70");
        maison1_terrain.add("80");
        maison1_terrain.add("");
        maison1_terrain.add("90");
        maison1_terrain.add("");
        maison1_terrain.add("90");
        maison1_terrain.add("100");
        maison1_terrain.add("");
        maison1_terrain.add("110");
        maison1_terrain.add("110");
        maison1_terrain.add("");
        maison1_terrain.add("120");
        maison1_terrain.add("");
        maison1_terrain.add("130");
        maison1_terrain.add("130");
        maison1_terrain.add("");
        maison1_terrain.add("140");
        maison1_terrain.add("");
        maison1_terrain.add("");
        maison1_terrain.add("175");
        maison1_terrain.add("");
        maison1_terrain.add("200");



    }

    private void generation_maison2(){

        maison2_terrain.add("");
        maison2_terrain.add("30");
        maison2_terrain.add("");
        maison2_terrain.add("60");
        maison2_terrain.add("");
        maison2_terrain.add("");
        maison2_terrain.add("90");
        maison2_terrain.add("");
        maison2_terrain.add("90");
        maison2_terrain.add("100");
        maison2_terrain.add("");
        maison2_terrain.add("150");
        maison2_terrain.add("");
        maison2_terrain.add("150");
        maison2_terrain.add("180");
        maison2_terrain.add("");
        maison2_terrain.add("200");
        maison2_terrain.add("");
        maison2_terrain.add("200");
        maison2_terrain.add("220");
        maison2_terrain.add("");
        maison2_terrain.add("250");
        maison2_terrain.add("");
        maison2_terrain.add("250");
        maison2_terrain.add("300");
        maison2_terrain.add("");
        maison2_terrain.add("330");
        maison2_terrain.add("330");
        maison2_terrain.add("");
        maison2_terrain.add("360");
        maison2_terrain.add("");
        maison2_terrain.add("390");
        maison2_terrain.add("390");
        maison2_terrain.add("");
        maison2_terrain.add("450");
        maison2_terrain.add("");
        maison2_terrain.add("");
        maison2_terrain.add("500");
        maison2_terrain.add("");
        maison2_terrain.add("600");



    }

    private void generation_maison3(){

        maison3_terrain.add("");
        maison3_terrain.add("90");
        maison3_terrain.add("");
        maison3_terrain.add("180");
        maison3_terrain.add("");
        maison3_terrain.add("");
        maison3_terrain.add("270");
        maison3_terrain.add("");
        maison3_terrain.add("270");
        maison3_terrain.add("300");
        maison3_terrain.add("");
        maison3_terrain.add("450");
        maison3_terrain.add("");
        maison3_terrain.add("450");
        maison3_terrain.add("500");
        maison3_terrain.add("");
        maison3_terrain.add("550");
        maison3_terrain.add("");
        maison3_terrain.add("550");
        maison3_terrain.add("600");
        maison3_terrain.add("");
        maison3_terrain.add("700");
        maison3_terrain.add("");
        maison3_terrain.add("700");
        maison3_terrain.add("750");
        maison3_terrain.add("");
        maison3_terrain.add("800");
        maison3_terrain.add("800");
        maison3_terrain.add("");
        maison3_terrain.add("850");
        maison3_terrain.add("");
        maison3_terrain.add("900");
        maison3_terrain.add("900");
        maison3_terrain.add("");
        maison3_terrain.add("1000");
        maison3_terrain.add("");
        maison3_terrain.add("");
        maison3_terrain.add("1100");
        maison3_terrain.add("");
        maison3_terrain.add("1400");



    }

    private void generation_maison4(){

        maison4_terrain.add("");
        maison4_terrain.add("160");
        maison4_terrain.add("");
        maison4_terrain.add("320");
        maison4_terrain.add("");
        maison4_terrain.add("");
        maison4_terrain.add("400");
        maison4_terrain.add("");
        maison4_terrain.add("400");
        maison4_terrain.add("450");
        maison4_terrain.add("");
        maison4_terrain.add("625");
        maison4_terrain.add("");
        maison4_terrain.add("625");
        maison4_terrain.add("700");
        maison4_terrain.add("");
        maison4_terrain.add("700");
        maison4_terrain.add("");
        maison4_terrain.add("700");
        maison4_terrain.add("800");
        maison4_terrain.add("");
        maison4_terrain.add("875");
        maison4_terrain.add("");
        maison4_terrain.add("875");
        maison4_terrain.add("925");
        maison4_terrain.add("");
        maison4_terrain.add("975");
        maison4_terrain.add("975");
        maison4_terrain.add("");
        maison4_terrain.add("1025");
        maison4_terrain.add("");
        maison4_terrain.add("1100");
        maison4_terrain.add("1100");
        maison4_terrain.add("");
        maison4_terrain.add("1200");
        maison4_terrain.add("");
        maison4_terrain.add("");
        maison4_terrain.add("1300");
        maison4_terrain.add("");
        maison4_terrain.add("1700");



    }

    private void generation_hotel(){

        hotel_terrain.add("");
        hotel_terrain.add("250");
        hotel_terrain.add("");
        hotel_terrain.add("450");
        hotel_terrain.add("");
        hotel_terrain.add("");
        hotel_terrain.add("550");
        hotel_terrain.add("");
        hotel_terrain.add("550");
        hotel_terrain.add("600");
        hotel_terrain.add("");
        hotel_terrain.add("750");
        hotel_terrain.add("");
        hotel_terrain.add("750");
        hotel_terrain.add("900");
        hotel_terrain.add("");
        hotel_terrain.add("900");
        hotel_terrain.add("");
        hotel_terrain.add("950");
        hotel_terrain.add("1000");
        hotel_terrain.add("");
        hotel_terrain.add("1050");
        hotel_terrain.add("");
        hotel_terrain.add("1050");
        hotel_terrain.add("1100");
        hotel_terrain.add("");
        hotel_terrain.add("1150");
        hotel_terrain.add("1150");
        hotel_terrain.add("");
        hotel_terrain.add("1200");
        hotel_terrain.add("");
        hotel_terrain.add("1275");
        hotel_terrain.add("1275");
        hotel_terrain.add("");
        hotel_terrain.add("1400");
        hotel_terrain.add("");
        hotel_terrain.add("");
        hotel_terrain.add("1500");
        hotel_terrain.add("");
        hotel_terrain.add("2000");



    }

    private void generation_hypotheque(){

        hypotheque_terrain.add("");
        hypotheque_terrain.add("30");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("30");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("50");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("50");
        hypotheque_terrain.add("60");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("70");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("70");
        hypotheque_terrain.add("80");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("90");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("90");
        hypotheque_terrain.add("100");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("110");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("110");
        hypotheque_terrain.add("120");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("130");
        hypotheque_terrain.add("130");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("140");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("150");
        hypotheque_terrain.add("150");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("160");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("175");
        hypotheque_terrain.add("");
        hypotheque_terrain.add("200");



    }
}
