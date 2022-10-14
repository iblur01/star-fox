package fr.eseo.bachelor.starfox.affichage;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Commu_Popup {
    ArrayList<String> carte_commu = new ArrayList<>();

    public void afficher_popup(int nb_carte){
        this.generation_cartes();
        Alert popup = new Alert(Alert.AlertType.WARNING);
        popup.setTitle("Warning");
        popup.setHeaderText(null);
        popup.setContentText(this.carte_commu.get(nb_carte));
        popup.showAndWait();
    }

    private void generation_cartes(){
        carte_commu.add("Avancer à la case départ.");
        carte_commu.add("Erreur du Crous, tu gagnes 200€.");
        carte_commu.add("Depistage complet, paye 50€.");
        carte_commu.add("Erreur à la cafet, gagne 50€");
        carte_commu.add("Vous êtes libéré de Polytech. Cette carte peut être conservée jusqu’à ce qu’elle soit utilisée ou vendue.");
        carte_commu.add("Direction Polytech. Ne franchissez pas par la case départ, ne touchez pas 200.");
        carte_commu.add("Erreur du Crous tu gagnes 200€.");
        carte_commu.add("Erreur du Crous tu gagnes 200€.");
        carte_commu.add("Erreur du Crous tu gagnes 200€.");
        carte_commu.add("Erreur du Crous tu gagnes 200€.");
        carte_commu.add("Erreur du Crous tu gagnes 200€.");
        carte_commu.add("Erreur du Crous tu gagnes 200€.");
        carte_commu.add("Erreur du Crous tu gagnes 200€.");
        carte_commu.add("Erreur du Crous tu gagnes 200€.");
        carte_commu.add("Erreur du Crous tu gagnes 200€.");
        carte_commu.add("Erreur du Crous tu gagnes 200€.");




    }

    private void action_carte(int nb_cartes){
        if (nb_cartes == 0){
            //Action carte
        }
        else if(nb_cartes == 1){

        }
    }

}
