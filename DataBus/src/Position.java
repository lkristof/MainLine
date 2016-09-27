package MainLine.DataBus.src;

/**
 * Created by Akos on 2016. 09. 27..
 */
public class Position {
    private int x;
    public int getX() { return this.x; }
    public void setX(int x) { this.x = x; }

    private int y;
    public int getY() { return this.y; }
    public void setY(int y) { this.y = y; }

    public Position(int X, int Y)
    {
        this.x = X;
        this.y = Y;
    }
}
