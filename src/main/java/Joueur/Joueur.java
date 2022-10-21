package Joueur;

import fr.eseo.bachelor.starfox.cases.Compagnies;
import fr.eseo.bachelor.starfox.cases.Gares;
import fr.eseo.bachelor.starfox.cases.Rues;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Joueur {

    private String name_j;
    private int color;
    private int position;

    private Label label;
    private int num;

    private ArrayList<Rues> list_rues_j;
    private ArrayList<Gares> gares;
    private ArrayList<Compagnies> compagnies;


    public Joueur (){

    }

    public Joueur(String name_j, int color, int num){
        setParam(name_j, color, num);

        if (num > 4){
            num = 0;
            color = 0;
            setName("ERROR");
        }
    }



    /*public String getName() {
        return name_j;
    }
    public int getColor() {
        return color;
    }*/
    public int getPosition() {
        return position;
    }
    public int getNum(){
        return num;
    }
    public Label getLabel() {
        return label;
    }

    public void setName(String name_j) {
        this.name_j = name_j;
        label = new Label();
        label.setText(name_j);
    }
    public void setColor(int color) {
        this.color = color;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public void setNum(int num){
        this.num = num;
    }
    public void setParam(String name_j, int color, int num){
        setName(name_j);
        setColor(color);
        setPosition(0);
        setNum(num);
    }



    public void acheter (Rues rue){
        list_rues_j = new ArrayList<>();
        list_rues_j.add(rue);
    }
}
