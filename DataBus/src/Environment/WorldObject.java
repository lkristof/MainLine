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

        //position
        private int[] position;
        public int[] getPosition() { return this.position; }
        public void setPosition(int[] position) { this.position = position; }

        private int width;
        public int getWidth() { return this.width; }

        private int height;
        public int getHeight() { return this.height; }

        //transform
        private double[] transform;
        public double[] getTransform() { return this.transform; }
        public void setTransform(double[] transform) { this.transform = transform; }

        //zlevel
        private int zLevel;
        public int getZLevel() { return this.zLevel; }

        //opacity
        private int opacity;
        public int getOpacity() { return this.opacity; }

        private boolean canStuckOnIt;
        public boolean getCanStuckOnIt() { return this.canStuckOnIt; }

        public WorldObject(int Id, int[] startPosition, int width, int height, double[] Transform, int Zlevel, int Opacity, boolean CanStuckOnIt)
        {
            this.id = Id;
            this.position = startPosition;
            this.width = width;
            this.height = height;
            this.transform = Transform;
            this.zLevel = Zlevel;
            this.opacity = Opacity;
            this.canStuckOnIt = CanStuckOnIt;
        }
}
