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

        assertEquals(first == second, true);
    }

    @org.junit.Test
    public void doesClassExist() throws Exception{
        assert(bus.getClass() != null);
    }

    @org.junit.Test
    public void hasBusDataMemberACCMainSwitchState(){
        //bus.ACCMainSwitchState = false;
        //assertEquals(bus.ACCMainSwitchState,false);
    }

    @org.junit.Test
    public void ACCMainSwitchGetterReturnsSetValue(){
       // bus.ACCMainSwitchState = false;
        bus.setACCMainSwitchState(false);
        assertEquals(bus.getACCMainSwitchState(), false);
        bus.setACCMainSwitchState(true);
        //bus.ACCMainSwitchState = true;
        assertEquals(bus.getACCMainSwitchState(), true);
    }

    @org.junit.Test
    public void ACCMainSwitchGetterReturnsSetterGivenValue(){
        bus.setACCMainSwitchState(false);
        assertEquals(bus.getACCMainSwitchState(), false);
        bus.setACCMainSwitchState(true);
        assertEquals(bus.getACCMainSwitchState(), true);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        /*GCC will remove bus*/
    }

}