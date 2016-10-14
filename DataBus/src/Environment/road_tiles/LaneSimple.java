package Environment.road_tiles;

import Environment.WorldObject;

import java.util.Arrays;

/**
 * Created by nemeth on 2016. 09. 30..
 */
public class LaneSimple extends WorldObject{
    public enum RoadPaintings1 {rp_none,rp_sep_1_s,rp_sep_1_sb}
    public enum RoadPaintings2 {rp_none,rp_sep_2_bnd,rp_sep_2_d,rp_sep_2_dbnd,rp_sep_2_ds,rp_sep_2_s,rp_sep_2_sd,rp_sep_2_ss}
    public enum RoadPaintings3 {rp_none,rp_sep_3_s,rp_sep_3_sb}
    public enum LaneSimpleType {Left45,Left65,Left90,Right45,Right65,Right90,Straight}

    // rp_sep_1 bal szél
    // rp_sep_2 közép
    // rp_sep_3 jobb szél
    // none - nincs
    // s - sima vonal (vékony)
    // sb - sima vonal (vastag - bold)
    // d - szaggatott vonal
    // ss - dupla sima vonal (dupla záróvonal)
    // ds - szaggatott záró
    // sd - záró szaggatott
    // bnd
    // dbnd - double pontozott (talán a fényvisszaverő)

    int[] roadColor1;
    int[] roadColor2;
    int[] roadColor3;

    RoadPaintings1 roadPaintings1;
    RoadPaintings2 roadPaintings2;
    RoadPaintings3 roadPaintings3;
    LaneSimpleType laneSimpleType;

    public LaneSimple(int Id, int[] startPosition, int Width, int Height,
                      double[] Transform, int Zlevel, int Opacity, int[] roadColor1, int[] roadColor2, int[] roadColor3, RoadPaintings1 roadPaintings1, RoadPaintings2 roadPaintings2,
                      RoadPaintings3 roadPaintings3, LaneSimpleType laneSimpleType) {
        super(Id, startPosition, Width, Height, Transform, Zlevel, Opacity, false);

        this.roadPaintings1 = roadPaintings1;
        this.roadPaintings2 = roadPaintings2;
        this.roadPaintings3 = roadPaintings3;
        this.laneSimpleType = laneSimpleType;
        this.roadColor1 = roadColor1;
        this.roadColor2 = roadColor2;
        this.roadColor3 = roadColor3;
    }

    /*@Override
    public String toString() {
        return  "RoadColor1: " + Arrays.toString(roadColor1) + " " + "RoadColor2: " + Arrays.toString(roadColor2) + " " + "RoadColor3: " + Arrays.toString(roadColor3) + " " + roadPaintings1.toString() + " " + roadPaintings2.toString() + " " + roadPaintings3.toString() + " " + laneSimpleType.toString();
    }*/

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+  " elem adatai:  " + "   Id: " + this.getId() + "   Zlevel: " + this.getZLevel() + "   Opacity: " + this.getOpacity() + "  CanStuckOnIt: " + this.getCanStuckOnIt() + "  LaneSimpleType: " + this.laneSimpleType + "  RoadColor1: " + Arrays.toString(roadColor1) + "  RoadColor2: " + Arrays.toString(roadColor2) + "  RoadColor3: " + Arrays.toString(roadColor3) + "  RoadPaintigs1: " + this.roadPaintings1 + "  RoadPaintings2: " + this.roadPaintings2 + "  RoadPaintings3: " + this.roadPaintings3;


    }
}
