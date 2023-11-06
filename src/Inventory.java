public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private Award[] awards;

    Inventory(){
        this.weapon = new Weapon("Yumruk", -1, 1, 0);
        this.armor = new Armor(-1, "Paçavra", 0, 0);
        this.awards = new Award[]{new Award(), new Award(), new Award(), new Award()};
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }


    public Award[] getAwards() {
        return awards;
    }

    public void setAwards(String award) {
        for (Award a : awards){
            if (a.getName().equals("nane")){
                a.setName(award);
                a.setStaus(true);
                break;
            };
        }
    }
}
