package Game.Entity;

import Game.Entity.Dynamic.Player;
import java.util.ArrayList;

public class EntityManager {

    private Player player;
    private ArrayList<BaseEntity> ENTITIES = new ArrayList<>();


    public EntityManager() {

    }

    public void addEntity(BaseEntity entity){
        ENTITIES.add(entity);
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        ENTITIES.add(player);
    }

    public ArrayList<BaseEntity> getENTITIES() {
        return ENTITIES;
    }

    public void setENTITIES(ArrayList<BaseEntity> ENTITIES) {
        this.ENTITIES = ENTITIES;
    }
}
