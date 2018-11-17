package World;

import Game.Entity.BaseEntity;
import Game.Entity.Dynamic.Player;
import Game.Entity.EntityManager;
import Main.Handler;
import Resources.GameCamera;
import World.platforms.BasePlatform;
import World.platforms.SquarePlatform;
import java.awt.*;
import java.util.ArrayList;

public class BaseRoom {

    private Handler handler;
    ArrayList<BasePlatform> platforms = new ArrayList<>();
    private EntityManager em;

    protected GameCamera cam;
    public ArrayList<Point> pointsWirhPlatforms = new ArrayList<>();

    BaseRoom(Handler handler, Player player){
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
        cam.tick();
    }


    public void render(Graphics g){
        g.translate(-cam.getCamX(), -cam.getCamY());

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


    public void getPointsWirhPlatforms(){

        for (BasePlatform platform:platforms) {
            if(platform instanceof  SquarePlatform) {
                for (int x = platform.getX(); x <= platform.getX() + ((SquarePlatform) platform).getWidth(); x++) {
                    for (int y = platform.getY(); y <= platform.getY() + ((SquarePlatform) platform).getHeigh(); y++) {
                        pointsWirhPlatforms.add(new Point(x,y));
                    }
                }
            }
        }

    }

}
