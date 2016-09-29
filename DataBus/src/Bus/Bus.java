package Bus;

public class Bus {
    /*data members, getters, setters*/
    private boolean ACCMainSwitchState;

    public boolean getACCMainSwitchState() {
        return ACCMainSwitchState;
    }

    public void setACCMainSwitchState(boolean ACCMainSwitchState) {
        this.ACCMainSwitchState = ACCMainSwitchState;
    }

    private int gasPedal;

    public int getGasPedal(){ return gasPedal;}

    public void setGasPedal(int gasPedal){
        if(gasPedal< 100 && gasPedal > 0)
            this.gasPedal = gasPedal;
        else if(gasPedal > 0)
            this.gasPedal = 100;
        else
            this.gasPedal = 0;

    }

    private int brakePedal;

    public int getBrakePedal(){ return brakePedal;}

    public void setBrakePedal(int gasPedal){
        if(gasPedal< 100 && gasPedal > 0)
            this.brakePedal = gasPedal;
        else if(gasPedal > 0)
            this.brakePedal = 100;
        else
            this.brakePedal = 0;
    }

    private int steeringWheelAngle;

    public int getSteeringWheelAngle(){
        return steeringWheelAngle;
    }

    public void setSteeringWheelAngle(int steeringWheelAngle){
        if(steeringWheelAngle< 100 && steeringWheelAngle > 0)
            this.steeringWheelAngle = steeringWheelAngle;
        else if(steeringWheelAngle > 0)
            this.steeringWheelAngle = 100;
        else
            this.steeringWheelAngle = 0;
    }

    public boolean isDirectionIndicatorLeftActive() {
        return directionIndicatorLeftActive;
    }

    public void setDirectionIndicatorLeftActive(boolean directionIndicatorLeftActive) {
        this.directionIndicatorLeftActive = directionIndicatorLeftActive;
    }

    private boolean directionIndicatorLeftActive;


    public boolean isDirectionIndicatorRightActive() {
        return DirectionIndicatorRightActive;
    }

    public void setDirectionIndicatorRightActive(boolean directionIndicatorRightActive) {
        DirectionIndicatorRightActive = directionIndicatorRightActive;
    }

    private boolean DirectionIndicatorRightActive;

    public enum GearPosition{
        PARK,REVERSE,NEUTRAL,DRIVE
    }

    public GearPosition getGearPosition() {
        return gearPosition;
    }

    public void setGearPosition(GearPosition gearPosition) {
        this.gearPosition = gearPosition;
    }

    private GearPosition gearPosition;

    public float getCurrentSISpeed() {
        return currentSISpeed;
    }

    public void setCurrentSISpeed(float currentSISpeed) {
        this.currentSISpeed = currentSISpeed;
    }

    private float currentSISpeed;

    /*Singleton parts*/

    public static Bus getInstance(){
        if(instance == null)
            instance = new Bus();

        return instance;
    }

    private static Bus instance = null;

    private Bus(){
        ACCMainSwitchState = false; //default main switch state value: off
    }

}
