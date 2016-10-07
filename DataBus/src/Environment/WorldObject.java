package Environment;
import java.lang.*;

import java.util.ResourceBundle;

/**
 * Created by Akos on 2016. 09. 27..
 */
 public abstract class WorldObject {

        //id
        private int id;
        public int getId() { return this.id; }
        public void setId(int id) { this.id = id; }

        //position
        private int[] position;
        public int[] getPosition() { return this.position; }
        public void setPosition(int[] position) { this.position = position; }

        //transform
        private double[] transform;
        public double[] getTransform() { return this.transform; }
        public void setTransform(double[] transform) { this.transform = transform; }

        //zlevel
        private int zLevel;
        public int getZLevel() { return this.zLevel; }
        public void setZLevel(int zLevel) { this.zLevel = zLevel; }

        //opacity
        private int opacity;
        public int getOpacity() { return this.opacity; }
        public void setOpacity(int opacity) { this.opacity = opacity; }

        private boolean canStuckOnIt;
        public boolean getCanStuckOnIt() { return this.canStuckOnIt; }
        public void setCanStuckOnIt(boolean canStuckOnIt) { this.canStuckOnIt = canStuckOnIt; }

        public WorldObject(int Id, int[] startPosition, double[] Transform, int Zlevel, int Opacity)
        {
            this.id = Id;
            this.position = startPosition;
            this.transform = Transform;
            this.zLevel = Zlevel;
            this.opacity = Opacity;
        }
}
