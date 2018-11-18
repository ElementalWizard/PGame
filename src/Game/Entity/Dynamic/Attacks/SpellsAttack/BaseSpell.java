package Game.Entity.Dynamic.Attacks.SpellsAttack;

import Game.Entity.Dynamic.Attacks.PhysicalAttack.BaseAttack;
import Game.Entity.Dynamic.Attacks.PhysicalAttack.PhisicalType;

public class BaseSpell {

    private String name;
    private int power;
    private String type;
    private String description;

    private BaseSpell(String name, int power, String type, String description) {
        this.name = name;
        this.power = power;
        this.type = type;
        this.description = description;
    }

    public static BaseSpell FireBall = new BaseSpell("Fire Ball",3, MagicalType.FIRE,"Burn Baby Burn");
    public static BaseSpell EarthShock = new BaseSpell("Earth Shock",3,MagicalType.EARTH,"Shakes the earth");
    public static BaseSpell AirSlash = new BaseSpell("Air Slash",3,MagicalType.AIR,"Like a paper cut, but worst");
    public static BaseSpell WaterPrisson = new BaseSpell("Water Prisson",3,MagicalType.WATER,"A soothing, peaceful, choke");


    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
