package fr.eseo.bachelor.starfox.cases;

abstract class Terrains extends Cases{

    protected int proprietaire;
    protected int val_achat;
    protected int val_vente;


    //Constructeur
    public Terrains(){}
    public Terrains(int emplacement, String name){
        super(emplacement, name);
    }
    //
}
