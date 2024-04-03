package bagli_sirala;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int veri;
    int adres;

    Node(int veri, int adres) {
        this.veri = veri;
        this.adres = adres;
    }
}

public class Bagli_Sirala {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dosya adini girin: ");
        String dosyaAdi = scanner.nextLine();//Kullanıcıdan dosya adının alınması için bir Scanner nesnesi oluşturulur.

        try {
            File file = new File(dosyaAdi);
            Scanner dosyaOkuyucu = new Scanner(file);//Kullanıcının girdiği dosya adı kullanılarak bir File nesnesi oluşturulur ve bu dosyayı okumak için bir Scanner nesnesi daha oluşturulur.

            ArrayList<Node> orijinalListe = new ArrayList<>(); // Orijinal ArrayList
            ArrayList<Node> kopyaListe = new ArrayList<>(); // Kopya ArrayList

            int index = 0;
            while (dosyaOkuyucu.hasNextInt()) {
                int x = dosyaOkuyucu.nextInt();
                Node node = new Node(x, index);
                orijinalListe.add(node); // Okunan her sayıyı orijinal listeye ekleme
                kopyaListe.add(new Node(x, index)); // Okunan her sayıyı kopya listeye ekleme
                index++;
            }

            // Kopya listeyi bubble sort ile sıralama 
            for (int i = 0; i < kopyaListe.size() - 1; i++) {
                for (int j = 0; j < kopyaListe.size() - i - 1; j++) {
                    if (kopyaListe.get(j).veri > kopyaListe.get(j + 1).veri) {
                        // Swap yapımı
                        Node temp = kopyaListe.get(j);
                        kopyaListe.set(j, kopyaListe.get(j + 1));
                        kopyaListe.set(j + 1, temp);
                    }
                }
            }

            // Dizilerin yan yana yazdırılması
           System.out.println("Orjinal Veri ve Adres:");
               for (int i = 0; i < orijinalListe.size(); i++) {
                  System.out.println("Veri: " + orijinalListe.get(i).veri + ", Adres: " + orijinalListe.get(i).adres);
            }

            System.out.println("\nSirali Veri ve Adres:");
                for (int i = 0; i < kopyaListe.size(); i++) {
                   System.out.println("Veri: " + kopyaListe.get(i).veri + ", Adres: " + kopyaListe.get(i).adres);
            }


            dosyaOkuyucu.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadi.");
            e.printStackTrace();
        }
    }
}