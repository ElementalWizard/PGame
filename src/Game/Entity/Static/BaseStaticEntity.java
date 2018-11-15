package Game.Entity.Static;

import Game.Entity.BaseEntity;
import Main.Handler;

import java.awt.image.BufferedImage;

public class BaseStaticEntity extends BaseEntity {

    public BaseStaticEntity(Handler handler,int x, int y,int widht,int height, BufferedImage sprite) {
        super(handler,x,y,widht,height,sprite);

    }
}
