
public class Battery
{
    private double distancePerUnit; 
    private double maxCapacity; 
    private double chargeTimePerUnit; 
    private double chargeUnitPerTime;
    private double currentBatteryLevel; 
    private double threshold;
    
    public Battery(){
        this.distancePerUnit = 2;
        this.maxCapacity = 10;
        this.chargeTimePerUnit = 2;
        this.chargeUnitPerTime = 1/this.chargeTimePerUnit;
        this.currentBatteryLevel = maxCapacity;
        this.threshold = 4;
    }
    
    //Consume 1 unit of battery per time unit 
    public void decrease(){
        if (currentBatteryLevel > 0) currentBatteryLevel--;
        return;
    }
    
    public void increase(){
        if (currentBatteryLevel < maxCapacity) currentBatteryLevel = currentBatteryLevel + chargeUnitPerTime;
        return; 
    }
    
    public boolean lowBattery(){ return (currentBatteryLevel <= threshold);}
    public double getBatteryLevel(){return currentBatteryLevel;}
    public double getDistancePerUnit(){return distancePerUnit;}
    
}
