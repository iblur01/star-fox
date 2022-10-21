package fr.eseo.bachelor.starfox.cases;

abstract class Cases {

    protected int emplacement;
    protected String name;


    //Constructeur
    public Cases() {}

    public Cases(int emplacement, String name){
        setEmplacement(emplacement);
        setName(name);
    }
    //

    // getter et setter
    public int getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(int emplacement) {
        this.emplacement = emplacement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //



    public void refresh() {

    }
    
}
