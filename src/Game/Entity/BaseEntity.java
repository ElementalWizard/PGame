package Game.Entity;

import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BaseEntity {

    protected Handler handler;

    protected int x,y;
    protected BufferedImage sprite = null;
    public Rectangle bounds;

    protected boolean lookingLeft = false,lookingRight = false,lookingUp = false,lookingDown = true;


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
    public Rectangle calculateInteractionRectangle(Graphics g){
        Rectangle interactingRect = new Rectangle(0,0,width,height);
        if(lookingUp){
            interactingRect.x=x;
            interactingRect.y=y-(height/2);
            interactingRect.width=width;
            interactingRect.height=height/2;
        }else if(lookingDown){
            interactingRect.x=x;
            interactingRect.y=y+(height);
            interactingRect.width=width;
            interactingRect.height=height/2;
        }else if(lookingLeft){
            interactingRect.x=x-(width/2);
            interactingRect.y=y;
            interactingRect.width=width/2;
            interactingRect.height=height;
        }else{
            interactingRect.x=x+width;
            interactingRect.y=y;
            interactingRect.width=width/2;
            interactingRect.height=height;
        }

        g.setColor(Color.GREEN);
        g.drawRect(interactingRect.x,interactingRect.y,interactingRect.width,interactingRect.height);
        return interactingRect;
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
