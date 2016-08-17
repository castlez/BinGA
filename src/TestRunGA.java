import java.io.ByteArrayInputStream;

/**
 * Created by Jonny on 8/16/2016.
 */

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class TestRunGA {
    public static void main(String[]args){
        // Set a candidate solution
        System.out.println(args[0].toString());
        int solutionnumber = args.length > 0 ? Integer.parseInt(args[0].toString()) : 42;
        String solnbitstring = Integer.toBinaryString(solutionnumber);
        String leadingZeros = "";
        for (int i = 0; i<(64-solnbitstring.length()); i++) {leadingZeros += "0";}
        FitCalc.setSolution( leadingZeros + solnbitstring);

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
