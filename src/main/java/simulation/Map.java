package simulation;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class  is responsible for operations on simulations word(generate resources, generate starting positions of countries, take new fields)
 */
public class Map {

    private int ID;

    /**
     * Constructor to create an Object of an instance
     * @param data information about number of countries, size of map and number of information
     */
    public Map(Data data) {
        ID=0;
        this.data = data;
        field = new Field[data.getMapSize()][data.getMapSize()];
        countries = new ArrayList<>();
        generator = new Random();

        for(int i = 0; i<data.getNumberOfCountries(); i++){
            countries.add(new Country(i));
        }
    }

    Data data;
    Field [][] field;
    ArrayList<Country> countries;
    Random generator;


    /**
     * This method sets unique ID for each of field
     */
    public void settingID(){
        ID=0;
        for(int i = 0; i<data.getMapSize(); i++){
            for(int j = 0; j<data.getMapSize(); j++)
            {
                field[i][j] = new Field(ID);
                ID++;
            }
        }
    }

    /**
     * This method sets amount of gold on each field
     * @param max the maximum amount of gold in the field
     * @param min the minimum amount of gold in the field
     */
    private void generateGold(int max, int min){
        for(int i = 0; i<data.getMapSize(); i++) {
            for (int j = 0; j < data.getMapSize(); j++) {
                field[i][j].gold.setAmount(generator.nextInt(max) + min);

            }
        }
    }


    /**
     * This method sets amount of population on each field
     * @param max the maximum amount of population in the field
     * @param min the minimum amount of population in the field
     */
    private void generatePopulation(int max, int min){
        for(int i = 0; i<data.getMapSize(); i++){
            for(int j = 0; j<data.getMapSize(); j++) {
                field[i][j].population.setAmount(generator.nextInt(max)+min);
            }
        }
    }

    /**
     * This method calls generateGold and generatePopulation method
     * @param max the maximum amount of gold and population in the field
     * @param min the maximum amount of gold and population in the field
     */
    public void generateResources(int max, int min){
        generateGold(max, min);
        generatePopulation(max, min);

    }

    /**
     *  This method calculates the size of the territory
     * @param country the countries on which the operation is performed
     * @return size of territory
     */
    public int countSize(Country country){
        int territorySize=0;
        for(int j=0; j<data.getMapSize(); j++){
            for(int k=0; k<data.getMapSize(); k++){
                if(field[j][k].getOwnerID()==country.getCountryID()){
                    territorySize++;
                }
            }
        }
        return territorySize;
    }

    /**
     * This method generates starting position for each country at the beginning of the simulation
     */
    public void generateStartingPosition(){
        for(int i = 0; i<data.getNumberOfCountries(); i++){
            int xCor=0;
            int yCor=0;
            do{
                xCor = generator.nextInt(data.getMapSize());
                yCor = generator.nextInt(data.getMapSize());
            }while(field[xCor][yCor].getOwnerID()!=-1);

            countries.get(i).getTerritory().add(field[xCor][yCor]);
            countries.get(i).summingCountryGold(data,this);
            countries.get(i).summingCountryPopuation(data,this);
            field[xCor][yCor].setOwnerID(i);
        }
    }

    /**
     * This method allows each of countries take a new filed in each iterations
     * @param countryID unique country's ID
     */
    public void takeNewField(int countryID){

            int x;

            if(!countries.get(countryID).getTerritory().isEmpty()){
                for(int j=0; j<data.getMapSize(); j++){
                    for(int k=0; k<data.getMapSize(); k++){
                        if(field[j][k].getFieldID()==countries.get(countryID).getTerritory().lastElement().getFieldID()){
                            while(true) {
                                try {

                                    x = generator.nextInt(4);

                                    if (x == 0&&field[j - 1][k].getOwnerID()!=countryID) {
                                        if (field[j - 1][k].getOwnerID()!=-1) {
                                            if(countries.get(countryID).attack()>countries.get(field[j - 1][k].getOwnerID()).defend()){
                                                countries.get(field[j - 1][k].getOwnerID()).army.reduceArmy();
                                                countries.get(field[j - 1][k].getOwnerID()).getTerritory().remove(field[j - 1][k]);
                                                countries.get(countryID).getTerritory().add(field[j- 1][k]);
                                                field[j - 1][k].setOwnerID(countryID);
                                            }
                                            else  {
                                                countries.get(countryID).army.reduceArmy();
                                            }
                                        }


                                        else {
                                            field[j - 1][k].setOwnerID(countryID);
                                            countries.get(countryID).getTerritory().add(field[j- 1][k]);
                                        }


                                        return;
                                    }

                                    if (x == 1&&field[j + 1][k].getOwnerID()!=countryID) {
                                        if (field[j + 1][k].getOwnerID()!=-1) {
                                            if(countries.get(countryID).attack()>countries.get(field[j + 1][k].getOwnerID()).defend()){
                                                countries.get(field[j + 1][k].getOwnerID()).army.reduceArmy();
                                                countries.get(field[j + 1][k].getOwnerID()).getTerritory().remove(field[j + 1][k]);
                                                countries.get(countryID).getTerritory().add(field[j + 1][k]);
                                                field[j + 1][k].setOwnerID(countryID);

                                            }
                                            else {
                                                field[j + 1][k].setOwnerID(field[j + 1][k].getOwnerID());
                                                countries.get(countryID).army.reduceArmy();
                                            }
                                        }
                                        else {
                                            field[j + 1][k].setOwnerID(countryID);
                                            countries.get(countryID).getTerritory().add(field[j + 1][k]);
                                        }

                                        return;
                                    }

                                    if (x == 2&&field[j][k-1].getOwnerID()!=countryID) {
                                        if (field[j][k - 1].getOwnerID()!=-1) {
                                            if(countries.get(countryID).attack()>countries.get(field[j][k - 1].getOwnerID()).defend()){
                                                countries.get(field[j][k - 1].getOwnerID()).army.reduceArmy();
                                                countries.get(field[j][k-1].getOwnerID()).getTerritory().remove(field[j][k-1]);
                                                countries.get(countryID).getTerritory().add(field[j][k - 1]);
                                                field[j][k - 1].setOwnerID(countryID);
                                            }
                                            else {
                                                countries.get(countryID).army.reduceArmy();
                                            }
                                        }
                                        else {
                                            field[j][k - 1].setOwnerID(countryID);
                                            countries.get(countryID).getTerritory().add(field[j][k - 1]);
                                        }

                                        return;
                                    }

                                    if (x == 3&&field[j][k+1].getOwnerID()!=countryID) {
                                        if (field[j][k+1].getOwnerID()!=-1) {
                                            if(countries.get(countryID).attack()>countries.get(field[j][k+1].getOwnerID()).defend()){
                                                countries.get(field[j][k+1].getOwnerID()).army.reduceArmy();
                                                countries.get(field[j][k+1].getOwnerID()).getTerritory().remove(field[j][k+1]);
                                                countries.get(countryID).getTerritory().add(field[j][k+1]);
                                                field[j][k+1].setOwnerID(countryID);
                                            }
                                            else {
                                                countries.get(countryID).army.reduceArmy();
                                            }
                                        }
                                        else {
                                            field[j][k+1].setOwnerID(countryID);
                                            countries.get(countryID).getTerritory().add(field[j][k+1]);
                                        }

                                        return;
                                    }

                                    return;

                                } catch (ArrayIndexOutOfBoundsException e) { }
                            }
                        }
                    }
                }

            }
             for(int j=0; j<data.getMapSize(); j++){
                   for(int k=0; k<data.getMapSize(); k++){
                       if(field[j][k].getOwnerID()==countryID){
                           countries.get(countryID).getTerritory().add(field[j][k]);
                       }
                   }
             }
    }

}