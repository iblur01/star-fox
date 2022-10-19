package fr.eseo.bachelor.starfox.bank;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Compte_bancaire {

    protected int argent = 1500;
    protected boolean compte_actif = TRUE;

    public Compte_bancaire(int argent) {
        this.argent = argent;
    }


    public void retirer_argent(int dette) {
        argent = argent - dette;
    }
    public void ajouter_argent(int gain) {
        argent = argent + gain;
    }
    public int voir_argent() {
        return argent;
    }
    public void enable(){
        if (compte_actif == TRUE)
            compte_actif = FALSE;

        else if (compte_actif == FALSE)
            compte_actif = TRUE;
    }

    public boolean get_status(){
        return compte_actif;
    }



}
