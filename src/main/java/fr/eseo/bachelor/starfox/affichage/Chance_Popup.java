package fr.eseo.bachelor.starfox.affichage;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Chance_Popup {
    ArrayList<String> carte_chance = new ArrayList<>();

    public void afficher_popup(int nb_carte){
        this.generation_cartes();
        Alert popup = new Alert(Alert.AlertType.WARNING);
        popup.setTitle("Warning");
        popup.setHeaderText(null);
        popup.setContentText(this.carte_chance.get(nb_carte));
        popup.showAndWait();
    }

    private void generation_cartes(){
        carte_chance.add("Afterwork à l'eseo.");
        carte_chance.add("Avancer à la case départ.");
        carte_chance.add("Alles chercher du lait au carrefour grand Maine. Si vous passez par la case départ, recevez 200€.");
        carte_chance.add("Soirée à la chapelle. Si vous passez par la case départ, recevez 200€.");
        carte_chance.add("Le prix de l'éléctricité augemente, payez 40€ par maison et 115€ par hôtel.");
        carte_chance.add("Avancez jusqu’au bar du Maestro. Si vous passez par la case départ, recevez 200€.");
        carte_chance.add("Vous gagnez votre place au WEI, recevez 100€.");
        carte_chance.add("La chance ! Vous trouvez un billet de 50€ par terre.");
        carte_chance.add("Vous êtes libéré de Polytech. Cette carte peut être conservée jusqu’à ce qu’elle soit utilisée ou vendue.");
        carte_chance.add("Recule de 3 cases.");
        carte_chance.add("Va à polytech. Ne passez pas par la case départ, ne touchez pas 200€.");
        carte_chance.add("EDF veut votre peau, payez 50€ par maison et 110€ par hotels.");
        carte_chance.add("Le distributeur est bloqué, payez 40€.");
        carte_chance.add("Payez les frais d'ESEO 50€.");
        carte_chance.add("Sortie de bar douleureuse, amende de 40€.");
        carte_chance.add("Vous refusez un jeudi au bar, recevez 150€.");


    }

    private void action_carte(int nb_cartes){

        if (nb_cartes == 0){
            //Le joueur actuel va à la case eseo
        }
        else if(nb_cartes == 1){
            //Le joueur actuel va à la case depart
        }
        else if(nb_cartes == 2){
            //Le joueur actuel va à la case grand maine
            // if (case depart sur le chemin)
            //joueur actuel + 200€
        }
        else if(nb_cartes == 3){
            //Le joueur actuel va à la case chapelle
            // if (case depart sur le chemin)
            //joueur actuel + 200€
        }
        else if(nb_cartes == 4){
            //Joueur actuel -((40*nombre_maison)+(115*nombre_hotels))
        }
        else if(nb_cartes == 5){
            //Le joueur actuel va à la case bar Maestro
            // if (case depart sur le chemin)
            //joueur actuel + 200€
        }
        else if(nb_cartes == 6){
            //Joueur actuel +100€
        }
        else if(nb_cartes == 7){
            //Joueur actuel +50€
        }
        else if(nb_cartes == 8){
            //Joueur actuel +carte libérer polytech
        }
        else if(nb_cartes == 9){
            //Position Joueur actuel = Position Joueur actuel - 3
        }
        else if(nb_cartes == 10){
            //Joueur actuel va à Polytech
        }
        else if(nb_cartes == 11){
            //Joueur actuel -((50*nombre_maison)+(110*nombre_hotels))
        }
        else if(nb_cartes == 12){
            //Joueur actuel -40€
        }
        else if(nb_cartes == 13){
            //Joueur actuel -50€
        }
        else if(nb_cartes == 14){
            //Joueur actuel -40€
        }
        else if(nb_cartes == 15){
            //Joueur actuel +150€
        }
    }
}
