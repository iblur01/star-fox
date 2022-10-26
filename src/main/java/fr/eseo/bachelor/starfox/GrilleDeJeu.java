package fr.eseo.bachelor.starfox;

import java.util.ArrayList;

public class GrilleDeJeu {
    private final ArrayList emplacement_j = new ArrayList();

    public void generation_grille(){
        for (Integer i = 0; i < 40; i++ ) {
            emplacement_j.add(i,0);
        }
    }

    public void setEmplacement_j(int emplacement, int J) {
        emplacement_j.set(emplacement, J);
    }

    public Object getCase(int emplacment){
        return emplacement_j.get(emplacment);
    }
}
