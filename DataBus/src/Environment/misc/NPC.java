package Environment.misc;

import Environment.WorldObject;

/**
 * Created by Németh Kriszitna on 2016.10.07..
 */
public class NPC extends WorldObject{
    private int movingDegree;
    private int movingSpeed;

    public NPC(int Id, int[] startPosition, double[] Transform, int Zlevel, int Opacity, int movingDegree, int movingSpeed) {
        super(Id, startPosition, Transform, Zlevel, Opacity);
        this.movingDegree = movingDegree; // mozgatás iránya
        this.movingSpeed = movingSpeed; // mozgtási sebesség
    }
}
