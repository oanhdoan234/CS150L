import java.util.Random;

public class RandomGaussian
{   
    private double mean;
    private double sd; 
    private double var;
    private Random random;
    private long seed;
    
    public RandomGaussian(double mean, double sd, long seed){
        this.mean = mean;
        this.sd = sd;
        this.var = sd*sd;
        this.seed = seed;
        this.random = new Random(seed);
    }
    
    /** test RandomGaussian in main by printing results to console*/
    // public static void main(String[] args){
        // RandomGaussian r = new RandomGaussian(100.0,5.0, 4328472);
        // for (int i = 0; i < 10; i++){
            // System.out.println(r.getGaussian());
        //}
    //}
    public double getGaussian(){                                                    //generate a random number from a normal distribution
        return mean + random.nextGaussian() * var;
    }
    
    public double mean(){return mean;}
    public double sd(){return sd;}
    public long seed(){return seed;}
    
    public boolean compareTo(RandomGaussian r){                                     //compare 2 random generators
        return (this.mean == r.mean && this.sd == r.sd && this.seed == r.seed);
    }
} 
