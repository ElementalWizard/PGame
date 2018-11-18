package World;

import Game.Entity.Dynamic.Player;
import Game.Entity.Dynamic.Slime;
import Game.Entity.Dynamic.Villiger;
import Main.Handler;
import Resources.GameCamera;
import World.platforms.SquarePlatform;

import java.awt.*;
import java.util.ArrayList;

public class StartingRoom extends BaseRoom {


    public StartingRoom(Handler handler, Player player) {
        super(handler,player);

        ArrayList<String> kyleDialogue = new ArrayList<>();
        kyleDialogue.add("Hello there, Im Kyle");
        kyleDialogue.add("Have a nice day.");
        roomName="Starting Room";

        cam = new GameCamera(handler,1500,1500,800,800);
        platforms.add(new SquarePlatform(handler,0,0,Color.BLUE,500,500));
        platforms.add(new SquarePlatform(handler,532,280,Color.LIGHT_GRAY,350,350));
        platforms.add(new SquarePlatform(handler,450,350,Color.darkGray,125,250));
        getEm().addEntity(new Slime(handler,64,64,32,32,null));
        getEm().addEntity(new Villiger(handler,164,164,32,32,null,Color.darkGray,Color.lightGray,"Kyle", kyleDialogue));

    }



}
