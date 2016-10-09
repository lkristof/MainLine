package Environment;

/**
 * Created by forii on 2016. 10. 09..
 */
public class Scene {
    private int width;
    private int height;
    private int measureType;
    private String color;

    public Scene(int width, int height, int measureType, String color) {
        this.width = width;
        this.height = height;
        this.measureType = measureType;
        this.color = color;
    }
}
