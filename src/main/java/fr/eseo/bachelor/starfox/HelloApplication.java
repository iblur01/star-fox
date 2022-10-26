package fr.eseo.bachelor.starfox;


import fr.eseo.bachelor.starfox.affichage.Menu;
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

    private final int WIDTHm = 500;
    private final int HEIGHTm = 500;

    @Override
    public void start(Stage stage) throws IOException {



        Menu menu = new Menu();
        menu.initMenu(stage);
        menu.initMenu(stage);





        Scene scene1 = new Scene(menu.initMenu(stage), WIDTHm, HEIGHTm);





        stage.setScene(scene1);
        //stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}