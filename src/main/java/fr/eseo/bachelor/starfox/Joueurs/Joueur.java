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
    private String hexColor;
    protected int position_joueur = 0;
    private int num_joueur;
    private ArrayList<Rues> list_rue = new ArrayList<>();
    private ArrayList<Gares> list_gare = new ArrayList<>();
    private ArrayList<Compagnies> list_compagnie = new ArrayList<>();
    private Compte_bancaire compte = new Compte_bancaire(1500);
    private boolean enable = false;




    //Constructeur
    public Joueur (){}
    public Joueur(String name_j, String color, int num_joueur){
        setParam(name_j, color, num_joueur);
    }
    //


    //geteur
    public String getName() {
        return name_j;
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
    public int getNum_joueur() {
        return num_joueur;
    }
    public ArrayList<Compagnies> getList_compagnie() {return list_compagnie;}
    //


    //setteur
    public void setName(String name_j) {
        this.name_j = name_j;
    }
    public void setHexColor(String color){
        this.hexColor = color;
    }
    public void setPosition(int position) {
        this.position_joueur = position;
    }
    public void setParam(String name_j, String color, int num_joueur){
        setName(name_j);
        setNum_joueur(num_joueur);
        setPosition(0);
        setEnable(true);
        setHexColor(color);
    }
    public void setEnable(boolean state) {
        this.enable = state;
    }
    public void setNum_joueur(int num_joueur) { this.num_joueur = num_joueur; }
    //



    //Action du joueur
    public void acheter (Rues rue){
        list_rue.add(rue);
        compte.retirer_argent(rue.getVal_achat());
        rue.setEnable(false);
        rue.setProprietaire(num_joueur);
        System.out.println("Le joueur" + getName() + " achete la rue " + rue.getName());
    }
    public void acheter (Gares gare){
            list_gare.add(gare);
            compte.retirer_argent(gare.getVal_achat());
            gare.setEnable(false);
            gare.setProprietaire(num_joueur);
            System.out.println("Le joueur" + getName() + " achete la gare " + gare.getName());
    }
    public void acheter (Compagnies compagnie){
        list_compagnie.add(compagnie);
        compte.retirer_argent(compagnie.getVal_achat());
        compagnie.setEnable(false);
        compagnie.setProprietaire(num_joueur);
        System.out.println("Le joueur" + getName() + " achete la compagnie " + compagnie.getName());
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


    public int lance_de(){
        Random random = new Random();
        int de1 = 1 + random.nextInt(6-1);
        int de2 = 1 + random.nextInt(6-1);
        int num = de1 + de2;

        if (position_joueur >= 0 && position_joueur <= 39){
            avancer(num);
        }

        return num;
    }
    public void avancer(int de){
        //System.out.println(position_joueur);
        position_joueur = position_joueur + de ;

        //System.out.println(position_joueur);

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
    public void payer(int apayer){
        compte.retirer_argent(apayer);
    }
    public void recevoir (int montant){
        compte.ajouter_argent(montant);
    }
    //
}

