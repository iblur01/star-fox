package fr.eseo.bachelor.starfox.affichage;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Commu_Popup {
    ArrayList<String> carte_commu = new ArrayList<>();

    public void afficher_popup(int nb_carte){
        this.generation_cartes();
        Alert popup = new Alert(Alert.AlertType.WARNING);
        popup.setTitle("COMMUNAUTE");
        popup.setHeaderText(null);
        popup.setContentText(this.carte_commu.get(nb_carte));
        popup.showAndWait();
    }

    private void generation_cartes(){
        carte_commu.add("Avancer à la case départ.");
        carte_commu.add("Erreur du Crous, recevez 200€.");
        carte_commu.add("Depistage complet, paye 50€.");
        carte_commu.add("Erreur à la cafet, reçoit 50€.");
        carte_commu.add("Vous êtes libéré de Polytech. Cette carte peut être conservée jusqu’à ce qu’elle soit utilisée ou vendue.");
        carte_commu.add("Direction Polytech. Ne passez pas par la case départ, ne touchez pas 200€.");
        carte_commu.add("Retournez au Tacos.");
        carte_commu.add("Le crous vous paye enfin, recevez 100€.");
        carte_commu.add("C’est votre anniversaire. Chaque joueur doit vous donner 10€.");
        carte_commu.add("Merci la CAF, recevez 20€.");
        carte_commu.add("Votre ami vous rembourse enfin, recevez 25€.");
        carte_commu.add("Achat d'une nouvelle calculatrice collège, payez 50€.");
        carte_commu.add("Tu payes une tournée generale, payez 20€ à chaque joueur.");
        carte_commu.add("Rendez-vous au bar le plus proche. Si vous passez par la case départ, recevez 200€.");
        carte_commu.add("Vous gagnez le deuxième prix du concours de photo de l'eseo, recevez 10€.");
        carte_commu.add("Vous recevez la prime Macron, touchez 100€.");




    }


}
