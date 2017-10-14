
public class Car
{
   private long id;
   private double speed;
   private Battery battery;
   private StationList stationList;
   private double millage;
   private boolean simulateInterval;
   private boolean simulateTrip;
   private boolean findStation;
   private double interval; 
   private double trip; 
   private Station station;
   private int status;
   private double waitTime;
   
   public Car(long id, double speed, Battery battery, StationList stationList){
       this.id = id; 
       this.status = 0;
       this.speed = speed;
       this.battery = battery;
       this.stationList = stationList;
       this.millage = 0;
       this.waitTime = 0;
       this.simulateInterval = false; 
       this.simulateTrip = false; 
       this.findStation = false;
   }
   
   // public static void main(String[] args){
       // StationList stations = new StationList(new RandomGaussian(4.0,2.0));
       // Station s1 = new Station(1); 
       // Station s2 = new Station(2); 
       // stations.add(s1);
       // stations.add(s2);
       // Car c1 = new Car(1,2.0, new Battery(), stations);
       // c1.setTrip(22.0);
       // c1.setStatus(1);
       // for (int i = 0; i <9; i++){ 
           // c1.run();
           // System.out.println("Trip Length: " + c1.getTrip());
           // System.out.println("Battery level: " + c1.batteryLevel());
           // System.out.println("Millage: " + c1.getMillage());
           // System.out.println("Status: " + c1.getStatus());
           // System.out.println("Can complete trip: " + c1.canCompleteTrip());
           // System.out.println("===================================================================");
       // }

   // }
   
   /** In a time step */
   public double start(RandomGaussian tripInterval){                                //generate trip interval
       this.interval = tripInterval.getGaussian();
       while (this.interval < 0){this.interval = tripInterval.getGaussian();}
       this.simulateInterval = true; 
       return this.interval;
   }
   
   public double generateTripDistance(RandomGaussian tripDistance){                 //Generate trip distance
       this.trip = tripDistance.getGaussian();
       while (this.trip < 0){this.trip = tripDistance.getGaussian();}
       this.simulateTrip = true;
       return this.trip;
   }
   
   public void putMeAtHome(){                                                       //put a car at home
       status = 0;
       millage = 0;                                                                 //reset millage
       simulateInterval = false; 
       simulateTrip = false;
   }
   
   public void onTrip(){                                                            //a car on road
       status = 1;
       findStation = false;
       consume();                                                                   //decrease battery
       increaseMillage();                                                           //increase millage
   }
   
   public void run(){
       if (status == 1){
           if (battery.getBatteryLevel() == 0){ 
               System.out.println("I am out");
               status = -1;
               //return;
           } else { 
               if (!lowBattery()){
                   //System.out.println("Keep moving");
                   onTrip();
                   //System.out.println("Am I Done:" + amIDone());
                   if (amIDone()){
                       //System.out.println("I reached home");
                       putMeAtHome();
                   }
               } else if (lowBattery()){
                   if (canCompleteTrip()){
                       //System.out.println("battery is low but Keep moving");
                       onTrip();
                       //System.out.println("Am I Done:" + amIDone());
                       if (amIDone()){
                           //System.out.println("I reached home");
                           putMeAtHome();
                       }
                   } else {
                       //System.out.println("Find a station please");
                       if (findStation == false){
                           station = stationList.findNearestStation();
                           findStation = true;
                       }
                       
                       if (station == null || remainingMillage() < station.getDistance()){
                           onTrip();
                       } else {
                           double distanceToStation = station.getDistance();
                           while (distanceToStation > 0){
                               onTrip();
                               distanceToStation--;
                           }
                           status = 2;
                           station.addRequest(this);
                       }
                   }
               }
           }
       }
   }
   
   public void simulateOneStep(RandomGaussian tripInterval, RandomGaussian tripDistance){
       if(simulateInterval == false)interval = start(tripInterval);
       //System.out.println("Trip interval is: "  + interval);
       if (interval <= 0){
           if (simulateTrip == false){
               trip = generateTripDistance(tripDistance);
               status = 1;
            }
           System.out.println("Trip distance is " + trip);
           run();
           //System.out.println(millage);
       }
       interval --;
   }
   
   public void consume(){battery.decrease();}
   public void increaseMillage(){millage = millage + speed;}
   public void charge() {battery.increase();}
   public void waiting(){waitTime++;}
   public long getId(){ return id;}
   public double getMillage(){return millage;}
   public double getWaitTime(){return waitTime;}
   public void resetWaitTime(){waitTime = 0;}
   public double batteryLevel(){ return battery.getBatteryLevel();}
   public boolean fullBattery() { return battery.fullBattery();} 
   public boolean lowBattery(){ return battery.lowBattery();}
   public boolean canCompleteTrip(){return battery.distanceTillBatteryDepleted() >= (trip-millage);  }
   public double remainingMillage(){return battery.distanceTillBatteryDepleted();}
   public boolean amIDone(){return millage-trip >=0;}
   public int getStatus(){return status;}
   public void setStatus(int s){status = s;}
   public void setTrip(double t){trip = t;}
   public void setFindStation(boolean b){findStation = b;}
   public double getTrip(){return trip;}
   public String convertStatus(int status){
       if (status == 0){ return "At home";} 
       else if(status == 2){ return "At a charging station";}
       else if (status == 1){ return "Traveling";}
       else if (status == -1){ return "Removed from simulation";}
       return null;
   }
}
