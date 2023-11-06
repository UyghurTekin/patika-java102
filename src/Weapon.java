public class Weapon {
    private String name;
    private int id;
    private int damge;
    private int price;

    public Weapon(String name, int id, int damge, int price) {
        this.name = name;
        this.id = id;
        this.damge = damge;
        this.price = price;
    }

    public static Weapon[] weapons(){
        Weapon[] weaponlist = new Weapon[3];
        weaponlist[0] = new Weapon("Tabanca", 1, 2, 5);
        weaponlist[1] = new Weapon("Kilic", 2, 3, 35);
        weaponlist[2] = new Weapon("Tüfek", 3, 7, 45);
        return weaponlist;
    }

    public static Weapon getWeaponObjById(int id){
        for (Weapon w: weapons() ){
            if (w.getId() == id){
                return w;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamge() {
        return damge;
    }

    public void setDamge(int damge) {
        this.damge = damge;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
