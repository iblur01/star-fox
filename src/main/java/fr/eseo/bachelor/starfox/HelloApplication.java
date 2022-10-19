package fr.eseo.bachelor.starfox;


import fr.eseo.bachelor.starfox.affichage.Plateau;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Long.MAX_VALUE;

public class HelloApplication extends Application {


    private final int WIDTH = 700;
    private final int HEIGHT = 700;

    @Override
    public void start(Stage stage) throws IOException {


        Plateau plateau = new Plateau();

        Scene scene = new Scene(plateau.getPlateau(), WIDTH, HEIGHT);
        stage.setScene(scene);
        //stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}