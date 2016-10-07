package Environment.misc;

import Environment.WorldObject;

/**
 * Created by Akos on 2016. 09. 27..
 */
public class People extends WorldObject {


    public People(int Id, int[] startPosition, double[] Transform, int Zlevel, int Opacity) {
        super(Id, startPosition, Transform, Zlevel, Opacity);
    }


    public String toString()
    {
        return "Id" + this.getId() + "Zlevel: " + this.getZLevel() + "Opacity: " + this.getOpacity();
    }
}
