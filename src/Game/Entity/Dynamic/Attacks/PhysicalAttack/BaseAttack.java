package Game.Entity.Dynamic.Attacks.PhysicalAttack;

public class BaseAttack {

    private String name;
    private int power;
    private String type;
    private String description;

    private BaseAttack(String name, int power, String type, String description) {
        this.name = name;
        this.power = power;
        this.type = type;
        this.description = description;
    }

    public static BaseAttack Punch = new BaseAttack("Punch",3,PhisicalType.BLUNT,"A Punch where it hurts.");
    public static BaseAttack Kick = new BaseAttack("Kick",3,PhisicalType.SHARP,"A Kick where it does not shine.");
    public static BaseAttack Slam = new BaseAttack("Slam",5,PhisicalType.HEAVY,"Like a toss, but of yourself...");


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
