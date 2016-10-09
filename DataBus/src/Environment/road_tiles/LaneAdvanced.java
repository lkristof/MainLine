package Environment.road_tiles;

import Environment.WorldObject;

/**
 * Created by nemet on 2016. 09. 30..
 */
public class LaneAdvanced extends WorldObject {
    public enum RoadPaintings1 {rp_none,rp_sep_1_s}
    public enum RoadPaintings2 {rp_none,rp_sep_2_s}
    public enum RoadPaintings3 {rp_none,rp_sep_3_s}
    public enum LaneAdvancedType {CrossRoads,Rotary,TJunctionLeft,TJunctionRight}

    RoadPaintings1 roadPaintings1;
    RoadPaintings2 roadPaintings2;
    RoadPaintings3 roadPaintings3;
    LaneAdvancedType laneAdvancedType;
    int[] roadColor1;
    int[] roadColor2;
    int[] roadColor3;

    public LaneAdvanced(int Id, int[] startPosition, double[] Transform, int Zlevel, int Opacity, int[] roadColor1, int[] roadColor2, int[] roadColor3, RoadPaintings1 roadPaintings1, RoadPaintings2 roadPaintings2, RoadPaintings3 roadPaintings3, LaneAdvancedType laneAdvancedType) {
        super(Id, startPosition, Transform, Zlevel, Opacity);
        this.roadPaintings1 = roadPaintings1;
        this.roadPaintings2 = roadPaintings2;
        this.roadPaintings3 = roadPaintings3;
        this.laneAdvancedType = laneAdvancedType;
        this.roadColor1 = roadColor1;
        this.roadColor2 = roadColor2;
        this.roadColor3 = roadColor3;
    }
}
