package Environment.road_signs;

import Environment.WorldObject;

/**
 * Created by nemeth on 2016.10.07..
 */
public class ParkingSign extends WorldObject {

    public ParkingSign(int Id, int[] startPosition, double[] Transform, int Zlevel, int Opacity, ParkingSignType parkingSignType) {
        super(Id, startPosition, 80, 80, Transform, Zlevel, Opacity, false);
        this.parkingSignType = parkingSignType;
    }

    public enum ParkingSignType {ParkingLeft, ParkingRight}
    ParkingSignType parkingSignType;

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+  " elem adatai:  " + "   Id: " + this.getId() + "   Zlevel: " + this.getZLevel() + "   Opacity: " + this.getOpacity()  + "  CanStuckOnIt: " + this.getCanStuckOnIt() + "  ParkingSignTye: " + this.parkingSignType;

    }
}
