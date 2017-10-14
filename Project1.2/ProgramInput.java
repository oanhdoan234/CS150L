import java.lang.*;
import java.util.*;
import java.io.*;

public class ProgramInput
{
    private BufferedReader fastReader;
    private FileReader myReader;
    private String dir;
    
    public ProgramInput(String dir){
        try{
            this.dir = dir;
            this.myReader = new FileReader(dir);
            this.fastReader = new BufferedReader(myReader);
        }catch(FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public ArrayList<Integer> readInt(int start,  int end){
        try{
            ArrayList<Integer> parameters = new ArrayList<Integer>();
            String line = fastReader.readLine(); 
            int ct = 0;
            while (line != null){
                if (ct >= start && ct < end){
                    String[] words = line.split(" ");
                    parameters.add(Integer.parseInt(words[1]));
                }
                line = fastReader.readLine(); 
                ct++;
            }
            return parameters;
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<Double> readDouble(int start,  int end){
        try{
            ArrayList<Double> parameters = new ArrayList<Double>();
            String line = fastReader.readLine(); 
            int ct = 0;
            while (line != null){
                if (ct >= start && ct < end){
                    String[] words = line.split(" ");
                    parameters.add(Double.parseDouble(words[1]));
                }
                line = fastReader.readLine(); 
                ct++;
            }
            return parameters;
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<RandomGaussian> readRandomGaussian(int start, long seed){
        try{
            ArrayList<RandomGaussian> parameters = new ArrayList<RandomGaussian>();
            String line = fastReader.readLine(); 
            int ct = 0;
            while (line != null){
                if (ct >= start){
                    String[] words = line.split(" ");
                    double mean = Double.parseDouble(words[1]);
                    double sd = Double.parseDouble(words[2]);
                    parameters.add(new RandomGaussian(mean,sd,seed));
                }
                line = fastReader.readLine(); 
                ct++;
            }
            return parameters;
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
