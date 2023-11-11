import java.util.Scanner;

public class havayolu {
    public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in);
        int[] Istanbul = {1000,1200};
        int binis, inis, ucret;
        System.out.print("Kullanmak istediginiz güzergahı seçiniz: ");
        int rota = tarayici.nextInt();
        while(rota > 2 || rota < 1){
            System.out.println("Lütfen geçerli bir güzergah numarası seçiniz.");
            rota = tarayici.nextInt();
        }
        switch(rota){
            case 1:
            System.out.println("1. rotayı seçtiniz.");
            System.out.println("ıstanbul - Konya - Istanbul");
            ucret = 1200;
            System.out.println(ucret);
            break;
            case 2:
            System.out.println("2. Rotayı seçtiniz.");
            System.out.println("Istanbul - Ankara - Istanbul");
            ucret = 1000;
            System.out.println(ucret);
            break;
    }
}
}
