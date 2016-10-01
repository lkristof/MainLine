package Environment.road_signs;

import Environment.Position;
import Environment.WorldObject;

/**
 * Created by nemet on 2016. 09. 30..
 */
public class Priority extends WorldObject {
    public Priority(int Id, String Name, int Type, Position startPosition, int[] Transform, int Zlevel, int Opacity, PriorityType priorityType) {
        super(Id, Name, Type, startPosition, Transform, Zlevel, Opacity);
        this.priorityType = priorityType;
    }

    public enum PriorityType { Priority, Stop, Yield}
    PriorityType priorityType;


}
