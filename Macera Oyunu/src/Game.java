import java.util.Scanner;

public class Game {
    private Scanner inp = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Adasina Hoş Geldin !");
        System.out.print("Kendini Adlandir : ");
        String playerName = inp.nextLine().toUpperCase();

        Player player = new Player(playerName);
        Location location = null;

        System.out.println("Sayin " + player.getName() + " Macera Dunyasina Hoş Geldiniz!");
        System.out.println("Lutfen Oyunu başlamak için bir Karakter Seçiniz !");
        player.selectChar();

        do {
            boolean exit = false ; // guvenli evin durumu .
            player.printInfo();
            System.out.println("\n########## Bölgeler ########## \n " +
                    "1. Güvenli Ev --> Burada Güvendesiniz ! Düşman Yoktur ! \n " +
                    "2. Mağaza --> Burada Silah Ve Zirh Satin Alabilirsiniz ! \n\n " +
                    "3. Mağara --> Ödül <Yemek> , dikkatli ol ! Zombi Çikabilir ! \n " +
                    "4. Orman --> Ödül <Odun> , dikkatli ol ! Vampir Çikabilir ! \n " +
                    "5. Nehir --> Ödül <Su> , dikkatli ol ! Ayi Çikabilir ! \n " +
                    "6. Maden --> Ödül <Şans> , dikkatli ol ! Yilan Çikabilir ! \n " +
                    "0. Cikis --> Oyunu Sonlandir .\n");

            System.out.print("Lütfen Gitmek İstediğiniz Bölgeyi Seçiniz : ");
            byte selectLoc = inp.nextByte();
            while (selectLoc < 0 || selectLoc > 6) {
                System.out.print("Geçersiz Değer ! Tekrar Giriniz : ");
                selectLoc = inp.nextByte();
            }

            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1: // odev 1
                    location = new SafeHouse(player);
                    if (isComplete(player.getInventory().getAwards())){
                        System.out.println("Tebrikler ! Adayi Temizledin !!!");
                        exit = true;
                    }
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);// magara
                    break;
                case 4:
                    location = new Forest(player); // orman
                    break;
                case 5:
                    location = new River(player); // nehir
                    break;
                case 6:
                    location = new Maden(player); // odev
                    break;
            }

            if (location == null) {
                System.out.println("Bu Karanlik ve sisili Adadan Çabuk Vaz geçtin !");
                break;
            }

            if (!location.onLocation()) {
                gameOver();
                break;
            }

            if (exit){
                break;
            }

        } while (true);

    }
    public boolean isComplete(Award[] award) { // odev 1
        int cont = 0;
        for (Award a : award) {
            if (a.isStaus()) {
                cont++;
            }
        }
        return cont == award.length;
    }

    private void gameOver() {
        System.out.println("==============================\n======  Game Over  =====\n==============================");
    }
}
