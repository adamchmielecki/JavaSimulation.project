package simulation;


public class Main {

    public static void main(String[] args) {

        Simulation simulation = new Simulation();
        simulation.loadData();


        for(int i=0; i<100; i++ ){
            simulation.startSimulation();
        }






    }

}
