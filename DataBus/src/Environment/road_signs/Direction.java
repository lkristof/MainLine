package Environment.road_signs;

import Environment.WorldObject;

/**
 * Created by nemeth on 2016. 09. 30..
 */
public class Direction extends WorldObject {
    public Direction(int Id, int[] startPosition, double[] Transform, int Zlevel, int Opacity, DirectionType directionType) {
        super(Id, startPosition, 80, 80, Transform, Zlevel, Opacity, false);
        this.directionType = directionType;
    }

    public enum DirectionType {Forward,Left,Right,ForwardLeft,ForwardRight,Round}
    DirectionType directionType;

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+  " elem adatai:  " + "   Id: " + this.getId() + "   Zlevel: " + this.getZLevel() + "   Opacity: " + this.getOpacity() + "  CanStuckOnIt: " + this.getCanStuckOnIt() +  "  DirectionType: " + this.directionType;
    }
}
