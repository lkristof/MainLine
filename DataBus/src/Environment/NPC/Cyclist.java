package Environment.NPC;

import Environment.WorldObject;

/**
 * Created by forii on 2016. 10. 14..
 */
public class Cyclist extends WorldObject {
    public Cyclist(int Id, int[] startPosition, int width, int height, double[] Transform, int Zlevel, int Opacity, boolean CanStuckOnIt) {
        super(Id, startPosition, width, height, Transform, Zlevel, Opacity, CanStuckOnIt);
    }
}
