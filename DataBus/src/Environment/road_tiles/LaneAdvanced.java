package Environment.road_tiles;

import Environment.WorldObject;

import java.util.Arrays;

/**
 * Created by nemeth on 2016. 09. 30..
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

    public LaneAdvanced(int Id, int[] startPosition, int Width, int Height, double[] Transform, int Zlevel, int Opacity, int[] roadColor1, int[] roadColor2, int[] roadColor3, RoadPaintings1 roadPaintings1, RoadPaintings2 roadPaintings2, RoadPaintings3 roadPaintings3, LaneAdvancedType laneAdvancedType) {
        super(Id, startPosition, Width, Height, Transform, Zlevel, Opacity, false);
        this.roadPaintings1 = roadPaintings1;
        this.roadPaintings2 = roadPaintings2;
        this.roadPaintings3 = roadPaintings3;
        this.laneAdvancedType = laneAdvancedType;
        this.roadColor1 = roadColor1;
        this.roadColor2 = roadColor2;
        this.roadColor3 = roadColor3;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+  " elem adatai:  " + "   Id: " + this.getId() + "   Zlevel: " + this.getZLevel() + "   Opacity: " + this.getOpacity() + "  CanStuckOnIt: " + this.getCanStuckOnIt() + "  LaneAdvancedType: " + this.laneAdvancedType + "  RoadColor1: " + Arrays.toString(roadColor1) + "  RoadColor2: " + Arrays.toString(roadColor2) + "  RoadColor3: " + Arrays.toString(roadColor3) + "  RoadPaintigs1: " + this.roadPaintings1 + "  RoadPaintings2: " + this.roadPaintings2 + "  RoadPaintings3: " + this.roadPaintings3;

    }
}

