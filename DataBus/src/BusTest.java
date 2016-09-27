import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ral2bp on 2016.09.14..
 */
public class BusTest {
    Bus bus = Bus.getInstance();

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void isBusSingleton()
    {
        Bus first = Bus.getInstance();
        Bus second = Bus.getInstance();

        assertEquals(first == second, true);

        first.setACCMainSwitchState(true);

        assertEquals(second.getACCMainSwitchState(), true);
    }

    @org.junit.Test
    public void doesClassExist() throws Exception{
        assert(bus.getClass() != null);
    }

    @org.junit.Test
    public void ACCMainSwitchGetterReturnsSetterGivenValue(){
        bus.setACCMainSwitchState(false);
        assertEquals(bus.getACCMainSwitchState(), false);
        bus.setACCMainSwitchState(true);
        assertEquals(bus.getACCMainSwitchState(), true);
    }

    @Test
    public void gasPedalGetterReturnsSetterGivenValue(){
        bus.setGasPedal(65);
        assertEquals(bus.getGasPedal(), 65);
    }

    @Test
    public void gasPedalValueIsMaximum100() {
        bus.setGasPedal(111);
        assertEquals(bus.getGasPedal(), 100);
    }

    @Test
    public void gasPedalValueIsMinimum0() {
        bus.setGasPedal(-77);
        assertEquals(bus.getGasPedal(), 0);
    }

    @Test
    public void brakePedalGetterReturnsSetterGivenValue(){
        bus.setBrakePedal(65);
        assertEquals(bus.getBrakePedal(), 65);
    }

    @Test
    public void brakePedalValueIsMaximum100() {
        bus.setBrakePedal(111);
        assertEquals(bus.getBrakePedal(), 100);
    }

    @Test
    public void brakePedalValueIsMinimum0() {
        bus.setBrakePedal(-77);
        assertEquals(bus.getBrakePedal(), 0);
    }

    @Test
    public void steeringWheelAngleGetterReturnsSetterGivenValue(){
        bus.setSteeringWheelAngle(65);
        assertEquals(bus.getSteeringWheelAngle(), 65);
    }

    @Test
    public void steeringWheelAngleValueIsMaximum100() {
        bus.setSteeringWheelAngle(111);
        assertEquals(100,bus.getSteeringWheelAngle());
    }

    @Test
    public void steeringWheelAngleValueIsMinimum0() {
        bus.setSteeringWheelAngle(-77);
        assertEquals(bus.getSteeringWheelAngle(), 0);
    }

    @Test
    public void directionIndicatorLeftActiveGetterReturnsSetterGivenValue(){
        bus.setDirectionIndicatorLeftActive(true);
        assertEquals(bus.isDirectionIndicatorLeftActive(), true);
        bus.setDirectionIndicatorLeftActive(false);
        assertEquals(bus.isDirectionIndicatorLeftActive(), false);
    }

    @Test
    public void gearPositionGetterReturnsSetterGivenValue(){
        bus.setGearPosition(Bus.GearPosition.NEUTRAL);
        assertEquals(Bus.GearPosition.NEUTRAL, bus.getGearPosition());
        bus.setGearPosition(Bus.GearPosition.DRIVE);
        assertEquals(Bus.GearPosition.DRIVE, bus.getGearPosition());
    }

    @org.junit.After
    public void tearDown() throws Exception { 
        /*GCC will remove bus*/
    }

}