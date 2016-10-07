package Environment.road_signs;

import Environment.WorldObject;

/**
 * Created by nemet on 2016. 09. 30..
 */
public class Priority extends WorldObject {
    public Priority(int Id, int[] startPosition, double[] Transform, int Zlevel, int Opacity, PriorityType priorityType) {
        super(Id, startPosition, Transform, Zlevel, Opacity);
        this.priorityType = priorityType;
    }

    public enum PriorityType { Priority, Stop, Yield}
    PriorityType priorityType;


}
