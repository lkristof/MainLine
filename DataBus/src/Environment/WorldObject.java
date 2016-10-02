package Environment;
import java.lang.*;

import java.util.ResourceBundle;

/**
 * Created by Akos on 2016. 09. 27..
 */
 public class WorldObject {

        //id
        private int id;
        public int getId() { return this.id; }
        public void setId(int id) { this.id = id; }
/*
        //name
        private String name;
        public String getName() { return this.name; }
        public void setName(String name) { this.name = name; }

        //type
        private int type;
        public int getType() { return this.type; }
        public void setType(int type) { this.type = type; }
*/
        //position
        private Position position;
        public Position getPosition() { return this.position; }
        public void setPosition(Position position) { this.position = position; }

        //transform
        private int[] transform;
        public int[] getTransform() { return this.transform; }
        public void setTransform(int[] transform) { this.transform = transform; }

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

        public WorldObject(int Id, Position startPosition, int[] Transform, int Zlevel, int Opacity)
        {
            this.id = Id;
            this.position = startPosition;
            this.transform = Transform;
            this.zLevel = Zlevel;
            this.opacity = Opacity;
        }
}
