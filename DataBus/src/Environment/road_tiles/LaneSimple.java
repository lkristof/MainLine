package Environment.road_tiles;

import Environment.WorldObject;

/**
 * Created by nemet on 2016. 09. 30..
 */
public class LaneSimple extends WorldObject{
    public enum RoadPaintings1 {undefinied1,undefinied2,undefinied3}
    public enum RoadPaintings2 {undefinied1,undefinied2,undefinied3,undefinied4,undefinied5,undefinied6,undefinied7,undefinied8}
    public enum RoadPaintings3 {undefinied1,undefinied2,undefinied3}
    public enum LaneSimpleType {Left45,Left65,Left90,Right45,Right65,Right90,Straight}

    String[] roadColor1;
    String[] roadColor2;
    String[] roadColor3;

    RoadPaintings1 roadPaintings1;
    RoadPaintings2 roadPaintings2;
    RoadPaintings3 roadPaintings3;
    LaneSimpleType laneSimpleType;

    public LaneSimple(int Id, int[] startPosition,
                      double[] Transform, int Zlevel, int Opacity, String[] roadColor1, String[] roadColor2, String[] roadColor3, RoadPaintings1 roadPaintings1, RoadPaintings2 roadPaintings2,
                      RoadPaintings3 roadPaintings3, LaneSimpleType laneSimpleType) {
        super(Id, startPosition, Transform, Zlevel, Opacity);
        this.roadPaintings1 = roadPaintings1;
        this.roadPaintings2 = roadPaintings2;
        this.roadPaintings3 = roadPaintings3;
        this.laneSimpleType = laneSimpleType;
        this.roadColor1 = roadColor1;
        this.roadColor2 = roadColor2;
        this.roadColor3 = roadColor3;
    }

    @Override
    public String toString() {
        return roadPaintings1.toString() + " " + roadPaintings2.toString() + " " + roadPaintings3.toString() + " " + laneSimpleType.toString();
    }
}
