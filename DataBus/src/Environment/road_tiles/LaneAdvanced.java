package Environment.road_tiles;

import Environment.Position;
import Environment.WorldObject;

/**
 * Created by nemet on 2016. 09. 30..
 */
public class LaneAdvanced extends WorldObject {
    public enum RoadPaintings1 {undefinied1,undefinied2}
    public enum RoadPaintings2 {undefinied1,undefinied2}
    public enum RoadPaintings3 {undefinied1,undefinied2}
    public enum LaneAdvancedType {CrossRoads,Rotary,TJunctionLeft,TJunctionRight}

    public LaneAdvanced(int Id, String Name, int Type, Position startPosition,
                        int[] Transform, int Zlevel, int Opacity) {
        super(Id, Name, Type, startPosition,
        Transform, Zlevel, Opacity);
    }
}
