public class Obstacle {
    private int id;
    private String name;
    private int demage;
    private int health;
    private int award;
    private int orjinalHealth;

    public Obstacle(int id, String name, int demage, int health, int award) {
        this.id = id;
        this.name = name;
        this.demage = demage;
        this.health = health;
        this.orjinalHealth = health;
        this.award = award;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        }else {
            this.health = health;
        }

    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
