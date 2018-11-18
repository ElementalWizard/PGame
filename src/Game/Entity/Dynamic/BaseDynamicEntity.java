package Game.Entity.Dynamic;

import Game.Entity.BaseEntity;
import Main.Handler;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BaseDynamicEntity extends BaseEntity {

    private static final float DEFAULT_SPEED = 3.0f;

    float speed;
    float xMove, yMove;
    ArrayList<BaseDynamicEntity> minions;

    protected boolean dead = false;

    BaseDynamicEntity(Handler handler, int x, int y, int widht, int height, BufferedImage sprite) {
        super(handler,x,y,widht,height,sprite);
        speed = DEFAULT_SPEED;
        xMove=0;
        yMove=0;
        if(this instanceof  IInteractable){
            defaultColor = Color.CYAN;
        }else if(this instanceof  IFighter){
            defaultColor = Color.red;
        }

    }

    void move(){
        if(checkEntityCollisions(xMove, 0f))
            moveX();


        if(checkEntityCollisions(0f, yMove))
            moveY();


    }

    private void moveX(){
        if(xMove > 0){//Moving right
            if(handler.getRoom().pointsWirhPlatforms.contains(new Point((int)(x+xMove+width),(int)(y+yMove)))
                    && handler.getRoom().pointsWirhPlatforms.contains(new Point((int)(x+xMove+width),(int)(y +yMove+ height)))){
                x+=xMove;
            }
        }else if(xMove < 0){//Moving left
            if(handler.getRoom().pointsWirhPlatforms.contains(new Point((int)(x+xMove),(int)(y+yMove)))
                    &&handler.getRoom().pointsWirhPlatforms.contains(new Point((int)(x+xMove),(int)(y +yMove+ height)))){
                x+=xMove;
            }
        }
    }

    private void moveY(){
        if(yMove < 0){//Up
            if((handler.getRoom().pointsWirhPlatforms.contains(new Point((int)(x+xMove+width),(int)(y+yMove)))
                    &&handler.getRoom().pointsWirhPlatforms.contains(new Point((int)(x+xMove),(int)(y + yMove))))){
                y+=yMove;
            }
        }
        else if(yMove > 0){//Down
            if(handler.getRoom().pointsWirhPlatforms.contains(new Point((int)(x+xMove+width),(int)(y +yMove+ height)))
                    &&handler.getRoom().pointsWirhPlatforms.contains(new Point((int)(x+xMove),(int)(y+yMove+height)))){
                y+=yMove;
            }
        }
    }

    public void render(Graphics g){
        super.render(g);

    }


    public void setDirection(String tempDirrection) {
        switch (tempDirrection){
            case "Left":
                lookingLeft=true;
                lookingDown=false;
                lookingUp=false;
                lookingRight=false;
                break;
            case "Right":
                lookingLeft=false;
                lookingDown=false;
                lookingUp=false;
                lookingRight=true;
                break;
            case "Down":
                lookingLeft=false;
                lookingDown=true;
                lookingUp=false;
                lookingRight=false;
                break;
            case "Up":
                lookingLeft=false;
                lookingDown=false;
                lookingUp=true;
                lookingRight=false;
                break;
        }
    }

    public void kill() {
        handler.getRoom().getEm().getENTITIES().remove(this);
    }
}
