import java.util.Scanner;

public class Calculator {
     private String readMethodChoice; 
     private String readNum1; 
     private String readNum2;
     private int methodChoice; 
     private float num1; 
     private float num2;
     private float result;
     private Scanner reader = new Scanner(System.in);; 
     private boolean quit = false; 
     
     public Calculator(){
        }
     public static void main(String[] args) {
         Calculator calc = new Calculator();
         calc.run();
     }
     
     public void run() {
         while (!quit){
             try {
                //print menu & reader user's choice of method
                System.out.print("Operations available:\n0: quit\n1: addition\n2: substraction\nEnter your choice here: ");
                readMethodChoice = reader.next();
                methodChoice = Integer.parseInt(readMethodChoice);
                if (methodChoice == 0){
                    quit = true;
                    System.out.println("Thank you for using the calculator.");
                } else if (methodChoice == 1 || methodChoice == 2){
                    //read first number
                    System.out.print("First number: ");
                    num1 = reader.nextFloat();
                    //read second number
                    System.out.print("Second number: ");
                    num2 = reader.nextFloat();
                    if (methodChoice == 1){
                        result = num1 + num2;
                        System.out.println(num1 + " + " + num2 + " = "+ result);
                    } else {
                        result = num1 - num2;
                        System.out.println(num1 + " - " + num2 + " = "+ result);
                    }
                } else {
                    System.out.println("Operation " + methodChoice + " is not available");
                }
             } catch (Exception e) {
                 System.out.println( "Exception occured " + e);
             }
         }
    }
}
