package fr.eseo.bachelor.starfox.affichage;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.Optional;

public class Gares_Popup {
    ArrayList<String> carte_gare = new ArrayList<>();

    public void afficher_popup(int emplacement){

        Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
        dialogC.setTitle(this.carte_gare.get(emplacement));
        dialogC.setHeaderText(null);
        dialogC.setContentText("Voulez-vous confirmer ?");
        Optional<ButtonType> answer = dialogC.showAndWait();
        if(answer.get() == ButtonType.OK) {
            // ...
        } else {
            // ...
        }
    }

    private void generation_gares(){

        carte_gare.add("Bar du Tonton Foch");
        carte_gare.add("Bar du Maestro");
        carte_gare.add("Bar du James Joyces");
        carte_gare.add("Bar du Delirium");
    }
}
