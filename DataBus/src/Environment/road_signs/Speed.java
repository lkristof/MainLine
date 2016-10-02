package Environment.road_signs;

import Environment.Position;
import Environment.WorldObject;

/**
 * Created by nemet on 2016. 09. 30..
 */
public class Speed extends WorldObject{
    public Speed(int Id, Position startPosition, int[] Transform, int Zlevel, int Opacity, SpeedType speedType) {
        super(Id, startPosition, Transform, Zlevel, Opacity);
        this.speedType = speedType;
    }

    public enum SpeedType { Ten, Twenty, Forty, Fifty, Seventy, Ninety, Hundred}
    SpeedType speedType;


}
