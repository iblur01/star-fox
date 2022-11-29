package fr.eseo.bachelor.starfox.Joueurs;
import fr.eseo.bachelor.starfox.bank.Compte_bancaire;
import fr.eseo.bachelor.starfox.cases.Compagnies;
import fr.eseo.bachelor.starfox.cases.Gares;
import fr.eseo.bachelor.starfox.cases.Rues;
import fr.eseo.bachelor.starfox.cases.Terrains;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Joueur {
    private String name_j;
    private int color;

    private String hexColor;
    protected int position_joueur;
    private Label label;
    private int num_joueur;
    private ArrayList<Integer> list_rue = new ArrayList<>();
    private ArrayList<Integer> list_gare = new ArrayList<>();
    private ArrayList<Integer> list_compagnie = new ArrayList<>();
    private Compte_bancaire compte = new Compte_bancaire(1500);

    private boolean enable = true;




    //Constructeur
    public Joueur (){}
    public Joueur(String name_j, String color, int num_joueur){
        setParam(name_j, color, num_joueur);
        //compte = new Compte_bancaire(1500);

        /*if (num_joueur < 1) num_joueur = 1;
        else if (num_joueur > 4){
            num_joueur = 0;
            color = 0;
            setName("ERROR");
        }*/
    }
    //


    //geteur
    public String getName() {
        return name_j;
    }
    public int getColor() {
        return color;
    }
    public int getPosition() {
        return position_joueur;
    }
    public boolean getEnable() {
        return enable;
    }
    public String getHexColor(){return hexColor;}
    public int getCompte (){
        int salaire = compte.getArgent();
        return salaire;

    }
    public ArrayList<Integer> getList_gare(){
        return list_gare;
    }
    //


    //setteur
    public void setName(String name_j) {
        this.name_j = name_j;
        label = new Label();
        label.setText(name_j);
    }
    public void setHexColor(String color){
        this.hexColor = color;
    }
    public void setPosition(int position) {
        this.position_joueur = position;
    }
    public void setParam(String name_j, String color, int num_joueur){
        setName(name_j);
        //setColor(color);
        this.hexColor = color;
        setPosition(0);
        //setNum(num);
        this.num_joueur =  num_joueur;
    }
    public void setEnable(boolean state) {
        this.enable = state;
    }
    //



    //Action du joueur
    public void acheter (int nb_case){

        boolean check = true;

        if (nb_case == 5 || nb_case == 15 || nb_case == 25 || nb_case == 35){
            int rue;
            for (int i = 0; i<list_gare.size(); i++){
                rue = list_gare.get(i);
                if (rue == nb_case){
                    check = false;
                }
            }
            if (check){
                list_gare.add(nb_case);
                compte.retirer_argent(200);
            }
        }

        check =  true;
        if (nb_case == 12 || nb_case == 28) {
            int compagnie;
            for (int i = 0; i<list_compagnie.size(); i++){
                compagnie = list_compagnie.get(i);
                if (compagnie == nb_case){
                    check = false;
                }
            }
            if (check){
                list_compagnie.add(nb_case);
                compte.retirer_argent(150);
            }
        }
    }

    public int lance_de(){
        Random random = new Random();
        int de1 = 1 + random.nextInt(6-1);
        int de2 = 1 + random.nextInt(6-1);
        int num = de1 + de2;

        if (position_joueur >= 0 && position_joueur <= 39){
            avancer(num);
        }

        if ( de1 == de2){
            avancer(num);
        }

        return num;
    }

    public void avancer(int de){
        System.out.println(position_joueur);
        position_joueur = position_joueur + de ;

        System.out.println(position_joueur);

        //return position_joueur;
    }

    public void vendre (int nb_case){
        /*for (int i = 0; i<list_rue.size(); i++){
            if ( nb_case == rue.getEmplacement() ){
                list_rue.remove(nb_case);
                compte.ajouter_argent(rue.getVal_vente());
                rue.setEnableTerrain(false);
            }
        }*/
    }

    public void acheter_maison(Terrains terrains){

        /*int maison = terrains.getNmbr_maison();

        for (Terrains e : list_terrains_joueur){
            if ( e == terrains){
                maison = maison + 1;
                terrains.setMaison(maison);
                compte.retirer_argent( terrains.getPrix_maison() );
            }
        }*/
    }

    public void vendre_maison (Terrains terrains){

        /*int maison = terrains.getNmbr_maison();

        for (Terrains e : list_terrains_joueur){
            if ( e == terrains){
                maison = maison - 1;
                terrains.setMaison(maison);
                compte.ajouter_argent( terrains.getPrix_maison() );
            }
        }*/
    }

    public void passe_ton_tours (){


    }

    public void event(){
        if (position_joueur == 0) compte.ajouter_argent(200);

        else if (position_joueur == 4) compte.retirer_argent(200);

        else if (position_joueur == 38) compte.retirer_argent(100);
    }
    //
}

