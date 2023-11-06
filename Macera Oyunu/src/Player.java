import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String charName;
    private String name;
    private Scanner inp = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("-------------------------------------------------------------------------------");
        for(GameChar gameChar : charList){
            System.out.println("Id : " + gameChar.getId() +
                    " Karakter : " + gameChar.getName() +
                    "\t\t Hasar : " + gameChar.getDamage() +
                    "\t\t Sağlık : " + gameChar.getHealth() +
                    "\t\t Para :" + gameChar.getMoney());
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("Lutfen bir Karakter Seciniz :");
        byte selectChar = inp.nextByte();

        switch (selectChar){
            case 1:
                initPlayer(charList[0]); // Samuray
                break;
            case 2:
                initPlayer(charList[1]); // Okcu
                break;
            case 3:
                initPlayer(charList[2]); // Sovalye
                break;
            default:
                initPlayer(charList[0]); // Samuray
        }

        System.out.println("Karakter => " + this.getCharName() +
                ", Hasar : " + getDamage() +
                ", Sağlik : " + getHealth() +
                ", Para : " + getMoney());
    }

    private void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println(
                "Silah : " + this.getInventory().getWeapon().getName() +
                " , Zirh : " + this.getInventory().getArmor().getName() +
                " , Blocklama : " + this.getInventory().getArmor().getBlock() +
                " , Hasariniz : " + this.getDamage() +
                " , Sağlik : " + this.getHealth() +
                " , Para : " + this.getMoney());
    }

    public void selectLoc(){

    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamge();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 ) {
            this.health = 0;
        }else {
            this.health = health;
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
            this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
