package Environment.misc;

import Environment.Position;
import Environment.WorldObject;

/**
 * Created by Akos on 2016. 09. 27..
 */
public class Parking extends WorldObject{
    public Parking(int Id, Position startPosition, int[] Transform, int Zlevel, int Opacity, ParkingElement parkingElement) {
        super(Id, startPosition, Transform, Zlevel, Opacity);
        this.parkingElement = parkingElement;
    }

    public enum ParkingElement {Bollard,ParallelParking,PerpendicularParkinng}
    ParkingElement parkingElement;
}