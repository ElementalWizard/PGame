package Game.Entity.Dynamic;

import Game.Entity.BaseEntity;
import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Slime extends BaseDynamicEntity {
    public Slime(Handler handler,int x,int y,int widht,int height, BufferedImage sprite) {
        super(handler,x,y,widht,height,sprite);

        bounds.x=8*2;
        bounds.y=18*2;
        bounds.width=16*2;
        bounds.height=14*2;
    }
}
