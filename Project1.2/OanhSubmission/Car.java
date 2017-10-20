
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
       if (status == 1){                                                            //if a car is travelling 
           
           if (battery.getBatteryLevel() == 0){                                     //remove if battery is depleted
               status = -1;
           } else { 
               
               if (!lowBattery()){                                                  //Keep moving if battery is still above threshold
                   onTrip();
                   if (amIDone())putMeAtHome();
                   
               } else if (lowBattery()){                                            //If battery is below threshold
                   if (canCompleteTrip()){                                              //keep heading for home if there is enought battery
                       onTrip();
                       if (amIDone())putMeAtHome();                                     //stay at home when done
                       
                   } else {
                       if (findStation == false){                                       //find a station to charge if there is not enough battery   
                           station = stationList.findNearestStation();
                           findStation = true;
                       }
                       if (station == null || remainingMillage() < station.getDistance()){ //keep moving until battery is depleted if no station
                           onTrip();                                                       //is found or reachable
                       } else {
                           double distanceToStation = station.getDistance();               //go to the station if find one
                           while (distanceToStation > 0){
                               onTrip();
                               distanceToStation--;
                           }
                           status = 2;
                           station.addRequest(this);                                       //get on the line at the charging station
                       }
                   }
               }
           }
       }
   }
   
   public void simulateOneStep(RandomGaussian tripInterval, RandomGaussian tripDistance){
       if(simulateInterval == false)interval = start(tripInterval);                        //generate a trip interval
       if (interval <= 0){                                                                 //start the trip once the interval passes
           if (simulateTrip == false){                                          
               trip = generateTripDistance(tripDistance);                                  //generate a trip distance
               status = 1;
            }
           run();                                                                          //travel
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
