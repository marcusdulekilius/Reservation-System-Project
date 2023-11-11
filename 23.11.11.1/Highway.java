import java.util.*;

public class Highway {
    public static void main(String[] args) {
         Scanner tarayici = new Scanner(System.in);
        int[] Ankara = {300,400};
        int[] Eskişehir = {150,100,150};
        int[] Istanbul = {300,150,50,300};
        int[] Kocaeli = {400,100,50,250};
        int[] Konya = {150,300,250};
        int binis, inis, ucret;
        System.out.print("Kullanmak istediginiz güzergahı seçiniz: ");
        int rota = tarayici.nextInt();
        while(rota > 2 || rota < 1){
            System.out.println("Lütfen geçerli bir güzergah numarası seçiniz.");
            rota = tarayici.nextInt();
        }
        switch(rota){
            case 1: {
                int[] Rotamiz;
                System.out.println("1. Rotayı Seçtiniz.");
                System.out.println("Rotanız: Istanbul - Kocaeli - Ankara - Kocaeli - Istanbul");
                System.out.print("Nerede binmek ve nerede inmek istersiniz? (Ankara:1 , Istanbul:2 , Kocaeli:3): ");
                binis = tarayici.nextInt();
                inis = tarayici.nextInt();
                while (binis == inis) {
                    System.out.println("Lütfen farklı bir iniş noktası seçin. Aynı şehir seçilemez.");
                    inis = tarayici.nextInt();
                }
                switch(binis){
                    case 1:
                    Rotamiz= Ankara;
                    ucret = Ankara[inis-1];
                    System.out.print(ucret);
                    break;
                    case 2:
                    Rotamiz= Istanbul;
                    ucret = Istanbul[inis-1];
                    System.out.print(ucret);
                    break;
                    case 3:
                    Rotamiz= Kocaeli;
                    ucret = Kocaeli[inis-1];
                    System.out.print(ucret);
                    break;
                    default:
                    System.out.println("Bu rotada sadece listelenen 3 şehir arası yolculuklar mümkündür.");
                    break;

                }
            }
            break;
            case 2:{
                int[] Rotamiz;
                System.out.println("2. Rotayı seçtiniz.");
                System.out.println("Rotanız: Istanbul - Kocaeli - Eskişehir - Konya - Eskişehir - Kocaeli - Istanbul");
                System.out.print("Nerede binmek ve nerede inmek istersiniz? ( Eskişehir:1 , Istanbul:2 , Kocaeli:3 , Konya:4): ");
                binis = tarayici.nextInt();
                inis = tarayici.nextInt();
                while (binis == inis) {
                    System.out.print("Lütfen farklı bir iniş noktası seçin. Aynı şehir seçilemez.");
                    inis = tarayici.nextInt();
                }
                switch(binis){
                    case 1:
                    Rotamiz= Eskişehir;
                    ucret = Eskişehir[inis-1];
                    System.out.print(ucret);
                    break;
                    case 2:
                    Rotamiz= Istanbul;
                    ucret =Istanbul[inis-1];
                    System.out.print(ucret);
                    break;
                    case 3:
                    Rotamiz= Kocaeli;
                    ucret = Kocaeli[inis-1];
                    System.out.print(ucret);
                    break;
                    case 4:
                    Rotamiz= Konya;
                    ucret = Konya[inis];
                    System.out.print(ucret);
                    break;
                    default:
                    System.out.println("Bu rotada sadece listelenen 4 şehir arası yolculuklar mümkündür.");
                    break;
            }
            break;
        }
    }
}
}
