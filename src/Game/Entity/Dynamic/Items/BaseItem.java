package Game.Entity.Dynamic.Items;

public class BaseItem {

    private String name;
    private int powerIncrese;
    private int defenseIncrese;
    private int magicIncrese;
    private int magicDefenceIncrese;
    private int heal;
    private String type;
    private String description;

    private BaseItem(String name, int powerIncrese, int defenseIncrese, int magicIncrese, int magicDefenceIncrese, int heal, String type, String description) {
        this.name = name;
        this.powerIncrese = powerIncrese;
        this.defenseIncrese = defenseIncrese;
        this.magicIncrese = magicIncrese;
        this.magicDefenceIncrese = magicDefenceIncrese;
        this.heal = heal;
        this.type = type;
        this.description = description;
    }

    public static BaseItem potion = new BaseItem("Health Potion",0,0,0,0,10,ItemType.HEALING,"Heals 10 HP.");


    public String getName() {
        return name;
    }

    public int getPowerIncrese() {
        return powerIncrese;
    }

    public int getDefenseIncrese() {
        return defenseIncrese;
    }

    public int getMagicIncrese() {
        return magicIncrese;
    }

    public int getMagicDefenceIncrese() {
        return magicDefenceIncrese;
    }

    public int getHeal() {
        return heal;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
