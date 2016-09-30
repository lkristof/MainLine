package Environment.misc;

import Environment.Position;
import Environment.WorldObject;

/**
 * Created by nemet on 2016. 09. 30..
 */
public class Tree extends WorldObject{
    public Tree(int Id, String Name, int Type, Position startPosition, int[] Transform, int Zlevel, int Opacity) {
        super(Id, Name, Type, startPosition, Transform, Zlevel, Opacity);
    }
}
