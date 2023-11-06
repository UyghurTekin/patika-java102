import java.util.Random;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObestacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObestacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObestacle = maxObestacle;
    }

    @Override
    public boolean onLocation() {

        // ================ ÖDEV 1 ====================

        if (!this.isComplete(this.getPlayer().getInventory().getAwards(), this.award)) {
            System.out.println("Temizlenmiş Bölge");
            return true;
        }

        // ================ ÖDEV 1 ====================

        int obsNumber = rnd.nextInt(this.maxObestacle) + 1; // method silindi .
        System.out.println("Şuan Buradasiniz : " + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " Yaşiyor !");
        System.out.println("----------------------------------");
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = inp.nextLine().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {
            return true;
        }

        if (getPlayer().getHealth() <= 0) {
            System.out.println("==============================\n======  Öldünüz ! ======");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("----------------------------------");
                // ================ ÖDEV 2 ====================

                if (rnd.nextInt(10) < 5) { // ilik Vurma sansi . oyuncuda
                    System.out.println(";Şanslisin , Sira Sende !");
                    System.out.print("<V>ur veya <K>aç : ");
                    String selectCombat = inp.nextLine().toUpperCase();
                    if (selectCombat.equals("V")) {
                        System.out.println("Siz --> Vurdunuz !");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamage());
                        afterHit();
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println("\n" + this.getObstacle().getName() + " Sizi <-- Vurdu");
                            int obstacleDamage = this.getObstacle().getDemage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    } else {
                        return false;
                    }
                } else { // Şans Canvarda

                    System.out.println("\n" + this.getObstacle().getName() + " Sizi <-- Vurdu");
                    int obstacleDamage = this.getObstacle().getDemage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (obstacleDamage < 0) {
                        obstacleDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                    afterHit();

                    if (this.getPlayer().getHealth() > 0) {
                        System.out.print("<V>ur veya <K>aç : ");
                        String selectCombat = inp.nextLine().toUpperCase();
                        if (selectCombat.equals("V")) {
                            System.out.println("Siz --> Vurdunuz !");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamage());
                            afterHit();
                        } else {
                            return false;
                        }
                    }
                }

                // ================ ÖDEV 2 ====================

            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmani Yendiniz !!!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println(this.getObstacle().getAward() + " Para Kazandiniz !");
                System.out.println("Guncel Paraniz : " + this.getPlayer().getMoney());

                if (this.getName().equals("Maden")){
                    rewardByChance(getPlayer());
                }

                // ================ ÖDEV 1 ====================

                if (obsNumber == i) {
                    System.out.println("Afferim " + this.getPlayer().getName() + ", " + this.getName() +
                            "'daki Tüm " + this.getObstacle().getName() + "'leri Temizledin !");
                    System.out.println("Ve < " + this.getAward() + " > Kazandin !!!");
                    this.getPlayer().getInventory().setAwards(this.getAward());
                }

                // ================ ÖDEV 1 ====================

            } else {
                return false;
            }
        }

        return true;
    }

    private void rewardByChance(Player player) {
        int oddsOfWinning = rnd.nextInt(100); // kazanma  ihtimali icin .
        int  ammo = rnd.nextInt(100); // muhimmat icin

        if (oddsOfWinning <= 15){ // silah kazanma .
            if (ammo <= 20){ // Tufek Kazanma .
                player.getInventory().setWeapon(Weapon.getWeaponObjById(3));
                System.out.println("Şanslısın , Tüfek Kazandin !!!");

            } else if (ammo <= 50) { // Kilic kazanma .
                player.getInventory().setWeapon(Weapon.getWeaponObjById(2));
                System.out.println("Şanslısın , Kılıç Kazandin !!!");

            } else { // Tabanca kazanma .
                player.getInventory().setWeapon(Weapon.getWeaponObjById(1));
                System.out.println("Şanslısın , Tabanca Kazandin !!!");
            }

        } else if (oddsOfWinning <= 30) { // zirh kazanma .

            if (ammo <= 20){ // Agir Zirh kazanma .
                player.getInventory().setArmor(Armor.getArmorObjById(3));
                System.out.println("Şanslısın , Ağır Zırh Kazandin !!!");

            } else if (ammo <= 50) { // Orta Zirh kazanma .
                player.getInventory().setArmor(Armor.getArmorObjById(2));
                System.out.println("Şanslısın , Orta Zırh Kazandin !!!");

            } else { // hafif Zirh kazanma .
                player.getInventory().setArmor(Armor.getArmorObjById(1));
                System.out.println("Şanslısın , Hafıf Zırh Kazandin !!!");

            }

        } else if (oddsOfWinning <= 55) { // para kazanma .
            if (ammo <= 20){ // 10 Para kazanma .
                player.setMoney(player.getMoney() + 10);
                System.out.println("Şanslısın , 10 Para Kazandin !!!");

            } else if (ammo <= 50) { // 5 Para kazanma .
                player.setMoney(player.getMoney() + 5);
                System.out.println("Şanslısın , 5 Para Kazandin !!!");

            } else { // 1 Para kazanma .
                player.setMoney(player.getMoney() + 1);
                System.out.println("Şanslısın , 1 Para Kazandin !!!");
            }

        }else { // pardon .
            System.out.println("Malasef , Ödül Kazanamadin !");
        }
    }

    private void afterHit() {
        System.out.println("Caniniz : " + getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Cani : " + getObstacle().getHealth());
        System.out.println("--------------");
    }

    private void playerStats() {
        System.out.println("---------- Oyuncu Değerleri ---------");
        System.out.println("Sağlik : " + this.getPlayer().getHealth() +
                "\nSilah : " + this.getPlayer().getInventory().getWeapon().getName() +
                "\nHasar : " + this.getPlayer().getDamage() +
                "\nZirh : " + this.getPlayer().getInventory().getArmor().getName() +
                "\nBlocklama : " + this.getPlayer().getInventory().getArmor().getBlock() +
                "\nPara : " + this.getPlayer().getMoney());
    }

    private void obstacleStats(int i) {
        System.out.println("---------- " + i + "." + this.getObstacle().getName() + " Değerleri ---------");
        System.out.println("Sağlik : " + this.getObstacle().getHealth() +
                "\nHasar : " + getObstacle().getDemage() +
                "\nÖdül : " + getObstacle().getAward());
    }

    // ================ ÖDEV 1 ====================
    public boolean isComplete(Award[] awardPl, String awardLoc) {
        for (Award a : awardPl) {
            if (a.getName().equals(awardLoc) && a.isStaus()) {
                return false;
            }
        }
        return true;
    }

    // ================ ÖDEV 1 ====================

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObestacle() {
        return maxObestacle;
    }

    public void setMaxObestacle(int maxObestacle) {
        this.maxObestacle = maxObestacle;
    }

}
