package simulation;

public class Jet extends Unit {

    public Jet(){
        super(0);
        strenghtOfAttack = 15;
        strenghtOfDefence = 15;
        staff = 10;
        cost = 50;
    }

   /* public void createNewJet(Country country){
        setCount(getCount() + 1);
        country.setTotalGold(country.getTotalGold() - cost);
        country.setTotalPopulation(country.getTotalPopulation() - staff);
    }*/
    public void superJetSkill(Country country1, Country country2, Field field){
        bonus=bonusGenerator.nextInt(100);
        if(country1.army.jet.getCount()>=country2.army.jet.getCount()) {
            if (bonus >= 85) {
                field.setOwnerID(country1.getCountryID());
            }
        }
    }
}
