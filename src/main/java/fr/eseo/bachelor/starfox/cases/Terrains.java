package fr.eseo.bachelor.starfox.cases;

abstract public class Terrains extends Cases{

    protected int proprietaire;
    protected int val_achat;
    protected int val_vente;
    protected boolean enable = true;


    //Constructeur
    public Terrains(){}
    public Terrains(int emplacement, String name){
        super(emplacement, name);
    }
    //


    public void setProprietaire(int proprietaire) {
        this.proprietaire = proprietaire;
    }

    public int getProprietaire() {
        return proprietaire;
    }

    public boolean getEnable(){
        return enable;
    }
}
