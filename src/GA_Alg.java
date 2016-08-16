/**
 * Created by Jonny on 8/15/2016.
 * A library of Genetic Algorithms
 */
public class GA_Alg {

    /* GA parameters */
    private static final double uniformRate = 0.5;
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    // Evolve a population
    public static GA_Pop evolvePopulation(GA_Pop pop) {
        GA_Pop newpop = new GA_Pop(pop.size(), false);

        //keep best dude if your an elitist
        if (elitism) {
            newpop.saveIndividual(0,pop.getFittest());
        }

        //if you're elitist, start at index 1
        int eoff = elitism ? 1 : 0;

        //populate new pop with superior individuals
        for (int i = eoff; i<pop.size(); i++) {
            GA_Indv ind1 = tournamentSelection(pop);
            GA_Indv ind2 = tournamentSelection(pop);
            GA_Indv baby = crossover(ind1, ind2);
            newpop.saveIndividual(i, baby);
        }

        //add some random individuals
        for (int i = eoff; i<newpop.size(); i++) {
            mutate(newpop.getIndividual(i));
        }

        return newpop;
    }

    // Crossover individuals (reproduce)
    private static GA_Indv crossover(GA_Indv indiv1, GA_Indv indiv2) {
        GA_Indv baby = new GA_Indv();
        for (int i = 0; i<indiv1.size(); i++) {
            if (Math.random() <= uniformRate) {
                baby.setGene(i, indiv1.getGene(i));
            }
            else{
                baby.setGene(i,indiv2.getGene(i));
            }
        }
        return baby;
    }

    // Mutate an individual
    private static void mutate(GA_Indv indiv) {
        for (int i = 0; i<indiv.size();i++) {
            if (Math.random() <= mutationRate) {
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
            }
        }
    }

    // Select individuals for crossover
    private static GA_Indv tournamentSelection(GA_Pop pop) {
        // Create a tournament population
        GA_Pop tpop = new GA_Pop(tournamentSize, false);

        // For each place in the tournament get a random individual
        for (int i = 0; i<tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tpop.saveIndividual(i, pop.getIndividual(randomId));
        }

        // Get the fittest
        GA_Indv fittest = tpop.getFittest();
        return fittest;
    }
}
