package fr.eseo.bachelor.starfox.cases;

import java.util.ArrayList;

public class Rues extends Terrains {

    private ArrayList<Integer> loyer = new ArrayList<>();
    private int maison;

    public Rues() {
    }

    public Rues(int emplacement, String name) {
        super(emplacement, name);
        setLoyer(emplacement);
        setMaison(0);
    }

    public void setLoyer(int emplacement) {
        //this.loyer = loyer;
        if (emplacement == 1){
            loyer.add(10);
            loyer.add(30);
            loyer.add(90);
        }

        if (emplacement == 2){
            loyer.add(20);
            loyer.add(40);
            loyer.add(100);
        }
    }

    public int getLoyer() {
        return loyer.get(maison);
    }

    public void setMaison(int maison){
        if (maison >= 0 & maison <= 5 ) this.maison = maison;
    }

    public int getMaison(){
        return maison;
    }

    //test

}
