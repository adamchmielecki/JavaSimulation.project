package simulation;

import java.util.Random;

/**
 * This class is responsible for set value of gold and population on field, and sets the fields owner
 */
public class Field {


    Gold gold;
    Population population;
    private int ownerID;
    private int fieldID;
    Random generator;


    /**
     * Constructor to create an Object of an instance and set value of gold and population on field
     * @param id field's unique ID
     */
    public Field(int id) {
        generator = new Random();
        gold = new Gold(generator.nextInt(200));
        population = new Population(generator.nextInt(200));
        this.fieldID=id;
        this.ownerID = -1;

    }

    /**
     * Allows access the variable of the field ID
     * @return returns the field ID
     */
    public int getFieldID() {
        return fieldID;
    }

    /**
     * Allows set the field ID
     * @param fieldID unique ID of each field
     */
    public void setFieldID(int fieldID) {
        this.fieldID = fieldID;
    }

    /**
     * Allows access the variable of the owner ID od field
     * @return returns the field owner's ID
     */
    public int getOwnerID() {
        return ownerID;
    }

    /**
     * Allows set the field owner's ID
     * @param ownerID ID of field owner
     */
    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }




}
