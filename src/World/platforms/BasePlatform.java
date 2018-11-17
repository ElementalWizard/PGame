package World.platforms;

import Main.Handler;
import World.BaseRoom;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;

public class BasePlatform {


    Handler handler;
    private int x,y;
    private BufferedImage image = null;
    private Color color = null;

    BasePlatform(Handler handler, int x, int y, BufferedImage image){
        this.handler = handler;
        this.x=x;
        this.y=y;
        this.image = image;
    }

    BasePlatform(Handler handler, int x, int y, Color color){
        this.handler = handler;
        this.x=x;
        this.y=y;
        this.color = color;
    }

    public void tick(){

    }

    public void render(Graphics g){
        if(this instanceof SquarePlatform) {
            if (this.getImage() == null) {
                g.setColor(this.getColor());
                g.fillRect(this.getX(), this.getY(), ((SquarePlatform) this).getWidth(), ((SquarePlatform) this).getHeigh());
            } else {
                g.drawImage(this.getImage(), this.getX(), this.getY(), ((SquarePlatform) this).getWidth(), ((SquarePlatform) this).getHeigh(), null);
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
