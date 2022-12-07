package fr.eseo.bachelor.starfox.Joueurs;
import fr.eseo.bachelor.starfox.bank.Compte_bancaire;
import fr.eseo.bachelor.starfox.cases.Compagnies;
import fr.eseo.bachelor.starfox.cases.Gares;
import fr.eseo.bachelor.starfox.cases.Rues;

import java.util.*;

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
        if (compte.voir_argent() > 0) {
            list_rue.add(rue);
            compte.retirer_argent(rue.getVal_achat());
            rue.setEnable(false);
            rue.setProprietaire(num_joueur);
        }
        System.out.println("Le joueur" + getName() + " achete la rue " + rue.getName());
    }
    public void acheter (Gares gare){
        if (compte.voir_argent() > 0) {
            list_gare.add(gare);
            compte.retirer_argent(gare.getVal_achat());
            gare.setEnable(false);
            gare.setProprietaire(num_joueur);
        }
            System.out.println("Le joueur" + getName() + " achete la gare " + gare.getName());
    }
    public void acheter (Compagnies compagnie){
        if (compte.voir_argent() > 0) {
            list_compagnie.add(compagnie);
            compte.retirer_argent(compagnie.getVal_achat());
            compagnie.setEnable(false);
            compagnie.setProprietaire(num_joueur);
        }
        System.out.println("Le joueur" + getName() + " achete la compagnie " + compagnie.getName());
    }
    public void acheter_maison(Rues rue) {

        if (compte.voir_argent() > 0){
            rue.setNmbr_maison(rue.getNmbr_maison() + 1);
            compte.retirer_argent(rue.getPrix_maison());
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

        return num;
    }
    public void avancer(int de){
        position_joueur = position_joueur + de ;
    }


    public void vendre (int nb_case){
        Rues rue;
        Gares gare;
        Compagnies compagnie;
        int new_ValAchat;

        for (int i = 0; i<list_rue.size(); i++){
            rue = list_rue.get(i);
            if (rue.getEmplacement() == nb_case){
                list_rue.remove(i);
                rue.setEnable(true);
                rue.setProprietaire(0);
                new_ValAchat = (rue.getVal_achat() / 2);
                rue.setVal_achat(new_ValAchat);
                compte.ajouter_argent(rue.getVal_vente());
            }
        }
        for (int j = 0; j<list_gare.size(); j++){
            gare = list_gare.get(j);
            if(gare.getEmplacement() == nb_case){
                list_gare.remove(j);
                gare.setEnable(true);
                gare.setProprietaire(0);
                new_ValAchat = (gare.getVal_achat() / 2);
                gare.setVal_achat(new_ValAchat);
                compte.ajouter_argent(gare.getVal_vente());
            }
        }
        for (int k = 0; k<list_compagnie.size(); k++){
            compagnie = list_compagnie.get(k);
            if (compagnie.getEmplacement() == nb_case){
                list_compagnie.remove(k);
                compagnie.setEnable(true);
                compagnie.setProprietaire(0);
                new_ValAchat = (compagnie.getVal_achat() / 2);
                compagnie.setVal_achat(new_ValAchat);
                compte.ajouter_argent(compagnie.getVal_vente());
            }
        }
    }
    public void vendre_maison (Rues rue){

        rue.setNmbr_maison(rue.getNmbr_maison() - 1);
        compte.ajouter_argent(rue.getPrix_maison());

    }


    public void passe_ton_tours (){
    }
    public void event(){
        if (position_joueur == 0) compte.ajouter_argent(200);

        else if (position_joueur == 4) compte.retirer_argent(200);

        else if (position_joueur == 20) passe_ton_tours();

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

