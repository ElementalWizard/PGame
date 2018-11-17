package Main;

import Input.KeyManager;
import Input.MouseManager;
import Resources.GameCamera;
import Resources.MusicHandler;
import World.BaseRoom;


/**
 * Created by AlexVR on 7/1/2018.
 */

public class Handler {

    private GameSetUp game;
    private BaseRoom room;
    private GameCamera cam;

    public Handler(GameSetUp game){
        this.game = game;
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }


    public GameSetUp getGame() {
        return game;
    }

    public void setGame(GameSetUp game) {
        this.game = game;
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public MusicHandler getMusicManager(){
        return game.getMusicHandler();
    }

    public BaseRoom getRoom(){
        return room;
    }
    public void setRoom(BaseRoom room){
        this.room = room;
    }

    public void setCamera(GameCamera camera){
        cam=camera;
    }
    public GameCamera getCamera(){
        return cam;
    }

}
