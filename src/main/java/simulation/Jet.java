package simulation;

public class Jet extends Unit {

    public Jet(int numberOfUnits){
        super(numberOfUnits);
        strenghtOfAttack = 15;
        strenghtOfDefence = 15;
        staff = 10;
        cost = 50;
    }

    /*public void superJetSkill(Country offensiveCountry, Country defensiveCountry, Field field){
        bonus=bonusGenerator.nextInt(100);
        if(offensiveCountry.army.jets.size()<=defensiveCountry.army.jets.size()) {
            if (bonus >= 85) {
                field.setOwnerID(defensiveCountry.getCountryID());
            }
        }
    }*/
}
