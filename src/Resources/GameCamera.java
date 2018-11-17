package Resources;

import Main.Handler;

public class GameCamera {

    int offsetMaxX,offsetMaxY,offsetMinX,offsetMinY,camX,camY,VIEWPORT_SIZE_X,VIEWPORT_SIZE_Y;
    Handler handler;


    public GameCamera(Handler handler, int WORLD_SIZE_X,int WORLD_SIZE_Y,int VIEWPORT_SIZE_X, int VIEWPORT_SIZE_Y ) {
        offsetMaxX = WORLD_SIZE_X - VIEWPORT_SIZE_X;
        offsetMaxY = WORLD_SIZE_Y - VIEWPORT_SIZE_Y;
        offsetMinX = 0;
        offsetMinY = 0;
        this.handler = handler;

        this.VIEWPORT_SIZE_X=VIEWPORT_SIZE_X;
        this.VIEWPORT_SIZE_Y=VIEWPORT_SIZE_Y;
    }

    public void tick(){
        camX = handler.getRoom().getEm().getPlayer().getX() - VIEWPORT_SIZE_X / 2;
        camY = handler.getRoom().getEm().getPlayer().getY() - VIEWPORT_SIZE_Y / 2;
        if (camX > offsetMaxX)
            camX = offsetMaxX;
        else if (camX < offsetMinX)
            camX = offsetMinX;
        if (camY > offsetMaxY)
            camY = offsetMaxY;
        else if (camY < offsetMinY)
            camY = offsetMinY;
    }

    public int getCamX() {
        return camX;
    }

    public void setCamX(int camX) {
        this.camX = camX;
    }

    public int getCamY() {
        return camY;
    }

    public void setCamY(int camY) {
        this.camY = camY;
    }
}
