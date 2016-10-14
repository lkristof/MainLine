package Environment.NPC;

import Environment.WorldObject;

/**
 * Created by nemeth on 2016.10.07..
 */
public abstract class NPC extends WorldObject implements IMovable{
    private int movingDegree;

    public int getMovingSpeed() {
        return movingSpeed;
    }

    public void setMovingSpeed(int movingSpeed) {
        this.movingSpeed = movingSpeed;
    }

    private int movingSpeed;

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    private boolean isMoving;

    public NPC(int Id, int[] startPosition, int Width, int Height, double[] Transform, int Zlevel, int Opacity, int movingDegree, int movingSpeed) {
        super(Id, startPosition, Width, Height, Transform, Zlevel, Opacity, true);
        this.movingDegree = movingDegree; // mozgatás iránya
        this.movingSpeed = movingSpeed; // mozgtási sebesség

    }


    @Override
    public String toString() {
        return "NPC{" +
                "movingDegree=" + movingDegree +
                ", movingSpeed=" + movingSpeed +
                '}';
    }

    @Override
    public void startNPC()
    {
        setMoving(true);
    }

    @Override
    public void stopNPC() {
        setMoving(false);
    }

    @Override //Objektumok mozgatása...
    public void MoveObject() {

    }
}
