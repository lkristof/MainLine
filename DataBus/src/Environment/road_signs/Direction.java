package DataBus.src.Environment.road_signs;

import DataBus.src.Environment.Position;
import DataBus.src.Environment.WorldObject;

/**
 * Created by nemet on 2016. 09. 30..
 */
public class Direction extends WorldObject {
    public Direction(int Id, String Name, int Type, Position startPosition, int[] Transform, int Zlevel, int Opacity, DirectionType directionType) {
        super(Id, Name, Type, startPosition, Transform, Zlevel, Opacity);
        this.directionType = directionType;
    }

    public enum DirectionType {Forward,Left,Right,ForwardLeft,ForwardRight,Round}
    DirectionType directionType;

}
