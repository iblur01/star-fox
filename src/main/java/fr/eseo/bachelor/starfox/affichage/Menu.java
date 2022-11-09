package fr.eseo.bachelor.starfox.affichage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Menu {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private GridPane root;
    private Label label;

    private File buttonPara;
    private Image imageButtonPara;
    private ImageView imageViewButtonPara;

    private File file;
    private Image image;
    private ImageView imageView;

    private File fileStart;
    private Image imageStart;
    private ImageView imageViewStart;

    private File fileBon;
    private Image imageBon;
    private ImageView imageViewBon;





    public GridPane initMenu(Stage stage){

        // test
        Plateau plateau = new Plateau();

        Scene scene2 = new Scene(plateau.getPlateau(), WIDTH, HEIGHT);
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

        fileBon = new File("img/bonhomme.png");
        imageBon = new Image(fileBon.toURI().toString(),0.3*WIDTH,0.3*HEIGHT,false,false);
        imageViewBon = new ImageView(imageBon);

        ComboBox<String> nombreJoueur = new ComboBox<>();
        nombreJoueur.getItems().addAll("2 joueurs","3 joueurs","4 joueurs");

        Button start = new Button();
        start.setGraphic(imageViewStart);
        start.setStyle("-fx-background-color:lightblue");



        start.setOnAction(e -> stage.setScene(scene2));

        Button para = new Button();
        para.setGraphic(imageViewButtonPara);

        Label titre = new Label();
        titre.setGraphic(imageView);

        VBox choixJoueur = new VBox();
        choixJoueur.getChildren().add(nombreJoueur);
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



        root.add(imageViewBon,2,2);

        return root;

    }
}
