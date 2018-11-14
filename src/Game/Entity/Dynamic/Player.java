package Game.Entity.Dynamic;

import Game.Entity.Dynamic.Attacks.PhysicalAttack.BaseAttack;
import Game.Entity.Dynamic.Attacks.SpellsAttack.BaseSpell;
import Main.Handler;

import java.util.ArrayList;

public class Player extends BaseDynamicEntity implements IFighter {


    private int health = 100;
    private int attack = 100;
    private int defence = 100;
    private int magic = 100;
    private int magicDefence = 100;

    private ArrayList<BaseAttack> BASE_ATTACK_LIST = new ArrayList<>();
    private ArrayList<BaseSpell> BASE_SPELL_LIST = new ArrayList<>();


    public Player(Handler handler) {
        super(handler);
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
    public void setAttackList(ArrayList<BaseAttack> BaseAttackList) {

        BASE_ATTACK_LIST = BaseAttackList;

    }

    @Override
    public void setSpellList(ArrayList<BaseSpell> BaseSpellList) {

        BASE_SPELL_LIST = BaseSpellList;

    }
}