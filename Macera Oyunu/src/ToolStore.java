public class ToolStore extends Location {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------ Mağazaya Hoş Geldiniz ! ------");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("\n1 - Silahlar \n2 - Zirhlar \n0 - Çıkış Yap \n");
            System.out.print("Seciminiz :");
            byte selectCase = inp.nextByte();
            while (selectCase < 0 || selectCase > 2) {
                System.out.print("Geçersiz Değer ! Tekrar Giriniz : ");
                selectCase = inp.nextByte();
            }
            inp.nextLine(); // temizleme amaclidir !

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 0:
                    System.out.println("Bir Daha Bekleriz !");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("----- Silahlar -----\n");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + " <Para : " + w.getPrice() + " , Hasar : " + w.getDamge() + ">");
        }
        System.out.println("0 - Çikis Yap");

    }

    public void buyWeapon() {
        System.out.print("Bir Silah Seçiniz : ");
        int selectWeapon = inp.nextInt();
        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length) {
            System.out.print("Geçersiz Değer ! Tekrar Giriniz : ");
            selectWeapon = inp.nextByte();
        }

        if (selectWeapon != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeapon);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paraniz bulunmamaktadir !");
                } else {
                    System.out.println(selectedWeapon.getName() + " Silahini Satin Aldiniz !");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paraniz : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                }
            }
        }
    }

    public void printArmor() {
        System.out.println("----- Zirhlar -----\n");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() +
                    " Zirh <Para : " + a.getPrice() + " , Bloklama : " + a.getBlock() + ">");
        }
        System.out.println("0 - Çikis Yap");
    }

    public void buyArmor() {
        System.out.print("Bir Zirh Seçiniz : ");
        int selectArmorId = inp.nextInt();

        while (selectArmorId < 0 || selectArmorId > Armor.armors().length) {
            System.out.print("Geçersiz Değer ! Tekrar Giriniz : ");
            selectArmorId = inp.nextByte();
        }
        if(selectArmorId != 0){
            Armor selectedArmor = Armor.getArmorObjById(selectArmorId);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paraniz bulunmamaktadir !");
                } else {
                    System.out.println(selectedArmor.getName() + " Zirhini Satin Aldiniz !");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paraniz : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);

                }
            }
        }

    }


}
