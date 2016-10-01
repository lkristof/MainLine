package Environment.road_signs;

import Environment.Position;
import Environment.WorldObject;

/**
 * Created by nemet on 2016. 09. 30..
 */


public class Parking extends WorldObject{

    public Parking(int Id, String Name, int Type, Position startPosition, int[] Transform, int Zlevel, int Opacity, ParkingType parkingType) {
        super(Id, Name, Type, startPosition, Transform, Zlevel, Opacity);
        this.parkingType = parkingType;
    }

    public enum ParkingType { ParkingLeft, ParkingRight }
    ParkingType parkingType;


}
