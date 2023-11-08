public class Main {
    public static void main(String[] args) {

        MyList<Integer> list = new MyList<>(5);

        list.add(11);
        list.add(12);
        list.add(11);
        list.add(12);

        System.out.println("Dizideki Eleman Sayısı : " + list.size());
        System.out.println("Dizinin Kapasitesi :" + list.getCapacity());
        list.add(15);
        list.add(16);
        System.out.println("Dizinin Kapasitesi :" + list.getCapacity());
        System.out.println("2. indisteki değer : " + list.get(2));

        // Bulduğu ilk indeksi verir
        System.out.println("Indeks : " + list.indexOf(12));

        // Bulduğu son indeksi verir
        System.out.println("Indeks : " + list.lastIndexOf(12));

        // Listeyi Object[] dizisi olarak geri verir.
        Object[] dizi = list.toArray();
        System.out.println("Object dizisinin ilk elemanı :" + dizi[0]);


        // Liste veri türünde alt bir liste oluşturdu
        MyList<Integer> altListem = list.subList(0, 3);
        System.out.println(altListem.toString());

        // Değerim listedeki olup olmadığını sorguladı
        System.out.println("Listemde 15 değeri : " + list.contains(15));
        System.out.println("Listemde 120 değeri : " + list.contains(120));

        // Listeyi tamamen boşaltır ve varsayılan boyutuna çevirir
        list.clear();
        System.out.println(list.toString());

    }
}