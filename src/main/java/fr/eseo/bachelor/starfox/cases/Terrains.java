package fr.eseo.bachelor.starfox.cases;

import java.util.ArrayList;

abstract public class Terrains extends Cases{


    protected int val_achat;
    protected int val_vente;
    protected boolean enable_terrain;




    //Constructeur
    public Terrains(){}

    public Terrains(int emplacement, String name, int val_vente, int val_achat){
        super(emplacement, name);
        setEnableTerrain(true);
        setVal_achat(val_achat);
        setVal_vente(val_vente);
    }
    //


    //Getteur
    public int getVal_achat(){ return val_achat; }
    public int getVal_vente (){
        return val_vente;
    }
    public boolean getEnableTerrain(){
        return enable_terrain;
    }
    //



    //Setteur
    public void setEnableTerrain(boolean enable) {
        this.enable_terrain = enable;
    }
    public void setVal_achat(int val_achat) { this.val_achat = val_achat; }
    public void setVal_vente(int val_vente) { this.val_vente = val_vente; }

}
