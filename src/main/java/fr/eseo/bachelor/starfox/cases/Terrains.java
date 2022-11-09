package fr.eseo.bachelor.starfox.cases;

abstract public class Terrains extends Cases{

    protected int proprietaire;
    protected int val_achat;
    protected int val_vente;
    //protected boolean enable_terrain = true;


    //Constructeur
    public Terrains(){}
    public Terrains(int emplacement, String name){
        super(emplacement, name);
        setProprietaire(0);
    }
    //


    public void setProprietaire(int proprietaire) {
        this.proprietaire = proprietaire;
    }

    public int getProprietaire() {
        return proprietaire;
    }

    public int getVal_vente (){
        return val_vente;
    }

    /*public void setEnableTerrain(boolean enable) {
        this.enable_terrain = enable;
    }

    public boolean getEnableTerrain(){
        return enable_terrain;
    }*/
}
