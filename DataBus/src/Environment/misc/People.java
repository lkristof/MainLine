package Environment.misc;

import Environment.WorldObject;

/**
 * Created by Akos on 2016. 09. 27..
 */
public class People extends WorldObject {


    int Width = 80;
    int Height = 80;
    public People(int Id, int[] startPosition, double[] Transform, int Zlevel, int Opacity) {
        super(Id, startPosition, 75, 80, Transform, Zlevel, Opacity, true);
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName()+  " elem adatai:  " + "   Id: " + this.getId() + "   Zlevel: " + this.getZLevel() + "   Opacity: " + this.getOpacity() + "  CanStuckOnIt: " + this.getCanStuckOnIt();
    }
}
