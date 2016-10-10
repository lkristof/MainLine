package Environment.misc;

import Environment.WorldObject;

/**
 * Created by Akos on 2016. 09. 27..
 */
public class Parking extends WorldObject{
    public Parking(int Id, int[] startPosition, int Width, int Height, double[] Transform, int Zlevel, int Opacity, ParkingElement parkingElement, boolean CanStuckOnIt) {
        super(Id, startPosition, Width, Height, Transform, Zlevel, Opacity, CanStuckOnIt);
        this.parkingElement = parkingElement;
    }

    public enum ParkingElement {Bollard,ParallelParking,PerpendicularParking}
    ParkingElement parkingElement;
}