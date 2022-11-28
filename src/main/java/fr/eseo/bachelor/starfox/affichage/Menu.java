package fr.eseo.bachelor.starfox.affichage;

import fr.eseo.bachelor.starfox.Joueurs.Joueur;
import fr.eseo.bachelor.starfox.TourDeJeu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Menu {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private GridPane root;
    private Label label;

    private int nombre_joueur = 0;

    private File buttonPara;
    private Image imageButtonPara;
    private ImageView imageViewButtonPara;

    private File file;
    private Image image;
    private ImageView imageView;

    private File fileStart;
    private Image imageStart;
    private ImageView imageViewStart;

    private File fileFond;
    private Image imageFond;
    private ImageView imageViewFond;
    private ImageView imageViewFond2;

    private File fileBonD;
    private Image imageBonD;
    private ImageView imageViewBonD;
    private File fileBonG;
    private Image imageBonG;
    private ImageView imageViewBonG;
    private ImageView imageViewBonG2;

    private ImageView imageViewBonD2;

    private boolean enable_lancement = FALSE;





    public GridPane initMenu(Stage stage){

        // test
        TourDeJeu TDJ = new TourDeJeu();

        Label output1 = new Label();
        Label output2 = new Label();
        Label output3 = new Label();
        Label output4 = new Label();

        Scene scene2 = new Scene(TDJ.setPlateau(), WIDTH, HEIGHT);
        stage.setScene(scene2);
        root = new GridPane();
        root.setStyle("-fx-background-color:lightblue");
        root.setAlignment(Pos.TOP_CENTER);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(20);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(60);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(20);
        root.getColumnConstraints().addAll(column1, column2, column3);
        RowConstraints row1 = new RowConstraints(10);
        row1.setPercentHeight(33);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(34);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(33);
        root.getRowConstraints().addAll(row1, row2, row3);

        buttonPara = new File("img/button_para.png");
        imageButtonPara = new Image(buttonPara.toURI().toString(),0.05*WIDTH,0.05*HEIGHT,false,false);
        imageViewButtonPara = new ImageView(imageButtonPara);

        file = new File("img/monopLabel.png");
        image = new Image(file.toURI().toString(),0.6*WIDTH,0.2*HEIGHT,false,false);
        imageView = new ImageView(image);

        fileStart = new File("img/start.png");
        imageStart = new Image(fileStart.toURI().toString(),0.3*WIDTH,0.125*HEIGHT,false,false);
        imageViewStart = new ImageView(imageStart);

        fileBonD = new File("img/bonhommeD.png");
        imageBonD = new Image(fileBonD.toURI().toString(),0.3*WIDTH,0.3*HEIGHT,false,false);
        imageViewBonD = new ImageView(imageBonD);

        fileBonG = new File("img/bonhommeG.png");
        imageBonG = new Image(fileBonG.toURI().toString(),0.3*WIDTH,0.3*HEIGHT,false,false);
        imageViewBonG = new ImageView(imageBonG);
        imageViewBonG2 = new ImageView(imageBonG);
        imageViewBonD2 = new ImageView(imageBonD);

        fileFond = new File("img/fond.png");
        imageFond = new Image(fileFond.toURI().toString(),0.3*WIDTH,0.125*HEIGHT,false,false);
        imageViewFond = new ImageView(imageFond);
        imageViewFond2 = new ImageView(imageFond);

        ComboBox<String> nombreJoueur = new ComboBox<>();
        nombreJoueur.getItems().addAll("2 joueurs","3 joueurs","4 joueurs");

        TextField inputJ1 = new TextField();
        inputJ1.setMaxSize(90,20);
        Label labelForInputJ1 = new Label("Nom Joueur 1 : ");
        labelForInputJ1.setLabelFor(inputJ1);

        TextField inputJ2 = new TextField();
        inputJ2.setMaxSize(90,20);
        Label labelForInputJ2 = new Label("Nom Joueur 2 : ");
        labelForInputJ2.setLabelFor(inputJ2);

        TextField inputJ3 = new TextField();
        inputJ3.setMaxSize(90,20);
        Label labelForInputJ3 = new Label("Nom Joueur 3 : ");
        labelForInputJ3.setLabelFor(inputJ3);

        TextField inputJ4 = new TextField();
        inputJ4.setMaxSize(90,20);
        Label labelForInputJ4 = new Label("Nom Joueur 4 : ");
        labelForInputJ4.setLabelFor(inputJ4);


        Button start = new Button();
        start.setGraphic(imageViewStart);
        start.setStyle("-fx-background-color:lightblue");


        Button para = new Button();
        para.setGraphic(imageViewButtonPara);

        Label titre = new Label();
        titre.setGraphic(imageView);

        VBox choixJoueur = new VBox();
        choixJoueur.getChildren().addAll(nombreJoueur,labelForInputJ1,inputJ1,labelForInputJ2,inputJ2,labelForInputJ3,inputJ3,labelForInputJ4,inputJ4);
        choixJoueur.setAlignment(Pos.TOP_CENTER);
        root.add(choixJoueur,1,2);

        HBox game = new HBox();
        game.getChildren().add(start);
        game.setAlignment(Pos.CENTER);
        root.add(game,1,1);

        HBox top = new HBox();
        top.getChildren().add(titre);
        top.setAlignment(Pos.CENTER);
        root.add(top,1,0);

        VBox parametre = new VBox();
        parametre.getChildren().add(para);
        parametre.setAlignment(Pos.TOP_RIGHT);
        root.add(parametre,2,0);

        root.add(output1,0,1);
        root.add(output2,0,2);
        root.add(output3,2,1);
        root.add(output4,2,2);

        nombreJoueur.setOnAction(event -> {
            if (nombreJoueur.getValue().equals("2 joueurs"))
            {
                enable_lancement = TRUE;
                output1.setGraphic(imageViewBonG);
                output2.setGraphic(imageViewFond2);
                output3.setGraphic(imageViewBonD);
                output4.setGraphic(imageViewFond);
                nombre_joueur = 2;
                TDJ.setNameAll(inputJ1.getText(),inputJ2.getText(),"","");
            }

            else if (nombreJoueur.getValue().equals("3 joueurs"))
            {
                enable_lancement = TRUE;
                output1.setGraphic(imageViewBonG);
                output2.setGraphic(imageViewBonG2);
                output3.setGraphic(imageViewBonD);
                output4.setGraphic(imageViewFond);
                nombre_joueur = 3;
                TDJ.setNameAll(inputJ1.getText(),inputJ2.getText(),inputJ3.getText(),"NULL");

            }

            else if (nombreJoueur.getValue().equals("4 joueurs"))
            {
                enable_lancement = TRUE;
                output1.setGraphic(imageViewBonG);
                output2.setGraphic(imageViewBonG2);
                output3.setGraphic(imageViewBonD);
                output4.setGraphic(imageViewBonD2);
                nombre_joueur = 4;
                TDJ.setNameAll(inputJ1.getText(),inputJ2.getText(),inputJ3.getText(),inputJ4.getText());
            }
        }
        );

        start.setOnAction(e -> {

            if (enable_lancement == TRUE){
                TDJ.init_TDJ(nombre_joueur);
                stage.setScene(scene2);
            }

            else{
                Alert popup = new Alert(Alert.AlertType.NONE,"default Dialog", ButtonType.OK);
                popup.setTitle("WARNING");
                popup.setContentText("Vous ne pouvez pas lancer une parti sans selectionner de joueur.");

                popup.showAndWait();
            }


        });

        return root;

    }


}
