package DataBus.src.Environment.misc;

import DataBus.src.Environment.Position;
import DataBus.src.Environment.WorldObject;

/**
 * Created by Akos on 2016. 09. 27..
 */
public class Parking extends WorldObject{
    public Parking(int Id, String Name, int Type, Position startPosition, int[] Transform, int Zlevel, int Opacity, ParkingElement parkingElement) {
        super(Id, Name, Type, startPosition, Transform, Zlevel, Opacity);
        this.parkingElement = parkingElement;
    }

    public enum ParkingElement {Bollard,ParallelParking,PerpendicularParkinng}
    ParkingElement parkingElement;
}