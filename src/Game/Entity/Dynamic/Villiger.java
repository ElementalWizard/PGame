package Game.Entity.Dynamic;

import Main.Handler;
import UI.UIDialogueBox;
import javafx.scene.input.KeyCode;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Villiger extends BaseDynamicEntity implements IInteractable {

    String name;
    ArrayList<String> Dialogue;
    public boolean Interacting = false;
    Handler handler;

    UIDialogueBox box;

    public Villiger(Handler handler,int x,int y,int widht,int height, BufferedImage sprite,Color Background,Color ForeGround,String name,ArrayList<String> Dialogue){
        super(handler,x,y,widht,height,sprite);
        box = new UIDialogueBox(10,handler.getHeight()-74,handler.getWidth()-20,64,Background,ForeGround,name,Dialogue);
        this.handler = handler;
        this.name = name;
        this.Dialogue = Dialogue;
        bounds.x=8*2;
        bounds.y=18*2;
        bounds.width=16*2;
        bounds.height=14*2;

    }

    public void tick(){
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E) && Interacting){
            box.nextDialogue();
        }
        box.tick();
    }

    public void render(Graphics g){
        super.render(g);
        if(Interacting){
            box.render(g);
        }
    }

    @Override
    public void interact(Graphics g) {
        Interacting = true;

    }

    @Override
    public void endInteraction() {
        Interacting = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<String> getDialogue() {
        return Dialogue;
    }
}
