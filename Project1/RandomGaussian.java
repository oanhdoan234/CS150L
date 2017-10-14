import java.util.Random;

public class RandomGaussian
{   
    private double mean;
    private double sd; 
    private double var;
    private Random random;
    
    public RandomGaussian(double mean, double sd){
        this.mean = mean;
        this.sd = sd;
        this.var = sd*sd;
        this.random = new Random();
    }
    
    public static void main(String[] args){
        RandomGaussian r = new RandomGaussian(100.0,5.0);
        RandomGaussian r2 = new RandomGaussian(100.0,5.0);
        for (int i = 0; i < 10; i++){
            System.out.println(r.getGaussian());
            System.out.println(r2.getGaussian());
        }
    }
    
    public double getGaussian(){
        return mean + random.nextGaussian() * var;
    }
  
} 
