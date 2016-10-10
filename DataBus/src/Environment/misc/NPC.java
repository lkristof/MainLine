package Environment.misc;

import Environment.WorldObject;

/**
 * Created by Németh Kriszitna on 2016.10.07..
 */
public abstract class NPC extends WorldObject{
    private int movingDegree;
    private int movingSpeed;

    public NPC(int Id, int[] startPosition, int Width, int Height, double[] Transform, int Zlevel, int Opacity, int movingDegree, int movingSpeed) {
        super(Id, startPosition, Width, Height, Transform, Zlevel, Opacity, true);
        this.movingDegree = movingDegree; // mozgatás iránya
        this.movingSpeed = movingSpeed; // mozgtási sebesség
    }
}
