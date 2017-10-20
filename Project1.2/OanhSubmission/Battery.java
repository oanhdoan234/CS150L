
public class Battery
{
    private double distancePerUnit; 
    private double maxCapacity; 
    private double chargeTimePerUnit; 
    private double chargeUnitPerTime;
    private double currentBatteryLevel; 
    private double threshold;
    
    public Battery(double distancePerUnit, double threshold, double chargeTimePerUnit, double maxCapacity){
        this.distancePerUnit = distancePerUnit;
        this.maxCapacity = maxCapacity;
        this.chargeTimePerUnit = chargeTimePerUnit;
        this.chargeUnitPerTime = 1/this.chargeTimePerUnit;
        this.currentBatteryLevel = maxCapacity;
        this.threshold = threshold;
    }
    
    public void decrease(){                                             //Consume battery
        if (currentBatteryLevel > 0) currentBatteryLevel--;
        return;
    }
    
    public void increase(){                                             //charge battery
        if (currentBatteryLevel < maxCapacity) currentBatteryLevel = currentBatteryLevel + chargeUnitPerTime;
        return; 
    }
    
    public boolean lowBattery(){ return (currentBatteryLevel <= threshold);}
    public boolean fullBattery(){return (currentBatteryLevel == maxCapacity);}
    public double getBatteryLevel(){return currentBatteryLevel;}
    public double getDistancePerUnit(){return distancePerUnit;}
    public double distanceTillBatteryDepleted(){return distancePerUnit*currentBatteryLevel;}
    
}
