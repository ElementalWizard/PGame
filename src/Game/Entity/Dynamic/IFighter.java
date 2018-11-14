package Game.Entity.Dynamic;

import Game.Entity.Dynamic.Attacks.PhysicalAttack.BaseAttack;
import Game.Entity.Dynamic.Attacks.SpellsAttack.BaseSpell;

import java.util.ArrayList;

public interface IFighter {









    /////GETTERS and SETTERS

    //GETTERS
    int getHealth();
    int getAttack();
    int getDefence();
    int getMagic();
    int getMagicDefence();
    int getLevel();
    float getEXP();
    ArrayList<BaseAttack> getAttackList();
    ArrayList<BaseSpell> getSpellList();

    //SETTERS
    void setHealth(int Health);
    void setAttack(int Attack);
    void setDefence(int Defence);
    void setMagic(int Magic);
    void setMagicDefence(int Mdefence);
    void setLevel(int Level);
    void setEXP(float EXP);
    void setAttackList(ArrayList<BaseAttack> BaseAttackList);
    void setSpellList(ArrayList<BaseSpell> BaseSpellList);

}
