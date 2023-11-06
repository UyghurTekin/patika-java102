public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");

    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz ! \nCaniniz Yenilendi !");

        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
        return true;
    }
}
