package fr.eseo.bachelor.starfox.cases;

import java.util.ArrayList;

abstract public class Terrains extends Cases{

    protected int proprietaire;
    protected int val_achat;
    protected int val_vente;
    protected boolean enable_terrain = true;

    private ArrayList<Integer> loyer = new ArrayList<>();
    private int nmbr_maison;

    private int prix_maison;



    //Constructeur
    public Terrains(){}

    public Terrains(int emplacement, String name){
        super(emplacement, name);
        setProprietaire(0);
        setLoyer(emplacement);
        setPrix_maison(emplacement);
        setMaison(0);
    }
    //


    //Getteur
    public int getProprietaire() {
        return proprietaire;
    }

    public int getVal_vente (){
        return val_vente;
    }
    public boolean getEnableTerrain(){
        return enable_terrain;
    }
    public int getNmbr_maison(){
        return nmbr_maison;
    }
    public int getPrix_maison (){
        return prix_maison;
    }
    public int getLoyer() {
        return loyer.get(nmbr_maison);
    }




    //Setteur
    public void setProprietaire(int proprietaire) {
        this.proprietaire = proprietaire;
    }
    public void setLoyer(int emplacement) {

        if (emplacement == 1){
            loyer.add(2);
            loyer.add(10);
            loyer.add(30);
            loyer.add(90);
            loyer.add(160);
            loyer.add(250);
        }

        else if (emplacement == 3){
            loyer.add(4);
            loyer.add(20);
            loyer.add(60);
            loyer.add(180);
            loyer.add(320);
            loyer.add(450);
        }

        else if (emplacement == 6){

        }

        else if (emplacement == 8){

        }

        else if (emplacement == 9){

        }
    }
    public void setEnableTerrain(boolean enable) {
        this.enable_terrain = enable;
    }
    public void setMaison(int maison){
        if (maison >= 0 & maison <= 5 ) this.nmbr_maison = maison;
    }
    public void setPrix_maison (int emplacement){

        if (emplacement == 1 | emplacement == 3){
            this.prix_maison = 50;
        }

        else if (emplacement == 6 | emplacement == 8 | emplacement == 9){
            this.prix_maison = 100;
        }
    }


    //test
}
