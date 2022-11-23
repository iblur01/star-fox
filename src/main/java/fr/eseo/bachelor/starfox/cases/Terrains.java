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
        setPrix_maison();
        setMaison(0);
        setEnableTerrain(false);
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

        else if (emplacement == 6 || emplacement == 8){
            loyer.add(6);
            loyer.add(30);
            loyer.add(90);
            loyer.add(270);
            loyer.add(400);
            loyer.add(550);
        }

        else if (emplacement == 9){
            loyer.add(8);
            loyer.add(40);
            loyer.add(100);
            loyer.add(300);
            loyer.add(450);
            loyer.add(600);
        }

        else if (emplacement == 11 || emplacement == 13){
            loyer.add(10);
            loyer.add(50);
            loyer.add(150);
            loyer.add(450);
            loyer.add(625);
            loyer.add(750);
        }

        else if (emplacement == 14){
            loyer.add(12);
            loyer.add(60);
            loyer.add(180);
            loyer.add(500);
            loyer.add(700);
            loyer.add(900);
        }

        else if (emplacement == 16 || emplacement == 18){
            loyer.add(14);
            loyer.add(70);
            loyer.add(200);
            loyer.add(550);
            loyer.add(700);
            loyer.add(900);
        }

        else if (emplacement == 19){
            loyer.add(16);
            loyer.add(80);
            loyer.add(220);
            loyer.add(600);
            loyer.add(800);
            loyer.add(1000);
        }

        else if (emplacement == 21 || emplacement == 23){
            loyer.add(18);
            loyer.add(90);
            loyer.add(250);
            loyer.add(700);
            loyer.add(875);
            loyer.add(1050);
        }

        else if (emplacement == 24){
            loyer.add(20);
            loyer.add(100);
            loyer.add(300);
            loyer.add(750);
            loyer.add(925);
            loyer.add(1100);
        }

        else if (emplacement == 26 || emplacement == 27){
            loyer.add(22);
            loyer.add(110);
            loyer.add(330);
            loyer.add(800);
            loyer.add(975);
            loyer.add(1150);
        }

        else if (emplacement == 44){

        }
    }
    public void setEnableTerrain(boolean enable) {
        this.enable_terrain = enable;
    }
    public void setMaison(int maison){
        if (maison >= 0 & maison <= 5 ) this.nmbr_maison = maison;
    }
    public void setPrix_maison (){

        emplacement = getEmplacement();

        if (emplacement == 1 || emplacement == 3 || emplacement == 6 || emplacement == 8 || emplacement == 9){
            this.prix_maison = 50;
        }

        else if (emplacement == 11 || emplacement == 13 || emplacement == 14 || emplacement == 16 || emplacement == 18 || emplacement == 19){
            this.prix_maison = 100;
        }

        else if (emplacement == 21 || emplacement == 23 || emplacement == 24 || emplacement == 26 || emplacement == 27 || emplacement == 29){
            this.prix_maison = 150;
        }

        else if (emplacement == 31 || emplacement == 32 || emplacement == 34 || emplacement == 37 || emplacement == 39){
            this.prix_maison = 200;
        }

    }


    //test
}
