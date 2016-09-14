/**
 * Created by ral2bp on 2016.09.14..
 */
public class Bus {
    /*data members, getters, setters*/
    private boolean ACCMainSwitchState;

    public boolean getACCMainSwitchState() {
        return ACCMainSwitchState;
    }

    public void setACCMainSwitchState(boolean ACCMainSwitchState) {
        this.ACCMainSwitchState = ACCMainSwitchState;
    }

    /*Singleton parts*/
    private static Bus instance = null;

    private Bus(){
        ACCMainSwitchState = false; //default main switch state value: off
    }

    public static Bus getInstance(){
        if(instance == null)
            instance = new Bus();

        return instance;
    }
}
