package World;

import Game.Entity.Dynamic.Player;
import Game.Entity.Dynamic.Slime;
import Main.Handler;
import World.platforms.SquarePlatform;

import java.awt.*;

public class StartingRoom extends BaseRoom {


    public StartingRoom(Handler handler, Player player) {
        super(handler,player);
        platforms.add(new SquarePlatform(handler,0,0,Color.BLUE,500,500));
        platforms.add(new SquarePlatform(handler,532,280,Color.LIGHT_GRAY,350,350));
        platforms.add(new SquarePlatform(handler,450,350,Color.darkGray,125,250));
        getPointsWirhPlatforms();
        getEm().addEntity(new Slime(handler,64,64,32,32,null));
    }



}
