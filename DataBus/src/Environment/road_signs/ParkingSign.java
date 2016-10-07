package Environment.road_signs;

import Environment.WorldObject;

/**
 * Created by Németh Kriszitna on 2016.10.07..
 */
public class ParkingSign extends WorldObject {
    public enum ParkingSignType {ParkingLeft, ParkingRigth}
    ParkingSignType parkingSignType;

    public ParkingSign(int Id, int[] startPosition, double[] Transform, int Zlevel, int Opacity, ParkingSignType parkingSignType) {
        super(Id, startPosition, Transform, Zlevel, Opacity);
        this.parkingSignType = parkingSignType;
    }
}
