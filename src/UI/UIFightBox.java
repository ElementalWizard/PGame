package UI;

import Game.Entity.Dynamic.Attacks.PhysicalAttack.BaseAttack;
import Game.Entity.Dynamic.Attacks.SpellsAttack.BaseSpell;
import Game.Entity.Dynamic.IFighter;
import Game.Entity.Dynamic.Items.BaseItem;
import Game.GameStates.FightState;
import Main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UIFightBox extends UIObject {

    private FightState state;
    private Color color;
    private Handler handler;
    private int highlighted=0;
    private int counter = 0;
    private boolean enteredSelection = false;
    private int enteredHighlighted=0;
    private boolean selectedAction = false;
    private int selections = 4;


    public UIFightBox(Handler handler, float x, float y, int width, int height, Color backGround, FightState state) {
        super(x, y, width, height);
        this.handler=handler;
        color=backGround;
        this.state = state;

    }

    @Override
    public void tick() {

        if(!enteredSelection) {
            if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN) || handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
                if (highlighted == 3) {
                    highlighted = 0;
                } else {
                    highlighted++;
                }
            }
            if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP) || handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
                if (highlighted == 0) {
                    highlighted = 3;
                } else {
                    highlighted--;
                }
            }
            if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)) {
                enteredSelection = true;
            }
        }
        else{
            if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN) || handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
                if (enteredHighlighted == selections-1) {
                    enteredHighlighted = 0;
                } else {
                    enteredHighlighted++;
                }
            }
            if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP) || handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
                if (enteredHighlighted == 0) {
                    enteredHighlighted = selections-1;
                } else {
                    enteredHighlighted--;
                }
            }
            if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)) {
                selectedAction = true;
            }
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)&&enteredSelection){
            enteredSelection = false;
            enteredHighlighted=0;
        }



        if(counter>=20){
            counter=0;
        }else {
            counter++;
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int) x, (int) y,width,heith);
        g.setColor(Color.lightGray);
        g.fillRect(20,handler.getHeight()-124,handler.getWidth()/7,94);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Verdana", Font.ITALIC, 16));
        g.drawString("Attack",25,handler.getHeight()-104);
        g.drawString("Magic",25,handler.getHeight()-82);
        g.drawString("Item",25,handler.getHeight()-60);
        g.drawString("Run",25,handler.getHeight()-38);
        g.setColor(Color.YELLOW);
        if(!enteredSelection) {
            g.drawString(state.getPlayer().name,40+(handler.getWidth()/7),handler.getHeight()-104);
            g.drawString(" HP: "+ String.valueOf(state.getPlayer().getHealth()),40+(handler.getWidth()/7),handler.getHeight()-82);
            g.drawString(" Mana: "+ String.valueOf(state.getPlayer().getMana()),40+(handler.getWidth()/7),handler.getHeight()-60);
            g.drawString(" Level: "+ String.valueOf(state.getPlayer().getLevel()),40+(handler.getWidth()/7),handler.getHeight()-38);

            g.drawString(state.getEnemy().name + " HP: " + ((IFighter)state.getEnemy()).getHealth(),140+(handler.getWidth()/7),handler.getHeight()-104);
            g.drawString(state.getEnemy().name + " Level: " + ((IFighter)state.getEnemy()).getLevel(),140+(handler.getWidth()/7),handler.getHeight()-82);

            drawArrow(g,4);
        }else{
            g.setColor(Color.lightGray);
            g.fillRect(30+(handler.getWidth()/7),handler.getHeight()-124,(5*handler.getWidth()/7)+45,94);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Verdana", Font.ITALIC, 16));
            int Thingsdisplayed =0;
            switch (highlighted) {
                case 0://attack
                    if(state.getPlayer().getAttackList().size()==0){
                        g.drawString("No Attacks available.",40+(handler.getWidth()/7),handler.getHeight()-104);
                        break;
                    }
                    g.drawString(state.getPlayer().getAttackList().get(enteredHighlighted).getDescription(),380,handler.getHeight()-104);
                    selections=state.getPlayer().getAttackList().size();
                    drawArrow(g,selections);
                    for(BaseAttack attack:state.getPlayer().getAttackList()){
                        if(Thingsdisplayed<2){
                            g.drawString(attack.getName(),40+(handler.getWidth()/7),(Thingsdisplayed*33)+handler.getHeight()-82);
                        }else{
                            g.drawString(attack.getName(),140+(handler.getWidth()/7),((Thingsdisplayed-2)*33)+handler.getHeight()-82);
                        }
                        if(Thingsdisplayed<4){
                            Thingsdisplayed++;
                        }else{
                            Thingsdisplayed =0;
                        }
                    }
                    break;
                case 1://magic
                    if(state.getPlayer().getSpellList().size()==0){
                        g.drawString("No Spells available.",40+(handler.getWidth()/7),handler.getHeight()-104);
                        break;
                    }
                    g.drawString(state.getPlayer().getSpellList().get(enteredHighlighted).getDescription(),380,handler.getHeight()-104);
                    selections= state.getPlayer().getSpellList().size();
                    drawArrow(g,selections);
                    for(BaseSpell spell:state.getPlayer().getSpellList()){
                        if(Thingsdisplayed<2){
                            g.drawString(spell.getName(),40+(handler.getWidth()/7),(Thingsdisplayed*33)+handler.getHeight()-82);
                        }else{
                            g.drawString(spell.getName(),140+(handler.getWidth()/7),((Thingsdisplayed-2)*33)+handler.getHeight()-82);
                        }
                        if(Thingsdisplayed<4){
                            Thingsdisplayed++;
                        }else{
                            Thingsdisplayed =0;
                        }
                    }
                    break;
                case 2://item
                    if(state.getPlayer().getITEMLIST().size()==0){
                        g.drawString("No Items available.",40+(handler.getWidth()/7),handler.getHeight()-104);

                        break;
                    }
                    selections =state.getPlayer().getITEMLIST().size();
                    drawArrow(g,selections);
                    g.drawString(state.getPlayer().getITEMLIST().get(enteredHighlighted).getDescription(),380,handler.getHeight()-104);
                    for(BaseItem item:state.getPlayer().getITEMLIST()){
                        if(Thingsdisplayed<2){
                            g.drawString(item.getName(),40+(handler.getWidth()/7),(Thingsdisplayed*33)+handler.getHeight()-82);
                        }else{
                            g.drawString(item.getName(),140+(handler.getWidth()/7),((Thingsdisplayed-2)*33)+handler.getHeight()-82);
                        }
                        if(Thingsdisplayed<4){
                            Thingsdisplayed++;
                        }else{
                            Thingsdisplayed =0;
                        }
                    }
                    break;
                case 3://run
                    state.leaveFight();
                    break;
            }
        }




    }

    private void drawArrow(Graphics g, int Selections){
        if(!enteredSelection) {
            switch (highlighted) {
                case 0:
                    if (counter <= 10) {
                        g.fillPolygon(new int[]{90, 110, 110}, new int[]{handler.getHeight() - 109, handler.getHeight() - 103, handler.getHeight() - 115}, 3);
                    }
                    break;
                case 1:
                    if (counter <= 10) {
                        g.fillPolygon(new int[]{90, 110, 110}, new int[]{handler.getHeight() - (87), handler.getHeight() - (81), handler.getHeight() - (93)}, 3);
                    }
                    break;
                case 2:
                    if (counter <= 10) {
                        g.fillPolygon(new int[]{90, 110, 110}, new int[]{handler.getHeight() - (65), handler.getHeight() - (59), handler.getHeight() - (71)}, 3);
                    }
                    break;
                case 3:
                    if (counter <= 10) {
                        g.fillPolygon(new int[]{90, 110, 110}, new int[]{handler.getHeight() - (43), handler.getHeight() - (37), handler.getHeight() - (49)}, 3);
                    }
                    break;
            }
        }else{
            switch (enteredHighlighted) {
                case 0:
                    if(Selections<=0){
                        break;
                    }
                    if (counter <= 10) {
                        g.fillPolygon(new int[]{100+(handler.getWidth()/7), 120+(handler.getWidth()/7), 120+(handler.getWidth()/7)}, new int[]{handler.getHeight() - 89, handler.getHeight() - 83, handler.getHeight() - 95}, 3);
                    }
                    break;
                case 1:
                    if(Selections<=1){
                        break;
                    }
                    if (counter <= 10) {
                        g.fillPolygon(new int[]{100+(handler.getWidth()/7), 120+(handler.getWidth()/7), 120+(handler.getWidth()/7)}, new int[]{33+handler.getHeight() - 89, 33+handler.getHeight() - 83, 33+handler.getHeight() - 95}, 3);
                    }
                    break;
                case 2:
                    if(Selections<=2){
                        break;
                    }
                    if (counter <= 10) {
                        g.fillPolygon(new int[]{200+(handler.getWidth()/7), 220+(handler.getWidth()/7), 220+(handler.getWidth()/7)},  new int[]{handler.getHeight() - 89, handler.getHeight() - 83, handler.getHeight() - 95}, 3);
                    }
                    break;
                case 3:
                    if(Selections<=3){
                        break;
                    }
                    if (counter <= 10) {
                        g.fillPolygon(new int[]{200+(handler.getWidth()/7), 220+(handler.getWidth()/7), 220+(handler.getWidth()/7)}, new int[]{33+handler.getHeight() - 89, 33+handler.getHeight() - 83, 33+handler.getHeight() - 95}, 3);
                    }
                    break;
            }
        }
    }

    @Override
    public void onClick() {

    }
}
