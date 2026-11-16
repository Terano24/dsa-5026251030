import java.util.*;

public class main {
   
    static void bubbleSortMenurun(int[] rak, int putaranAwal, int putaranAkhir) {
        int n = rak.length;
        for (int i = putaranAwal; i < putaranAkhir; i++) {
            for (int j = 0; j <= n - 2 - i; j++) {
                if (rak[j] < rak[j + 1]) {
                    int sementara = rak[j];
                    rak[j] = rak[j + 1];
                    rak[j + 1] = sementara;
                }
            }
        }
    }

    static int cariPaket(int[] rak, int target, int[] langkah) {
        int bawah = 0;
        int atas = rak.length - 1;
        langkah[0] = 0;
        while (bawah <= atas) {
            int tengah = (bawah + atas) / 2;
            langkah[0]++;
            if (rak[tengah] == target) {
                return tengah;
            } else if (rak[tengah] < target) {
                atas = tengah - 1;
            } else {
                bawah = tengah + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(main.class.getResourceAsStream("parcels.txt"));

        int jumlahPaket = sc.nextInt();
        int[] rak = new int[jumlahPaket];
        for (int i = 0; i < jumlahPaket; i++) {
            rak[i] = sc.nextInt();
        }

        int jumlahTarget = sc.nextInt();
        int[] target = new int[jumlahTarget];
        for (int i = 0; i < jumlahTarget; i++) {
            target[i] = sc.nextInt();
        }
        sc.close();

        
        bubbleSortMenurun(rak, 0, 2);
        int[] Habis = new int[jumlahPaket];
        for (int i = 0; i < jumlahPaket; i++) {
            Habis[i] = rak[i];
        }

        bubbleSortMenurun(rak, 2, jumlahPaket - 1);

        System.out.println("==== After 2 Passes ====");
        for (int i = 0; i < Habis.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(Habis[i]);
        }
        System.out.println();
        System.out.println();
        System.out.println("==== Fully Sorted ====");
        for (int i = 0; i < rak.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(rak[i]);
        }
        System.out.println();
        System.out.println();
        System.out.println("==== Search Results ====");

        int[] langkah = new int[1];
        for (int i = 0; i < jumlahTarget; i++) {
            int indeks = cariPaket(rak, target[i], langkah);
            if (indeks != -1) {
                System.out.println(target[i] + ": FOUND at index " + indeks + " (steps: " + langkah[0] + ")");
            } else {
                System.out.println(target[i] + ": NOT FOUND (steps: " + langkah[0] + ")");
            }
        }
    }
}
