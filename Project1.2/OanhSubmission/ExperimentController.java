import java.util.*;
import java.lang.*;
import java.io.PrintWriter;

public class ExperimentController
{
    private int skip;
    private boolean command;
    private boolean quit;
    private int count;
    
    public ExperimentController(){
        this.command = true; 
        this.count = 0;
        this.quit = false; 
    }
    
    public static void main(String[] args){
        ExperimentController controller = new ExperimentController();
        
        ProgramInput input = new ProgramInput(args[0]);                             //load inputs
        ProgramInput input1 = new ProgramInput(args[0]);
        ProgramInput input2 = new ProgramInput(args[0]);
        ArrayList<Integer> ints     =  input.readInt(0,3);
        ArrayList<Double> doubles   = input1.readDouble(3,8);
        ArrayList<RandomGaussian> randoms = input2.readRandomGaussian(8,4328472);
        //5 seeds
        //4328472
        //4340590
        //2314892
        //3219373
        //3216732
        int numberTesla             = ints.get(0);
        int numberChargingStation   = ints.get(1);
        int numberChargingPoints    = ints.get(2);
        double averageSpeed            = doubles.get(0);
        double mileagePerUnitBattery   = doubles.get(1);
        double batteryThreshold        = doubles.get(2);
        double chargeTime              = doubles.get(3);
        double batteryCapacity         = doubles.get(4); 
        RandomGaussian distanceToChargingStation = randoms.get(0);
        RandomGaussian tripDistance              = randoms.get(1);
        RandomGaussian tripInterval              = randoms.get(2);

        StationList stations = new StationList(distanceToChargingStation);                    //create a carlist and a station list
        CarList cars = new CarList(); 
        
        int numberOfSteps = Integer.parseInt(args[1]);                                       
        for (int i = 0; i < numberChargingStation; i++) {                                      //add stations to station list
            Station s = new Station(i);
            stations.add(s);
        }
        
        for (int i = 0; i < numberTesla; i++){                                                 //add cars to car list
            Car c =  new Car(i,averageSpeed, new Battery(mileagePerUnitBattery,batteryThreshold,chargeTime,batteryCapacity), stations); 
            cars.add(c);
        }
        
        try{
            PrintWriter p = new PrintWriter("output.csv");
            p.write("step,TotalCars,WaitingCars,WaitTime\n");
            for (int i = 0; i < numberOfSteps; i++){
                if (!controller.quit()){                                                       //prompted to quit by user                  
                    System.out.println("-----------------------------------------------------\nStep " + i);
                    ArrayList<Integer> numCars = cars.simulateOneStep(tripInterval,tripDistance);           //simulate cars
                    double time = stations.simulateOneStep();                                               //simulate stations
                    p.write(i + "," + numCars.get(0) +"," + numCars.get(1) + "," + time + "\n"); 
                    if (controller.getExecuteCommand()){                                       //perform s or c
                        controller.executeCommand(i, cars, stations, numberOfSteps);
                    } else {                                                                   
                        controller.increaseCount();
                        if (controller.getCount() >= controller.getSkip()) {
                            controller.setExecuteCommand(true);
                            controller.resetCount();
                        }
                    }
                }
            }
            p.close();
        }catch(Exception e){
            System.out.println(e); 
        }
    }
    
    public void executeCommand(int state, CarList cars, StationList stations, int numberOfSteps){
        /**
         p: print the state of the simulation. Print the charge of each car, the cars at each charging station,
         t: print the state of each car (h - home, t - traveling, w - at a charging station),
         e: print the state of each charging station, showing the cars (with ids) at each charging point (with ids)
         s <integer n >: continue n steps forward in the simulation,
         c: continue to the end of the simulation (number of time steps specified) without stopping,
         x: exit the simulation now and print all relevant statistics
        */
        Scanner reader = new Scanner(System.in); 
        System.out.println("User choice:");

        String command = reader.next(); 
        if (command.compareTo("p") == 0) {System.out.println(cars.commandP());} 
        else if (command.compareTo("t") == 0){System.out.println(cars.commandT());}
        else if (command.compareTo("e") == 0){System.out.println(stations.commandE());}
        else if (command.compareTo("s") == 0){
            System.out.println("Enter a number of steps to continue: ");
            this.skip= reader.nextInt(); 
            this.command =false; 
        } else if (command.compareTo("c") == 0) {
            this.skip = numberOfSteps;
            this.command = false;
        }else if (command.compareTo("x") == 0){this.quit = true;}
    }
    
    public boolean quit(){return quit;}
    public boolean getExecuteCommand(){return this.command;}
    public void increaseCount(){this.count ++;} 
    public void resetCount(){this.count = 0;}
    public int getSkip(){ return this.skip;}
    public int getCount(){ return this.count;}
    public void setExecuteCommand(boolean b){ this.command =b;}
}

