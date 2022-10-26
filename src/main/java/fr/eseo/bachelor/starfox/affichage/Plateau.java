package fr.eseo.bachelor.starfox.affichage;

import fr.eseo.bachelor.starfox.GrilleDeJeu;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.Long.MAX_VALUE;

public class Plateau {

    GrilleDeJeu grilleDeJeu = new GrilleDeJeu();


    private final int WIDTH_BOX = 120;
    private final int HEIGHT_BOX = 70;

    private final int DELTA_LABEL = 5;

    public void init(){
        grilleDeJeu.generation_grille();
    }

    public HBox getPlateau() {

        HBox root = new HBox();

        VBox vbox_gauche = new VBox();
        VBox vbox_droite = new VBox();
        VBox vbox_centre = new VBox();
        HBox top_center = new HBox();
        HBox bottom_center = new HBox();
        Label board_center = new Label();

        vbox_gauche.getChildren().addAll(buttons_game(20), buttons_game(19),buttons_game(18), buttons_game(17), buttons_game(16), buttons_game(15), buttons_game(14), buttons_game(13), buttons_game(12), buttons_game(11), buttons_game(10));
        vbox_droite.getChildren().addAll(buttons_game(30), buttons_game(31),buttons_game(32), buttons_game(33), buttons_game(34), buttons_game(35), buttons_game(36), buttons_game(37), buttons_game(38), buttons_game(39), buttons_game(0));
        top_center.getChildren().addAll(buttons_game(21),buttons_game(22), buttons_game(23), buttons_game(24), buttons_game(25), buttons_game(26), buttons_game(27), buttons_game(28), buttons_game(29));
        bottom_center.getChildren().addAll(buttons_game(9),buttons_game(8), buttons_game(7), buttons_game(6), buttons_game(5), buttons_game(4), buttons_game(3), buttons_game(2), buttons_game(1));

        board_center.setMinSize(70*9,70*9);
        vbox_centre.getChildren().addAll(top_center, board_center, bottom_center);
        root.getChildren().addAll(vbox_gauche, vbox_centre, vbox_droite);


        return root;

    }

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
            view.setFitHeight(120);}

        else if (case_plateau == 10){
            button.setMinSize(WIDTH_BOX, WIDTH_BOX);
            button.setMaxSize(WIDTH_BOX, WIDTH_BOX);
            button.setPrefSize(WIDTH_BOX, WIDTH_BOX);
            view.setFitHeight(120);}

        else if (case_plateau == 20){
            button.setMinSize(WIDTH_BOX, WIDTH_BOX);
            button.setMaxSize(WIDTH_BOX, WIDTH_BOX);
            button.setPrefSize(WIDTH_BOX, WIDTH_BOX);
            view.setFitHeight(120);}

        else if (case_plateau == 30){
            button.setMinSize(WIDTH_BOX, WIDTH_BOX);
            button.setMaxSize(WIDTH_BOX, WIDTH_BOX);
            button.setPrefSize(WIDTH_BOX, WIDTH_BOX);
            view.setFitHeight(120);}


        else if (case_plateau > 0 & case_plateau < 10){
            button.setPrefSize(HEIGHT_BOX, WIDTH_BOX-2*DELTA_LABEL);
            button.setMinSize(HEIGHT_BOX, WIDTH_BOX-2*DELTA_LABEL);
            button.setMaxSize(HEIGHT_BOX, WIDTH_BOX-2*DELTA_LABEL);


            label_zone_J.setMinSize(HEIGHT_BOX,DELTA_LABEL);
            label_zone_J.setMaxSize(HEIGHT_BOX,DELTA_LABEL);



            VBox case_box = new VBox();
            view.setFitHeight(100);
            case_box.getChildren().addAll(label_zone_J,button,jauge_m(2,0,"#33A2FF"));
            return case_box;
        }

        else if (case_plateau > 10 & case_plateau < 20){
            button.setMinSize(WIDTH_BOX, HEIGHT_BOX);
            button.setMaxSize(WIDTH_BOX, HEIGHT_BOX);
            button.setPrefSize(WIDTH_BOX, HEIGHT_BOX);
            view.setFitHeight(70);

        }

        else if (case_plateau > 20 & case_plateau < 30){
            button.setPrefSize(HEIGHT_BOX, WIDTH_BOX-DELTA_LABEL);
            button.setMinSize(HEIGHT_BOX, WIDTH_BOX-DELTA_LABEL);
            button.setMaxSize(HEIGHT_BOX, WIDTH_BOX-DELTA_LABEL);

            label_zone_J.setMinSize(HEIGHT_BOX,DELTA_LABEL);
            label_zone_J.setMaxSize(HEIGHT_BOX,DELTA_LABEL);

            VBox case_box = new VBox();
            view.setFitHeight(100);
            case_box.getChildren().addAll(button,label_zone_J);
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
            view.setFitHeight(70);
            case_box.getChildren().addAll(label_zone_J, button);
            return case_box;
        }
        return button;
    }

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

    private Node emplacementJ(int orientation, int caseA){
        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        Label l4 = new Label();
        Label l5 = new Label();

        /*if (nb>0){
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
        }*/


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

}
