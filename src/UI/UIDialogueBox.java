package UI;

import java.awt.*;
import java.util.ArrayList;

public class UIDialogueBox extends UIObject {

    private Color background,foreground;
    private String name;
    private ArrayList<String> Dialogue;
    public int dialogueIndex = 0;
    private boolean interacting = true;

    public UIDialogueBox(float x, float y, int width, int height, Color background, Color forground, String name, ArrayList<String> Dialogue) {
        super(x, y, width, height);
        this.background=background;
        this.foreground=forground;
        this.name = name;
        this.Dialogue = Dialogue;
    }

    @Override
    public void tick() {

        if(!interacting){
            dialogueIndex = 0;
        }

    }

    @Override
    public void render(Graphics g) {
        if(dialogueIndex == Dialogue.size()){

            stopDialogue();
        }
        if(interacting) {
            g.setColor(background);
            g.fillRect((int) x, (int) y, width, heith);
            g.setColor(foreground);
            g.fillRect((int) x + 10, (int) y + 10, width - 10, heith - 10);
            g.setColor(Color.BLACK);
            g.drawString(name, (int) x + 15, (int) y + 25);
            g.drawString(Dialogue.get(dialogueIndex), (int) x + 15, (int) y + 45);
        }
    }

    @Override
    public void onClick() {

    }

    public void stopDialogue(){
        interacting = false;
        dialogueIndex = 0;
    }

    public void nextDialogue(){
        if(!interacting){
            interacting=true;
        }else {
            dialogueIndex++;
        }

    }
}
