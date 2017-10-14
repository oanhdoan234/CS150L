
public class Car
{
    private double speed; 
    private double distanceTravel;
    private double distanceToStation;
    private double tripLength;
    private long id;
    private int status; //0 is at home, 1 is on trip, 2 is at station
    private Battery battery;
    private double timeAtHome; 
    private double waitTime;
    private double timeInSystem;
    
    public Car(long id){
        this.speed = 2; 
        this.id = id;
        this.status = 0; 
        this.distanceTravel = 0;
        this.timeInSystem = 0;
        this.battery = new Battery();
    }
    
    //In a time step
    public boolean checkLowBattery(){
        return battery.lowBattery();
    }
    
    public void consumeBattery(){
        battery.decrease();
    }
    
    public void chargeBattery(){
        battery.increase();
    }
    
    public void increaseDistanceTraveled(){
        distanceTravel = distanceTravel + speed;
    }
    
    public void increaseTimeInSystem(){
        timeInSystem++;
    }
    
    public boolean compareTo(Car c){
        return(this.id == c.getId());
    }
    
    public void depart(){
        if (timeInSystem >= timeAtHome) status = 1; 
    }
    
    public void travel(){
        if (getBattery() > 0){    //getBattery() > 0 && status != 1 
            consumeBattery();
            increaseDistanceTraveled();
            increaseTimeInSystem();
        } 
    }
    
    public boolean canReachStation(){     
        if (distanceToStation/battery.getDistancePerUnit() < getBattery())return true;
        return false;
    }
    
    public void travelToStation(){
        //know distance to station 
    }
    
    public void lineUp(Station s){
        status = 2;
        ChargingPoint point = s.findShortestLine();
        point.enqueue(this);
        
        //for charging points at station, if it is empty, get there
        //if none, find the shortest line
        //get waiting number in line 
    }
    
    public void run(StationList stationList){
        while (battery.getBatteryLevel() > 0){
            depart();
            travel();
            if (checkLowBattery()){
                Station s = stationList.findNearestStation();       //find nearest station 
                double d = s.getDistanceToCar();                    //retrieve distance to that station
                setDistanceToStation(d);
                if(canReachStation()){
                    //traveltoStation
                    ChargingPoint p = s.findShortestLine();
                    if (p.getSize() == 0){
                        chargeBattery();
                    }
                }
             
            }
        }
    }
    
    public void charge(){
    }
    
    
    public void setTimeAtHome(double t){
        timeAtHome = t;
    }
    
 
    
    //set() methods 
    public void setDistanceToStation(double d){distanceToStation = d;}
    public void setId(long x){id = x;}
    
    //get() methods
    public int getStatus(){return status;}
    public double getBattery(){return battery.getBatteryLevel();}
    public double getDistanceTraveled(){return distanceTravel;}
    public double getTimeInSystem(){ return timeInSystem;}
    public long getId(){return id;}
    
}
