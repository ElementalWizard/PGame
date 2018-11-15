package Main;

import Input.KeyManager;
import Input.MouseManager;
import Resources.MusicHandler;


/**
 * Created by AlexVR on 7/1/2018.
 */

public class Handler {

    private GameSetUp game;

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


}
