package simulation;

import java.util.Random;

/**
 * class responsible for set value of gold and population
 */
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

    /**
     *
     * @return returns field id
     */
    public int getFieldID() {
        return fieldID;
    }

    /**
     *
     * @param fieldID set field id
     */
    public void setFieldID(int fieldID) {
        this.fieldID = fieldID;
    }

    /**
     *
     * @return returns the field owner's id
     */
    public int getOwnerID() {
        return ownerID;
    }

    /**
     *
     * @param ownerID ownerID
     */
    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }




}
