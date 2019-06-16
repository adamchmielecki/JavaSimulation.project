package simulation;

/**
 * This interface defines methods for units(soldier, tank, jet)
 */
public interface IUnit {

    /**
     * This method creates new units
     * @param country the country for which the units are created
     */
    void createNewUnit(Country country);
    int getCount();
    void setCount(int count);
}
