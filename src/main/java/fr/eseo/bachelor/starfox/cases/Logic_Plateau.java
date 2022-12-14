package fr.eseo.bachelor.starfox.cases;

import java.util.ArrayList;

public class Logic_Plateau {


    ArrayList<Compagnies> list_compagnies = new ArrayList<>();
    ArrayList<Gares> list_gares = new ArrayList<>();
    ArrayList<Rues> list_rues = new ArrayList<>();

    public void init_cases(){
        init_compagnies();
        init_rues();
        init_gares();
    }
    public ArrayList<Rues> getRues () {
        return list_rues;
    }
    public ArrayList<Gares> getGares () {
        return list_gares;
    }
    public ArrayList<Compagnies> getCompagnies () {
        return list_compagnies;
    }

    public void init_rues(){

        Rues rue1 = new Rues(1,"O'Tacos",60,30, 1);
        Rues rue2 = new Rues(3,"McDo",60,30, 1);

        Rues rue3 = new Rues(6,"Point Chicken",100,350, 2);
        Rues rue4 = new Rues(8,"Food 49",100,50, 2);
        Rues rue5 = new Rues(9,"Mc Donner",120,60, 2);

        Rues rue6 = new Rues(11,"La Chapelle",140,70, 3);
        Rues rue7 = new Rues(13,"Le Carré",140,70, 3);
        Rues rue8 = new Rues(14,"Le Mid Star",160,80, 3);

        Rues rue9 = new Rues(16,"Le Prime",180,90, 4);
        Rues rue10 = new Rues(18,"So Sushi",180,90, 4);
        Rues rue11 = new Rues(19,"Fresh Burritos",200,100, 4);

        Rues rue12 = new Rues(21,"L'Atoll",220,110, 5);
        Rues rue13 = new Rues(23,"L'esapce Anjou",220,110, 5);
        Rues rue14 = new Rues(24,"Grand Maine",240,120, 5);

        Rues rue15 = new Rues(26,"Lac de Maine",260,130, 6);
        Rues rue16 = new Rues(27,"Aqua Vita",260,130, 6);
        Rues rue17 = new Rues(29,"Les sablières",280,140, 6);

        Rues rue18 = new Rues(31,"Le jardin des Plantes",300,150, 7);
        Rues rue19 = new Rues(32,"Le jardin du Mail",300,150, 7);
        Rues rue20 = new Rues(34,"Terra Botanica",320,160, 7);

        Rues rue21 = new Rues(37,"Le Chateau d'Angers",350,175, 8);
        Rues rue22 = new Rues(39,"ESEO",400,200, 8);
        list_rues.add(rue1);
        list_rues.add(rue2);
        list_rues.add(rue3);
        list_rues.add(rue4);
        list_rues.add(rue5);
        list_rues.add(rue6);
        list_rues.add(rue7);
        list_rues.add(rue8);
        list_rues.add(rue9);
        list_rues.add(rue10);
        list_rues.add(rue11);
        list_rues.add(rue12);
        list_rues.add(rue13);
        list_rues.add(rue14);
        list_rues.add(rue15);
        list_rues.add(rue16);
        list_rues.add(rue17);
        list_rues.add(rue18);
        list_rues.add(rue19);
        list_rues.add(rue20);
        list_rues.add(rue21);
        list_rues.add(rue22);



    }
    public void init_gares(){

        Gares gare1 = new Gares(5,"Bar du Tonton Foch",200,100);
        Gares gare2 = new Gares(15,"Bar du Maestro",200,100);
        Gares gare3 = new Gares(25,"Bar du James Joyces",200,100);
        Gares gare4 = new Gares(35,"Bar du Delirium",200,100);
        list_gares.add(gare1);
        list_gares.add(gare2);
        list_gares.add(gare3);
        list_gares.add(gare4);


    }
    public void init_compagnies(){
        Compagnies compagnie1 = new Compagnies(12, "La 7ème Compagnie",150,75);
        Compagnies compagnie2 = new Compagnies(28, "La Compagnie Créole",150,75);
        list_compagnies.add(compagnie1);
        list_compagnies.add(compagnie2);
    }
}
