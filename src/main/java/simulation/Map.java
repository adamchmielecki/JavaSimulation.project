package simulation;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class  is responsible for operations on simulations word(generate resources, generate starting positions of countries, take new fields)
 */
public class Map {

    private int ID=0;

    /**
     * Constructor to create an Object of an instance
     */
    public Map(Data data) {
        this.data = data;
        field = new Field[data.getMapSize()][data.getMapSize()];
        countries = new ArrayList<>();
        generator = new Random();

        for(int i = 0; i<data.getNumberOfCountries(); i++){
            countries.add(new Country(i));//,new Army()));
        }
    }

    Data data;
    Field [][] field;
    ArrayList<Country> countries;
    //Army army;
    Random generator;


    /**
     * This method sets unique ID for each of field
     */
    public void settingID(){
        for(int i = 0; i<data.getMapSize(); i++){
            for(int j = 0; j<data.getMapSize(); j++)
            {
                field[i][j] = new Field();
                field[i][j].setFieldID(ID);
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
    public void printMap(){
        for(int i = 0; i<data.getMapSize(); i++){
            for(int j = 0; j<data.getMapSize(); j++) {
                field[i][j].setFieldID(ID);
                ID++;
                System.out.print(field[i][j].getOwnerID()+" ");
            }System.out.println();
        }
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
            countries.get(i).summingCountryGold();
            countries.get(i).summingCountryPopuation();
            field[xCor][yCor].setOwnerID(i);
        }
    }

    /**
     * This method allows each of countries take a new filed in each iterations
     */
    public void takeNewField(){
        int [][] ownerTable = new int[data.getMapSize()][data.getMapSize()];

        for(int j=0; j<data.getMapSize(); j++) {
            for (int k = 0; k < data.getMapSize(); k++) {
                ownerTable[j][k]=field[j][k].getOwnerID();
            }
        }

        for(int i = 0; i<data.getNumberOfCountries(); i++){
            int x;

            if(!countries.get(i).getTerritory().empty()){
                for(int j=0; j<data.getMapSize(); j++){
                    for(int k=0; k<data.getMapSize(); k++){
                        if(field[j][k].getFieldID()==countries.get(i).getTerritory().lastElement().getFieldID()){
                            while(true) {
                                try {

                                    x = generator.nextInt(4);

                                    // System.out.println("ID " + i + "X" + x);
                                    if (x == 0&&field[j - 1][k].getOwnerID()!=i) {
                                        if (field[j - 1][k].getOwnerID()!=-1) {
                                            if(countries.get(i).attack()>countries.get(field[j - 1][k].getOwnerID()).defend()){
                                                //army.superMethods(countries.get(i),countries.get(field[j - 1][k].getOwnerID()),field[j - 1][k]);
                                                countries.get(field[j - 1][k].getOwnerID()).army.reduceArmy();
                                                countries.get(field[j - 1][k].getOwnerID()).getTerritory().pop();
                                                field[j - 1][k].setOwnerID(i);

                                            }
                                            else  field[j - 1][k].setOwnerID(field[j - 1][k].getOwnerID());
                                        }


                                        else field[j - 1][k].setOwnerID(i);


                                        break;
                                    }

                                    if (x == 1&&field[j + 1][k].getOwnerID()!=i) {
                                        if (field[j + 1][k].getOwnerID()!=-1) {
                                            if(countries.get(i).attack()>countries.get(field[j + 1][k].getOwnerID()).defend()){
                                                //army.superMethods(countries.get(i),countries.get(field[j + 1][k].getOwnerID()),field[j + 1][k]);
                                                countries.get(field[j + 1][k].getOwnerID()).army.reduceArmy();
                                                countries.get(field[j + 1][k].getOwnerID()).getTerritory().pop();
                                                field[j + 1][k].setOwnerID(i);

                                            }
                                            else  field[j + 1][k].setOwnerID(field[j - 1][k].getOwnerID());
                                        }
                                        else  field[j + 1][k].setOwnerID(i);

                                        //countries.get(i).getTerritory().add(field[j+1][k]);
                                        break;
                                    }

                                    if (x == 2&&field[j][k-1].getOwnerID()!=i) {
                                        if (field[j][k-1].getOwnerID()!=-1) {
                                            if(countries.get(i).attack()>countries.get(field[j][k-1].getOwnerID()).defend()){
                                                //army.superMethods(countries.get(i),countries.get(field[j][k - 1].getOwnerID()),field[j][k - 1]);
                                                countries.get(field[j][k - 1].getOwnerID()).army.reduceArmy();
                                                countries.get(field[j][k - 1].getOwnerID()).getTerritory().pop();
                                                field[j][k-1].setOwnerID(i);

                                            }
                                            else  field[j ][k- 1].setOwnerID(field[j - 1][k].getOwnerID());
                                        }
                                        else field[j][k - 1].setOwnerID(i);

                                        break;
                                    }

                                    if (x == 3&&field[j][k+1].getOwnerID()!=i) {
                                        if (field[j][k+1].getOwnerID()!=-1) {
                                            if(countries.get(i).attack()>countries.get(field[j][k+1].getOwnerID()).defend()){
                                                //army.superMethods(countries.get(i),countries.get(field[j][k + 1].getOwnerID()),field[j][k + 1]);
                                                countries.get(field[j][k+1].getOwnerID()).army.reduceArmy();
                                                countries.get(field[j][k+1].getOwnerID()).getTerritory().pop();
                                                field[j][k+1].setOwnerID(i);

                                            }
                                            else  field[j][k - 1].setOwnerID(field[j - 1][k].getOwnerID());
                                        }
                                        else  field[j][k+1].setOwnerID(i);


                                        break;
                                    }
                                    break;
                                } catch (ArrayIndexOutOfBoundsException e) {

                                }
                            }
                        }
                    }

                }
                for(int j=0; j<data.getMapSize(); j++){
                    for(int k=0; k<data.getMapSize(); k++){
                        if(field[j][k].getOwnerID()==i) {
                            countries.get(i).getTerritory().add(field[j][k]);
                        }
                    }
                }
            }

        }
    }
}