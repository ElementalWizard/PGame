package Game.Entity;

import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BaseEntity {

    protected Handler handler;

    protected int x,y;
    protected BufferedImage sprite = null;
    public Rectangle bounds;

    protected int width, height;

    public static final int DEFAULT_WIDTH =  32;
    public static final int DEFAULT_HEIGHT =  32;

    public BaseEntity(Handler handler,int x, int y,int width,int height,BufferedImage sprite){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width,height);

    }

    public void tick(){

    }

    public void render(Graphics g){

        if(sprite == null){
            g.setColor(Color.PINK);
            g.fillRect(x,y,DEFAULT_WIDTH,DEFAULT_HEIGHT);
        }



    }

    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(BaseEntity e : handler.getRoom().getEm().getENTITIES()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
                return true;
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
