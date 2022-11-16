package fr.eseo.bachelor.starfox.affichage;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.util.ArrayList;


public class Plateau {

    ArrayList<Integer>  emplacement = new ArrayList<>();

    private final int WIDTH_BOX = 120;
    private final int HEIGHT_BOX = 70;
    private final int DELTA_LABEL = 5;

    /**
     * @author Théo DELANNOY
     * @param J le numéro du joueur
     * @return l'emplacemaent du joueur en fonction de son num
     */
    private int getJ(int J){
        return this.emplacement.get(J);
    }


    /**
     * Generation du plateau complet.
     * @author Théo DELANNOY
     * //@param emplacementJ liste de contenant la place des joueur (liste de 4 cases)
     * @return plateau
     */
    public HBox getPlateau() { //ArrayList emplacementJ
        //this.emplacement = emplacementJ;

        this.emplacement.add(12);
        this.emplacement.add(13);
        this.emplacement.add(12);
        this.emplacement.add(12);

        File file;
        file = new File("img/background.png");
        Image img = new Image(file.toURI().toString());
        ImageView view = new ImageView(img);




        HBox root = new HBox();
        VBox vbox_gauche = new VBox();
        VBox vbox_droite = new VBox();
        VBox vbox_centre = new VBox();
        HBox top_center = new HBox();
        HBox bottom_center = new HBox();
        Label board_center = new Label();
        board_center.setGraphic(view);
        board_center.setMaxSize(560,560);
        board_center.setMinSize(560,560);



        vbox_gauche.getChildren().addAll(buttons_game(20), buttons_game(19),buttons_game(18), buttons_game(17), buttons_game(16), buttons_game(15), buttons_game(14), buttons_game(13), buttons_game(12), buttons_game(11), buttons_game(10));
        vbox_droite.getChildren().addAll(buttons_game(30), buttons_game(31),buttons_game(32), buttons_game(33), buttons_game(34), buttons_game(35), buttons_game(36), buttons_game(37), buttons_game(38), buttons_game(39), buttons_game(0));
        top_center.getChildren().addAll(buttons_game(21),buttons_game(22), buttons_game(23), buttons_game(24), buttons_game(25), buttons_game(26), buttons_game(27), buttons_game(28), buttons_game(29));
        bottom_center.getChildren().addAll(buttons_game(9),buttons_game(8), buttons_game(7), buttons_game(6), buttons_game(5), buttons_game(4), buttons_game(3), buttons_game(2), buttons_game(1));

        board_center.setMinSize(70*9,70*9);
        vbox_centre.getChildren().addAll(top_center, board_center, bottom_center);
        root.getChildren().addAll(vbox_gauche, vbox_centre, vbox_droite);


        return root;

    }

    /**
     * Génération d'un bouton contenant la carte
     * @param case_plateau numéro d'emplacement du bouton
     * @return retourne une vbox/hbox
     */

    private Node buttons_game(int case_plateau){
        Terrain_Popup TP = new Terrain_Popup();
        Button button = new Button();
        Label label_zone_J = new Label(); //barre de couleur pour la position du joueur
        Label label_zone_M = new Label(); //jauge de couleur pour la
        File file;

        file = new File("img/G_"+case_plateau+".png");
        Image img = new Image(file.toURI().toString());
        ImageView view = new ImageView(img);
        view.setPreserveRatio(true);
        button.setGraphic(view);
        button.setOnAction(e -> TP.terrain_popup(case_plateau));

        if (case_plateau == 0){
            button.setMinSize(WIDTH_BOX, WIDTH_BOX);
            button.setMaxSize(WIDTH_BOX, WIDTH_BOX);
            button.setPrefSize(WIDTH_BOX, WIDTH_BOX);
            view.setFitHeight(WIDTH_BOX);}

        else if (case_plateau == 10){
            button.setMinSize(WIDTH_BOX, WIDTH_BOX);
            button.setMaxSize(WIDTH_BOX, WIDTH_BOX);
            button.setPrefSize(WIDTH_BOX, WIDTH_BOX);
            view.setFitHeight(WIDTH_BOX);}

        else if (case_plateau == 20){
            button.setMinSize(WIDTH_BOX, WIDTH_BOX);
            button.setMaxSize(WIDTH_BOX, WIDTH_BOX);
            button.setPrefSize(WIDTH_BOX, WIDTH_BOX);
            view.setFitHeight(WIDTH_BOX);}

        else if (case_plateau == 30){
            button.setMinSize(WIDTH_BOX, WIDTH_BOX);
            button.setMaxSize(WIDTH_BOX, WIDTH_BOX);
            button.setPrefSize(WIDTH_BOX, WIDTH_BOX);
            view.setFitHeight(WIDTH_BOX);}


        else if (case_plateau > 0 & case_plateau < 10){
            button.setPrefSize(HEIGHT_BOX, WIDTH_BOX-2*DELTA_LABEL);
            button.setMinSize(HEIGHT_BOX, WIDTH_BOX-2*DELTA_LABEL);
            button.setMaxSize(HEIGHT_BOX, WIDTH_BOX-2*DELTA_LABEL);

            VBox case_box = new VBox();
            view.setFitHeight(WIDTH_BOX-10);
            case_box.getChildren().addAll(emplacementJ(0, case_plateau),button,jauge_m(2,0,"#33A2FF"));
            return case_box;
        }

        else if (case_plateau > 10 & case_plateau < 20){
            button.setMinSize(WIDTH_BOX-2*DELTA_LABEL, HEIGHT_BOX);
            button.setMaxSize(WIDTH_BOX-2*DELTA_LABEL, HEIGHT_BOX);
            button.setPrefSize(WIDTH_BOX-2*DELTA_LABEL, HEIGHT_BOX);


            view.setFitHeight(HEIGHT_BOX);

            HBox case_box = new HBox();
            case_box.getChildren().addAll(jauge_m(2,1,"#33A2FF"),button,emplacementJ(1, case_plateau));
            return case_box;

        }

        else if (case_plateau > 20 & case_plateau < 30){
            button.setPrefSize(HEIGHT_BOX, WIDTH_BOX-2*DELTA_LABEL);
            button.setMinSize(HEIGHT_BOX, WIDTH_BOX-2*DELTA_LABEL);
            button.setMaxSize(HEIGHT_BOX, WIDTH_BOX-2*DELTA_LABEL);

            VBox case_box = new VBox();
            view.setFitHeight(WIDTH_BOX-10);
            case_box.getChildren().addAll(jauge_m(2,0,"#33A2FF"),button,emplacementJ(0, case_plateau));
            return case_box;
        }

        else if (case_plateau > 30 & case_plateau < 40){
            button.setMinSize(WIDTH_BOX-2*DELTA_LABEL, HEIGHT_BOX);
            button.setMaxSize(WIDTH_BOX-2*DELTA_LABEL, HEIGHT_BOX);
            button.setPrefSize(WIDTH_BOX-2*DELTA_LABEL, HEIGHT_BOX);



            label_zone_J.setMinSize(DELTA_LABEL,HEIGHT_BOX);
            label_zone_J.setMaxSize(DELTA_LABEL,HEIGHT_BOX);

            label_zone_J.setRotate(270);
            HBox case_box = new HBox();
            view.setFitHeight(HEIGHT_BOX);
            case_box.getChildren().addAll(emplacementJ(1, case_plateau), button, jauge_m(2,1,"#33A2FF"));
            return case_box;
        }
        return button;
    }

    /**
     * Création de la jauge de batiment
     * @param nb numéro de case
     * @param orientation orientation de la case 0 > horizontal | 1 > Vertical
     * @param color couleur de la jauge
     * @return
     */

    private Node jauge_m(int nb, int orientation, String color){
        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        Label l4 = new Label();
        Label l5 = new Label();

        if (nb>0){
            l1.setStyle("-fx-alignment: center; -fx-background-color: "+color+";");
        }
        if (nb>1){
            l2.setStyle("-fx-alignment: center; -fx-background-color: "+color+";");
        }
        if (nb>2){
            l3.setStyle("-fx-alignment: center; -fx-background-color: "+color+";");
        }
        if (nb>3){
            l4.setStyle("-fx-alignment: center; -fx-background-color: "+color+";");
        }
        if (nb>4){
            l5.setStyle("-fx-alignment: center; -fx-background-color: "+color+";");
        }


        if (orientation==0){
            l1.setMinSize(HEIGHT_BOX/5,DELTA_LABEL);
            l1.setMaxSize(HEIGHT_BOX/5,DELTA_LABEL);
            l2.setMinSize(HEIGHT_BOX/5,DELTA_LABEL);
            l2.setMaxSize(HEIGHT_BOX/5,DELTA_LABEL);
            l3.setMinSize(HEIGHT_BOX/5,DELTA_LABEL);
            l3.setMaxSize(HEIGHT_BOX/5,DELTA_LABEL);
            l4.setMaxSize(HEIGHT_BOX/5,DELTA_LABEL);
            l4.setMinSize(HEIGHT_BOX/5,DELTA_LABEL);
            l5.setMaxSize(HEIGHT_BOX/5,DELTA_LABEL);
            l5.setMinSize(HEIGHT_BOX/5,DELTA_LABEL);
            HBox jauge = new HBox();
            jauge.getChildren().addAll(l1, l2, l3, l4, l5);
            return jauge;

        }
        else {
            VBox jauge = new VBox();

            l1.setMinSize(DELTA_LABEL,HEIGHT_BOX/5);
            l1.setMaxSize(DELTA_LABEL,HEIGHT_BOX/5);
            l2.setMinSize(DELTA_LABEL,HEIGHT_BOX/5);
            l2.setMaxSize(DELTA_LABEL,HEIGHT_BOX/5);
            l3.setMinSize(DELTA_LABEL,HEIGHT_BOX/5);
            l3.setMaxSize(DELTA_LABEL,HEIGHT_BOX/5);
            l4.setMaxSize(DELTA_LABEL,HEIGHT_BOX/5);
            l4.setMinSize(DELTA_LABEL,HEIGHT_BOX/5);
            l5.setMaxSize(DELTA_LABEL,HEIGHT_BOX/5);
            l5.setMinSize(DELTA_LABEL,HEIGHT_BOX/5);
            
            jauge.getChildren().addAll(l1, l2, l3, l4, l5);
            
            return jauge;
        }
    }

    private Node emplacementJ(int orientation, int case_actuelle){
        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        Label l4 = new Label();

        if (case_actuelle == this.emplacement.get(0)){
            l1.setStyle("-fx-alignment: center; -fx-background-color: "+"#0000fe"+";");
        }
        if (case_actuelle == this.emplacement.get(1)){
            l2.setStyle("-fx-alignment: center; -fx-background-color: "+"#ff0101"+";");
        }
        if (case_actuelle == this.emplacement.get(2)){
            l3.setStyle("-fx-alignment: center; -fx-background-color: "+"#fcdd00"+";");
        }
        if (case_actuelle == this.emplacement.get(3)){
            l4.setStyle("-fx-alignment: center; -fx-background-color: "+"#34623f"+";");
        }

        //l3.setStyle("-fx-alignment: center; -fx-background-color: "+"#00C49A"+";");


        if (orientation==0){
            l1.setMinSize(HEIGHT_BOX/4,DELTA_LABEL);
            l1.setMaxSize(HEIGHT_BOX/4,DELTA_LABEL);
            l2.setMinSize(HEIGHT_BOX/4,DELTA_LABEL);
            l2.setMaxSize(HEIGHT_BOX/4,DELTA_LABEL);
            l3.setMinSize(HEIGHT_BOX/4,DELTA_LABEL);
            l3.setMaxSize(HEIGHT_BOX/4,DELTA_LABEL);
            l4.setMaxSize(HEIGHT_BOX/4,DELTA_LABEL);
            l4.setMinSize(HEIGHT_BOX/4,DELTA_LABEL);
            HBox jauge = new HBox();
            jauge.getChildren().addAll(l1, l2, l3, l4);
            return jauge;

        }
        else {
            VBox jauge = new VBox();

            l1.setMinSize(DELTA_LABEL,HEIGHT_BOX/4);
            l1.setMaxSize(DELTA_LABEL,HEIGHT_BOX/4);
            l2.setMinSize(DELTA_LABEL,HEIGHT_BOX/4);
            l2.setMaxSize(DELTA_LABEL,HEIGHT_BOX/4);
            l3.setMinSize(DELTA_LABEL,HEIGHT_BOX/4);
            l3.setMaxSize(DELTA_LABEL,HEIGHT_BOX/4);
            l4.setMaxSize(DELTA_LABEL,HEIGHT_BOX/4);
            l4.setMinSize(DELTA_LABEL,HEIGHT_BOX/4);

            jauge.getChildren().addAll(l1, l2, l3, l4);

            return jauge;
        }
    }

}
