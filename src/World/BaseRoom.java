package World;

import Game.Entity.BaseEntity;
import Game.Entity.Dynamic.Player;
import Game.Entity.EntityManager;
import Main.Handler;
import World.platforms.BasePlatform;
import World.platforms.SquarePlatform;

import java.awt.*;
import java.util.ArrayList;

public class BaseRoom {

    private Handler handler;
    public ArrayList<BasePlatform> platforms = new ArrayList<>();
    private EntityManager em;


    public BaseRoom(Handler handler, Player player){
        this.handler = handler;
        em = new EntityManager();
        em.setPlayer(player);
    }


    public void tick(){
        for (BasePlatform platform: platforms) {
            platform.tick();
        }
        for (BaseEntity entity:em.getENTITIES()) {
            entity.tick();

        }
    }


    public void render(Graphics g){

        for (BasePlatform platform: platforms) {
            platform.render(g);
        }
        for (BaseEntity entity:em.getENTITIES()) {
            entity.render(g);

        }
    }


    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }


}
