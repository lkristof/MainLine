package DataBus.src.Environment.misc;

import DataBus.src.Environment.Position;
import DataBus.src.Environment.WorldObject;

/**
 * Created by Akos on 2016. 09. 27..
 */
public class Crosswalk extends WorldObject{

    public Crosswalk(int Id, String Name, int Type, Position startPosition, int[] Transform, int Zlevel, int Opacity) {
        super(Id, Name, Type, startPosition, Transform, Zlevel, Opacity);
    }
}
