package simulation;

import java.util.Random;

public class Field {


    Gold gold;
    Population population;
    private int ownerID;
    private int fieldID;
    Random generator;




    public Field() {
        generator = new Random();
        gold = new Gold(generator.nextInt(200));
        population = new Population(generator.nextInt(200));

        this.ownerID = -1;

    }

    public int getFieldID() {
        return fieldID;
    }

    public void setFieldID(int fieldID) {
        this.fieldID = fieldID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }




}
