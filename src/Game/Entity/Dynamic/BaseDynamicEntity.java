package Game.Entity.Dynamic;

import Game.Entity.BaseEntity;
import Main.Handler;
import World.platforms.BasePlatform;
import World.platforms.SquarePlatform;
import World.platforms.TransitionPlatform;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BaseDynamicEntity extends BaseEntity {

    protected static final float DEFAULT_SPEED = 3.0f;

    protected float speed;
    protected float xMove, yMove;

    protected boolean dead = false;

    public BaseDynamicEntity(Handler handler,int x,int y,int widht,int height, BufferedImage sprite) {
        super(handler,x,y,widht,height,sprite);
        speed = DEFAULT_SPEED;
        xMove=0;
        yMove=0;

    }

    public void move(){
        if(!checkEntityCollisions(xMove, 0f))
            moveX();

        if(!checkEntityCollisions(0f, yMove))
            moveY();

    }

    public void moveX(){
        if(xMove > 0){//Moving right

            for (BasePlatform platfomr:handler.getRoom().platforms) {
                if(platfomr instanceof TransitionPlatform) {

                    if((x+xMove>platfomr.getX()&&x+xMove<platfomr.getX()+((TransitionPlatform) platfomr).getWidth())
                            &&(y>platfomr.getY()&&y<platfomr.getY()+((TransitionPlatform) platfomr).getHeigh())) {
                        if (x + xMove + width >= platfomr.getX() + ((TransitionPlatform) platfomr).getWidth()) {
                            x--;
                        } else {
                            x += xMove;
                        }
                    }

                }else if(platfomr instanceof SquarePlatform) {

                        if((x+xMove>platfomr.getX()&&x+xMove<platfomr.getX()+((SquarePlatform) platfomr).getWidth())
                        &&(y>platfomr.getY()&&y<platfomr.getY()+((SquarePlatform) platfomr).getHeigh())) {
                            if (x + xMove + width >= platfomr.getX() + ((SquarePlatform) platfomr).getWidth()) {
                                x--;
                            } else {
                                x += xMove;
                            }
                        }

                }
            }



        }else if(xMove < 0){//Moving left
            for (BasePlatform platfomr:handler.getRoom().platforms) {
                if(platfomr instanceof TransitionPlatform) {

                    if((x+xMove>platfomr.getX()&&x+xMove<platfomr.getX()+((TransitionPlatform) platfomr).getWidth())
                            &&(y>platfomr.getY()&&y<platfomr.getY()+((TransitionPlatform) platfomr).getHeigh())) {
                        if (x + xMove <= platfomr.getX()) {
                            x--;
                        } else {
                            x += xMove;
                        }
                    }

                }else if(platfomr instanceof SquarePlatform) {

                        if((x+xMove>platfomr.getX()&&x+xMove<platfomr.getX()+((SquarePlatform) platfomr).getWidth())
                                &&(y>platfomr.getY()&&y<platfomr.getY()+((SquarePlatform) platfomr).getHeigh())) {
                            if (x + xMove <= platfomr.getX()) {
                                x--;
                            } else {
                                x += xMove;
                            }
                        }

                }
            }
        }
    }

    public void moveY(){
        if(yMove < 0){//Up
            for (BasePlatform platfomr:handler.getRoom().platforms) {
                if(platfomr instanceof TransitionPlatform) {


                    if((x>platfomr.getX()&&x<platfomr.getX()+((TransitionPlatform) platfomr).getWidth())
                            &&(y+yMove>platfomr.getY()&&y+yMove<platfomr.getY()+((TransitionPlatform) platfomr).getHeigh())) {
                        if (y + yMove <= platfomr.getY()) {
                            y++;
                        }else{
                            y += yMove;
                        }
                    }
                }else if(platfomr instanceof SquarePlatform) {


                        if((x>platfomr.getX()&&x<platfomr.getX()+((SquarePlatform) platfomr).getWidth())
                                &&(y+yMove>platfomr.getY()&&y+yMove<platfomr.getY()+((SquarePlatform) platfomr).getHeigh())) {
                            if (y + yMove <= platfomr.getY()) {
                                y++;
                            }else{
                                y += yMove;
                            }
                        }
                    }
                }
            }
        else if(yMove > 0){//Down
            for (BasePlatform platfomr:handler.getRoom().platforms) {
                if(platfomr instanceof TransitionPlatform) {
                    if((x>platfomr.getX()&&x<platfomr.getX()+((TransitionPlatform) platfomr).getWidth())
                            &&(y+yMove>platfomr.getY()&&y+yMove<platfomr.getY()+((TransitionPlatform) platfomr).getHeigh())) {
                        if (y + yMove + height >= platfomr.getY() + ((TransitionPlatform) platfomr).getHeigh()) {
                            y--;
                        }else{
                            y += yMove;
                        }
                    }
                }
                else if(platfomr instanceof SquarePlatform) {

                        if((x>platfomr.getX()&&x<platfomr.getX()+((SquarePlatform) platfomr).getWidth())
                                &&(y+yMove>platfomr.getY()&&y+yMove<platfomr.getY()+((SquarePlatform) platfomr).getHeigh())) {
                            if (y + yMove + height >= platfomr.getY() + ((SquarePlatform) platfomr).getHeigh()) {
                                y--;
                            }else{
                                y += yMove;
                            }
                        }
                    }

                }
            }


    }



}
