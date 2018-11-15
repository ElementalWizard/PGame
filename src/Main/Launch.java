package Main;


import javafx.application.Application;

/**
 * Created by AlexVR on 7/1/2018.
 */

public class Launch {

    public static void main(String[] args) {
        GameSetUp game = new GameSetUp("BaseGame", 800, 800);
        game.start();
    }
}
