package fr.eseo.bachelor.starfox;


import fr.eseo.bachelor.starfox.Joueurs.Joueur;
import fr.eseo.bachelor.starfox.affichage.Menu;
import fr.eseo.bachelor.starfox.affichage.Plateau;
import fr.eseo.bachelor.starfox.cases.*;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.skin.ComboBoxBaseSkin;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Long.MAX_VALUE;

public class HelloApplication extends Application {


    private final int WIDTH = 700;
    private final int HEIGHT = 700;

    private final int WIDTHm = 500;
    private final int HEIGHTm = 500;


    @Override
    public void start(Stage stage) throws IOException {




        Menu menu = new Menu();
        menu.initMenu(stage);
        menu.initMenu(stage);



        GridPane root = new GridPane(); // pour tester des trucs



        Scene scene1 = new Scene(menu.initMenu(stage), WIDTHm, HEIGHTm);




        stage.setScene(scene1);

        //
        stage.setScene(scene1);
        //

        //test
        //stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}