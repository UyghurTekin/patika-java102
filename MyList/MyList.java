public class MyList<T> {
    private Object[] data;
    private int elemanSayisi = 0;
    private int capacity;

    public MyList() {
        // Boş contructor kullanılırsa dizinin başlangıç boyutu 10 olmalıdır.
        this.capacity = 10;
        this.data = new Object[capacity];
    }

    public MyList(int capacity) {
        // Dizinin başlangıç Boyutu capacity parametresinden alınmalıdır.
        this.capacity = capacity;
        this.data = new Object[capacity];
    }

    public void add(T item) {
        // sınıfa ait diziye eleman eklemek için kullanılmalıdır.
        // Eğer dizide yeteri kadar yer yok ise, dizi boyutu 2 katına çıkartılmalıdır.

        if (elemanSayisi == capacity) {
            upgradeCapacity(); // kapasite yukseltme
        }
        this.data[this.elemanSayisi++] = item;
    }

    private void upgradeCapacity() {
        // Eğer dizide yeteri kadar yer yok ise, dizi boyutu 2 katına çıkartılmalıdır.
        capacity *= 2;
        Object[] tempData = data; // data depolaniyor...
        data = new Object[capacity]; // capacoty yukseltiliyor...

        // yukselirken silinen datalar yerine getiriliyor...
        for (int i = 0; i < tempData.length; i++) {
            data[i] = tempData[i];
        }
    }

    public int getCapacity() { //dizinin kapasite değerini verir.
        return data.length;
    }

    public int size() { // dizideki eleman sayısını verir.
        int cont = 0;
        for (Object o : this.data) {
            if (o != null) {
                cont++;
            }
        }
        return cont;
    }

    public Object get(int index) {
        // verilen indisteki değeri döndürür.
        // Geçersiz indis girilerse null döndürür.
        if (index < 0 || index >= this.data.length) {
            return -1;
        }
        return data[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= this.data.length) {
            System.out.println("null");
        } else {
            Object[] tempData = new Object[this.data.length - 1];

            for (int i = 0; i < tempData.length; i++) {
                if (i < index) {
                    tempData[i] = this.data[i];
                } else {
                    tempData[i] = this.data[i + 1];
                }

            }
            this.data = tempData;
        }
    }

    public void set(int index, T data) {
        if (index < 0 || index >= this.data.length) {
            System.out.println("null");
        } else {
            this.data[index] = data;
        }
    }

    public String toString() {
        String datalist = "[";
        for (int i = 0; i < this.data.length; i++) {
            datalist += this.data[i];
            if (i != this.data.length - 1) {
                datalist += ", ";
            }
        }
        datalist += "]";
        return datalist;
    }

    public int indexOf(T data) {
        int indexNum = 0;
        for (Object o : this.data) {
            if (o == data) {
                return indexNum;
            }
            indexNum++;
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        int indexNum = 0;
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == data) {
                indexNum = i;
            }
        }
        return indexNum != 0 ? indexNum : -1;
    }

    /*
        public <T> T[] toArray(){
            return (T[]) this.data;
        }
    */
    public Object[] toArray() {
        return this.data;
    }

    public void clear() { // Listedeki bütün öğeleri siler, boş liste haline getirir.
        this.data = new Object[0];
    }

    MyList<T> subList(int start, int finish) { // 0 , 3
        MyList<T> subList = new MyList<>((finish - start) + 1);

        for (int i = 0; i < subList.getCapacity(); i++) {
            subList.add((T) this.data[start]);
            start++;
        }

        return subList;
    }

    public boolean contains(T data) {
        // Parametrede verilen değerin dizide olup olmadığını söyler.
        for (Object o : this.data) {
            if (o == data) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() { // Listenin boş olup olmadığını söyler.
        return size() == 0;
    }

}
