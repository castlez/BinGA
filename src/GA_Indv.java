/**
 * Created by Jonny on 8/15/2016.
 * A Genetic Algorithm Individual
 */
public class GA_Indv {
    static int defaultGeneLength = 64;
    private byte[] genes = new byte[defaultGeneLength];
    // Cache
    private int fitness = 0;

    public void generateIndividual() {
        for (int i = 0; i<size(); i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }
    }

    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths
    public static void setDefaultGeneLength(int length) {defaultGeneLength = length;}
    public byte getGene(int index) {return genes[index];}
    public void setGene(int index, byte value) {genes[index] = value; fitness = 0;}

    /* Public methods */
    public int size() {return genes.length;}
    public int getFitness() {
        if (fitness == 0) {
            fitness = FitCalc.getFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        String geneout = "";
        for (int i = 0; i< size(); i++) {
            geneout += getGene(i);
        }
        return geneout;
    }

}
