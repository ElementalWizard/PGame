package Game.GameStates;

import Game.Entity.Dynamic.BaseDynamicEntity;
import Game.Entity.Dynamic.Player;
import Main.Handler;
import World.platforms.BasePlatform;
import World.platforms.SquarePlatform;
import sun.plugin.services.PlatformService;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FightState extends State {

    private ArrayList<BaseDynamicEntity> entities;
    private Handler handler;
    private int tempX,tempY;
    private String tempDirrection;
    private Player player;
    private BasePlatform platform;
    private BaseDynamicEntity enemy;
    private int EtempX,EtempY;
    private String EtempDirrection;


    public FightState(Handler handler, ArrayList<BaseDynamicEntity> Entities,BaseDynamicEntity entity, Player player) {
        super(handler);
        entities=Entities;
        this.handler = handler;
        tempX=player.getX();
        tempY=player.getY();
        tempDirrection = player.getDirectionLooking();
        player.setX(((handler.getWidth() / 2) - 300) + (120));
        player.setY(((handler.getHeight() / 2)));
        this.player = player;
        player.setDirection("Right");
        player.setFighting(true);
        platform =handler.getRoom().getPlatforms().get(new Random().nextInt(handler.getRoom().getPlatforms().size()));

        enemy=entity;
        EtempX=enemy.getX();
        EtempY=enemy.getY();
        EtempDirrection=enemy.getDirectionLooking();
        enemy.setDirection("Left");
        enemy.setX(((handler.getWidth() / 2) + 300) - (120));
        enemy.setY(((handler.getHeight() / 2)));

    }


    @Override
    public void tick() {
        player.tick();
        enemy.tick();
    }

    @Override
    public void render(Graphics g) {

        switch (handler.getRoom().getRoomName()){

            case "Starting Room":
                if(platform.getImage()==null){
                    g.setColor(platform.getColor());
                    g.fillRect((handler.getWidth()/2)-300,(handler.getHeight()/2)-200,600,400);

                }else{
                    g.drawImage(platform.getImage(),(handler.getWidth()/2)-300,(handler.getHeight()/2)-200,600,400,null);
                }
                break;
        }
        player.render(g);
        enemy.render(g);

    }

    public void leaveFight(){
        player.setX(tempX);
        player.setY(tempY);
        player.setDirection(tempDirrection);
        player.setFighting(false);
        enemy.kill();
        State.setState(handler.getGame().gameState);
    }
}
