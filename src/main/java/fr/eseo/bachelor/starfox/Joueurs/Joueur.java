package fr.eseo.bachelor.starfox.Joueurs;
import fr.eseo.bachelor.starfox.bank.Compte_bancaire;
import fr.eseo.bachelor.starfox.cases.Compagnies;
import fr.eseo.bachelor.starfox.cases.Gares;
import fr.eseo.bachelor.starfox.cases.Rues;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Joueur {
    private String name_j;
    private int color;
    protected int position_joeur;
    private Label label;
    private int num_joueur;
    private Map<Integer, Rues> list_rues_j = new HashMap<>();
    private ArrayList<Gares> list_gares_j;
    private ArrayList<Compagnies> list_compagnies_j;

    private Compte_bancaire compte;



    //Constructeur
    public Joueur (){

    }
    public Joueur(String name_j, int color, int num_joueur){
        setParam(name_j, color, num_joueur);
        compte = new Compte_bancaire(1500);
        if (num_joueur > 4){
            num_joueur = 0;
            color = 0;
            setName("ERROR");
        }
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
        return position_joeur;
    }
    public int getNum(){
        return num_joueur;
    }
    public Label getLabel() {
        return label;
    }
    //

    //setteur
    public void setName(String name_j) {
        this.name_j = name_j;
        label = new Label();
        label.setText(name_j);
    }
    /*public void setColor(int color) {
        this.color = color;
    }*/
    public void setPosition(int position) {
        this.position_joeur = position;
    }
    /*public void setNum(int num){
        this.num = num;
    }*/
    public void setParam(String name_j, int color, int num_joueur){
        setName(name_j);
        //setColor(color);
        this.color = color;
        setPosition(0);
        //setNum(num);
        this.num_joueur =  num_joueur;
    }
    //


    //Action du joueur
    public void acheter (Rues rue){
        if (rue.getProprietaire() != 0 ) {
            list_rues_j.put(rue.getEmplacement(), rue);
            compte.retirer_argent(rue.getLoyer());
            rue.setProprietaire(num_joueur);
        }
        //else print("ERROR");
    }

    public void acheter(Gares gare){
        list_gares_j.add(gare);
    }

    public void acheter(Compagnies compagnie){
        list_compagnies_j.add(compagnie);
    }

    /*public void acheter(Rues rue, Gares gare, Compagnies compagnie){
        acheter(rue);
        acheter(gare);
        acheter(compagnie);
    }*/

    public int lance_de(){
        Random random = new Random();
        int num = 1 + random.nextInt(6-1);
        return num;
    }

    public int avancer(int de){
        position_joeur = position_joeur + de ;
        return position_joeur;
    }

    public void vendre (Rues rue, int num_joueur){
        list_rues_j.remove(rue.getEmplacement());
        rue.setProprietaire(num_joueur);
        compte.ajouter_argent(rue.getVal_vente());
    }
    //

    //test test

}

