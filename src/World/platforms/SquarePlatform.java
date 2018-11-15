package World.platforms;

import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SquarePlatform extends BasePlatform {

    int width;
    int heigh;


    public SquarePlatform(Handler handler, int x, int y, BufferedImage image, int width, int height) {
        super(handler, x, y,image);
        this.heigh =height;
        this.width = width;
    }
    public SquarePlatform(Handler handler, int x, int y, Color color, int width, int height) {
        super(handler, x, y,color);
        this.heigh =height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigh() {
        return heigh;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }
}
