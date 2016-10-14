package Environment.misc;

import Environment.WorldObject;

/**
 * Created by nemeth on 2016. 09. 30..
 */
public class Tree extends WorldObject{
    int Width = 150;
    int Height = 150;
    public Tree(int Id, int[] startPosition, double[] Transform, int Zlevel, int Opacity) {
        super(Id, startPosition, 145, 160, Transform, Zlevel, Opacity, true);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+  " elem adatai:  " + "   Id: " + this.getId() + "   Zlevel: " + this.getZLevel() + "   Opacity: " + this.getOpacity() + "  CanStuckOnIt: " + this.getCanStuckOnIt();
    }
}
