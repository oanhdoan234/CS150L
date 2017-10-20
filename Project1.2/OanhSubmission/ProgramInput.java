import java.lang.*;
import java.util.*;
import java.io.*;

public class ProgramInput
{
    private BufferedReader fastReader;                  //read line by line
    private FileReader myReader;                        //read file
    private String dir;                                 //directory or name of input file
    
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
    
    public ArrayList<Integer> readInt(int start,  int end){                     //read a certain block of lines and convert into integers
        try{
            ArrayList<Integer> parameters = new ArrayList<Integer>();           //output list
            String line = fastReader.readLine();                                //reader
            int ct = 0;
            while (line != null){
                if (ct >= start && ct < end){                                   //identify the specified block of lines
                    String[] words = line.split(" ");                           //tokenize a line
                    parameters.add(Integer.parseInt(words[1]));                 //convert string into integer
                }
                line = fastReader.readLine();                                   //next line
                ct++;
            }
            return parameters;
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList<Double> readDouble(int start,  int end){                   //read a certain block of lines and convert into doubles
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
    
    public ArrayList<RandomGaussian> readRandomGaussian(int start, long seed){  //read a certain block of lines and generate into random generators
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
