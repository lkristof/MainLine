package Environment.misc;

import Environment.WorldObject;

/**
 * Created by Akos on 2016. 09. 27..
 */
public class Parking extends WorldObject{
    public Parking(int Id, int[] startPosition, double[] Transform, int Zlevel, int Opacity, ParkingElement parkingElement) {
        super(Id, startPosition, Transform, Zlevel, Opacity);
        this.parkingElement = parkingElement;
    }

    public enum ParkingElement {Bollard,ParallelParking,PerpendicularParkinng}
    ParkingElement parkingElement;
}