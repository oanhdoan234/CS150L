import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;
public class CheapestProduct
{
    public static void main(String[] args){
        CheapestProduct prod = new CheapestProduct();
        prod.findCheapest("input.txt", "output.txt"); 
    }
    
    public void findCheapest(String input, String output){
        try{
           Scanner infile = new Scanner(new FileReader(input));
           PrintWriter outfile = new PrintWriter(output);
           
            while(infile.hasNextLine()){
                Scanner aLine = new Scanner(infile.nextLine()).useDelimiter(",");
                String prodType = aLine.next(); 
                String cheapestProd = null; 
                float cheapestPrice = 0; 
                
                while (aLine.hasNext()){
                    String currentProd = aLine.next();
                    float currentPrice = aLine.nextFloat();
                    if (cheapestProd == null){
                        cheapestProd = currentProd; 
                        cheapestPrice = currentPrice;
                    }
                    else if (currentPrice <= cheapestPrice){
                        cheapestPrice = currentPrice;
                        cheapestProd  = currentProd;
                    }
                }
                
                outfile.write("The cheapest " + prodType + " is " + cheapestProd + "\n");
                System.out.println("The cheapest " + prodType + " is " + cheapestProd);
           }
           outfile.close();
           
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
