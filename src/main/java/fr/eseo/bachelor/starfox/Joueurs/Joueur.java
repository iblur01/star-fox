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
    protected int position_joueur;
    private Label label;
    private int num_joueur;
    private ArrayList<Terrains> list_terrains_joueur = new ArrayList<>();
    private Compte_bancaire compte = new Compte_bancaire(1500);

    private boolean enable = false;



    //Constructeur
    public Joueur (){}
    public Joueur(String name_j, int color, int num_joueur){
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
    public int getNum(){
        return num_joueur;
    }
    public Label getLabel() {
        return label;
    }
    public boolean getEnable() {
        return enable;
    }
    public int getCompte (){
        int salaire = compte.getArgent();
        return salaire;

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
        this.position_joueur = position;
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

    public void setEnable(boolean state) {
        this.enable = state;
    }
    //



    //Action du joueur
    public void acheter (Terrains terrains){
        if ( terrains.getEnableTerrain() ){
            list_terrains_joueur.add(terrains);
            compte.retirer_argent(terrains.getLoyer());
            terrains.setEnableTerrain(true);
        }
    }

    public int lance_de(){
        Random random = new Random();
        int num = 1 + random.nextInt(6-1);
        avancer(num);
        return num;
    }

    public void avancer(int de){
        position_joueur = position_joueur + de ;
        //return position_joueur;
    }

    public void vendre (Terrains terrains, int nb_case){
        for (int i = 0; i<list_terrains_joueur.size(); i++){
            if ( nb_case == terrains.getEmplacement() ){
                list_terrains_joueur.remove(nb_case);
                compte.ajouter_argent(terrains.getVal_vente());
                terrains.setEnableTerrain(false);
            }
        }
    }

    public void acheter_maison(Terrains terrains){

        int maison = terrains.getNmbr_maison();

        for (Terrains e : list_terrains_joueur){
            if ( e == terrains){
                maison = maison + 1;
                terrains.setMaison(maison);
                compte.retirer_argent( terrains.getPrix_maison() );
            }
        }
    }

    public void vendre_maison (Terrains terrains){

        int maison = terrains.getNmbr_maison();

        for (Terrains e : list_terrains_joueur){
            if ( e == terrains){
                maison = maison - 1;
                terrains.setMaison(maison);
                compte.ajouter_argent( terrains.getPrix_maison() );
            }
        }
    }

    public void passe_ton_tours (){


    }
    //
}

