package Game.Entity.Dynamic;

import Game.Entity.BaseEntity;
import Game.Entity.Dynamic.Attacks.PhysicalAttack.BaseAttack;
import Game.Entity.Dynamic.Attacks.SpellsAttack.BaseSpell;
import Main.Handler;
import World.platforms.BasePlatform;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends BaseDynamicEntity implements IFighter {


    private int health = 100;
    private int attack = 100;
    private int defence = 100;
    private int magic = 100;
    private int magicDefence = 100;

    private int level = 1;
    private float EXP = 0;
    private float maxEXP = 100;

    private boolean fighting = false;


    private ArrayList<BaseAttack> BASE_ATTACK_LIST = new ArrayList<>();
    private ArrayList<BaseSpell> BASE_SPELL_LIST = new ArrayList<>();



    public Player(Handler handler,int x,int y,int widht,int height, BufferedImage sprite) {
        super(handler,x,y,widht,height,sprite);

        bounds.x=8*2;
        bounds.y=18*2;
        bounds.width=16*2;
        bounds.height=14*2;


    }


    @Override
    public void tick() {
        super.tick();

        getInput();
        move();

    }

    @Override
    public void render(Graphics g) {
        super.render(g);


    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up &&! fighting)
            yMove = -speed;
        if(handler.getKeyManager().down&&! fighting)
            yMove = speed;
        if(handler.getKeyManager().left&&! fighting)
            xMove = -speed;
        if(handler.getKeyManager().right&&! fighting)
            xMove = speed;
    }


    @Override
    public void LevelUp(int incAttack,int incDefence,int incMagic,int incMagicDefence,float newEXPMax){
        level++;
        attack+=incAttack;
        defence+=incDefence;
        magic+=incMagic;
        magicDefence+=incMagicDefence;
        maxEXP=newEXPMax;
        EXP=0;
    }


    //Getters and setters
    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefence() {
        return defence;
    }

    @Override
    public int getMagic() {
        return magic;
    }

    @Override
    public int getMagicDefence() {
        return magicDefence;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public float getEXP() {
        return EXP;
    }

    public float getMaxEXP() {
        return maxEXP;
    }


    @Override
    public ArrayList<BaseAttack> getAttackList() {
        return BASE_ATTACK_LIST;
    }

    @Override
    public ArrayList<BaseSpell> getSpellList() {
        return BASE_SPELL_LIST;
    }

    @Override
    public void setHealth(int Health) {

        health = Health;

    }

    @Override
    public void setAttack(int Attack) {

        attack=Attack;

    }

    @Override
    public void setDefence(int Defence) {

        defence=Defence;

    }

    @Override
    public void setMagic(int Magic) {

        magic=Magic;

    }

    @Override
    public void setMagicDefence(int Mdefence) {

        magicDefence=Mdefence;

    }

    @Override
    public void setLevel(int Level) {

        level = Level;

    }

    @Override
    public void setEXP(float EXP) {

        this.EXP = EXP;

    }

    public void setMaxEXP(float maxEXP) {
        this.maxEXP = maxEXP;
    }

    @Override
    public void setAttackList(ArrayList<BaseAttack> BaseAttackList) {

        BASE_ATTACK_LIST = BaseAttackList;

    }

    @Override
    public void setSpellList(ArrayList<BaseSpell> BaseSpellList) {

        BASE_SPELL_LIST = BaseSpellList;

    }
}
