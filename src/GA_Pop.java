/**
 * Created by Jonny on 8/15/2016.
 * A Genetic Algorithm Population of Individuals
 */
public class GA_Pop {
    GA_Indv[] indivs;

    public GA_Pop(int popSize, boolean init) {
        indivs = new GA_Indv[popSize];

        if (init) {
            // Loop and create individuals
            for (int i = 0; i < size(); i++) {
                GA_Indv newIndividual = new GA_Indv();
                newIndividual.generateIndividual();
                saveIndividual(i, newIndividual);
            }
        }
    }

    /* Public methods */

    public int size() {
        return indivs.length;
    }

    public void saveIndividual(int index, GA_Indv indiv) {
        indivs[index] = indiv;
    }

    /* Getters */

    public GA_Indv getIndividual(int index) {
        return indivs[index];
    }

    public GA_Indv getFittest() {
        GA_Indv fittest = indivs[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

}
