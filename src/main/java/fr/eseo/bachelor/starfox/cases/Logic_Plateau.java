package fr.eseo.bachelor.starfox.cases;

public class Logic_Plateau {

    public void init_cases(){
        init_compagnies();
        init_rues();
        init_gares();
    }

    public void init_rues(){

        Rues rue1 = new Rues(1,"O'Tacos",60,30);
        Rues rue2 = new Rues(3,"McDo",60,30);
        Rues rue3 = new Rues(6,"Point Chicken",100,350);
        Rues rue4 = new Rues(8,"Food 49",100,50);
        Rues rue5 = new Rues(9,"Mc Donner",120,60);
        Rues rue6 = new Rues(11,"La Chapelle",140,70);
        Rues rue7 = new Rues(13,"Le Carré",140,70);
        Rues rue8 = new Rues(14,"Le Mid Star",160,80);
        Rues rue9 = new Rues(16,"Le Prime",180,90);
        Rues rue10 = new Rues(18,"So Sushi",180,90);
        Rues rue11 = new Rues(19,"Fresh Burritos",200,100);
        Rues rue12 = new Rues(21,"L'Atoll",220,110);
        Rues rue13 = new Rues(23,"L'esapce Anjou",220,110);
        Rues rue14 = new Rues(24,"Grand Maine",240,120);
        Rues rue15 = new Rues(26,"Lac de Maine",260,130);
        Rues rue16 = new Rues(27,"Aqua Vita",260,130);
        Rues rue17 = new Rues(29,"Les sablières",280,140);
        Rues rue18 = new Rues(31,"Le jardin des Plantes",300,150);
        Rues rue19 = new Rues(32,"Le jardin du Mail",300,150);
        Rues rue20 = new Rues(34,"Terra Botanica",320,160);
        Rues rue21 = new Rues(37,"Le Chateau d'Angers",350,175);
        Rues rue22 = new Rues(39,"ESEO",400,200);

    }
    public void init_gares(){

        Gares gare1 = new Gares(5,"Bar du Tonton Foch",200,100);
        Gares gare2 = new Gares(15,"Bar du Maestro",200,100);
        Gares gare3 = new Gares(25,"Bar du James Joyces",200,100);
        Gares gare4 = new Gares(35,"Bar du Delirium",200,100);
    }
    public void init_compagnies(){
        Compagnies compagnie1 = new Compagnies(12, "La 7ème Compagnie",150,75);
        Compagnies compagnie2 = new Compagnies(28, "La Compagnie Créole",150,75);
    }
}
