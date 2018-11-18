package Game.Entity.Dynamic;

import Game.Entity.BaseEntity;
import Main.Handler;
import UI.UIDialogueBox;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Villiger extends BaseDynamicEntity implements IInteractable {

    private String name;
    private ArrayList<String> Dialogue;
    private boolean Interacting = false;
    private Handler handler;

    private UIDialogueBox box;

    public static ArrayList<String> kyleDialogue = new ArrayList<>();


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
        kyleDialogue.add("Hello there, Im Kyle");
        kyleDialogue.add("Please get rid of that red thing over there.");
        kyleDialogue.add("Oh, you did, Why Thanks!!");

    }

    public void tick(){
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E) && Interacting){
            if(name.equals("Kyle")&& box.dialogueIndex==1) {
                boolean found = false;
                for(BaseEntity entity: handler.getRoom().getEm().getENTITIES()){
                    if(entity instanceof Slime){
                        found = true;
                    }
                }
                if(!found) {
                    box.nextDialogue();
                }else{
                    box.stopDialogue();
                }
            }else{
                box.nextDialogue();
            }
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
