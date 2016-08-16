/**
 * Created by Jonny on 8/16/2016.
 */
public class TestRunGA {
    public static void main(String[]args){
        // Set a candidate solution
        FitCalc.setSolution("1111000000100000000000100000000000000100000000100000100000001111");

        // Create an initial population
        GA_Pop myPop = new GA_Pop(50, true);

        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
        while (myPop.getFittest().getFitness() < FitCalc.getMaxFitness()) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
            myPop = GA_Alg.evolvePopulation(myPop);
        }
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        System.out.println(myPop.getFittest());
    }
}
