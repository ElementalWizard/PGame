package Game.GameStates;

import Game.Entity.Dynamic.Player;
import Game.Entity.EntityManager;
import Main.Handler;
import World.BaseRoom;
import World.StartingRoom;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class GameState extends State {

    public GameState(Handler handler){
        super(handler);
        Player player = new Player(handler,100,100,32,32,null);
        StartingRoom FirstRoom = new StartingRoom(handler,player);
        handler.setRoom(FirstRoom);
        FirstRoom.getPointsWirhPlatforms();

    }


    @Override
    public void tick() {

        handler.getRoom().tick();

    }

    @Override
    public void render(Graphics g) {

        handler.getRoom().render(g);

    }

}
