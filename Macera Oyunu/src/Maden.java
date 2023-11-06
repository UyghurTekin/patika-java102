public class Maden extends BattleLoc {
    public Maden(Player player) {
        super(player, "Maden", new Snake(rnd.nextInt(3,6)) , "Sans", 5);
    }
}
