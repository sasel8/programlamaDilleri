
package gramer;

import java.util.Scanner;


public class Gramer {

    
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);//kullanıcıdan veri girişi almak için
        System.out.println("Ozne Nesne ve Yuklemden olusan bır cumle olusturunuz:");
        String cumle=scanner.nextLine().trim();//fazladan boşluğu kaldır
        
        
        String[] kelimeler=cumle.split("\\s+");//bir veya daha fazla boşluk
        
        
        String[] ozne= {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
        String[] nesne=  {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
        String[] yuklem= {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};


        if(kelimeler.length == 3){
            String ozneKelime = kelimeler[0];
            String nesneKelime = kelimeler[1];
            String yuklemKelime = kelimeler[2];
            
            if(kelimeKontrol(ozne,ozneKelime) && kelimeKontrol(nesne,nesneKelime) && kelimeKontrol(yuklem,yuklemKelime)){//cümlenin iç kelime olup olmadığı kontrol edilir
                System.out.println("EVET");
            } else {
                System.out.println("HAYIR");
            }
        } else {
            System.out.println("HAYIR");
        }
    }

    
    public static boolean kelimeKontrol(String[] dizi, String eleman){//girilen kelimenin dizide olup olmadığını kontrol etmek için
         for(String s : dizi){
             if (s.equals(eleman)){ 
                 return true;
            }
        }
        return false;
    }
}
