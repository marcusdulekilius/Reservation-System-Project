import java.util.*;
public class menu {
    public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in);

        System.out.println("Lütfen bir seçenek seçin:");
        System.out.println("1) Havayolu");
        System.out.println("2) Karayolu");
        System.out.println("3) Demiryolu");

        int secim = tarayici.nextInt();
        while(secim < 1 || secim > 3) {
            System.out.println("Geçersiz seçenek.");
            secim = tarayici.nextInt();
        }
         if (secim == 1) {
            havayolu.main(null); // Havayolu sınıfını çağır ve çalıştır
        } else if (secim == 2) {
            karayolu.main(null); // Karayolu sınıfını çağır ve çalıştır
            }
            else if (secim == 3) {
                demiryolu.main(null);
        } 
    }
}
