import java.util.*;
public class demiryolu {
    public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in);
        int[] Ankara = {0,150,100,250,200,0};
        int[] Bilecik = {150,0,50,150,50,200};
        int[] Eskişehir = {100,50,0,200,100,150};
        int[] Istanbul = {250,150,200,0,50,300};
        int[] Kocaeli = {200,50,100,50,0,250};
        int[] Konya = {0,200,150,300,250,0};
        int binis, inis, ucret;
        System.out.print("Kullanmak istediginiz güzergahı seçiniz: ");
        int rota = tarayici.nextInt();
        switch(rota){
            case 1: {
                int[] Rotamiz;
                System.out.println("1. Rotayı Seçtiniz.");
                System.out.println("Rotanız: Istanbul - Kocaeli - Bilecik - Eskişehir - Ankara - Eskişehir - Bilecik - Kocaeli - Istanbul");
                System.out.print("Nerede binmek ve nerede inmek istersiniz? (Ankara:1 , Bilecik:2 , Eskişehir:3 , Istanbul:4 , Kocaeli:5): ");
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
                    Rotamiz= Bilecik;
                    ucret = Bilecik[inis-1];
                    System.out.print(ucret);
                    break;
                    case 3:
                    Rotamiz= Eskişehir;
                    ucret = Eskişehir[inis-1];
                    System.out.print(ucret);
                    break;
                    case 4:
                    Rotamiz= Istanbul;
                    ucret = Istanbul[inis-1];
                    System.out.print(ucret);
                    break;
                    case 5:
                    Rotamiz= Kocaeli;
                    ucret = Kocaeli[inis-1];
                    System.out.print(ucret);
                    break;
                    default:
                    System.out.println("Bu rotada sadece listelenen 5 şehir arası yolculuklar mümkündür.");
                    break;

                }
            }
            break;
            case 2:{
                int[] Rotamiz;
                System.out.println("2. Rotayı seçtiniz.");
                System.out.println("Rotanız: Istanbul - Kocaeli - Bilecik - Eskişehir - Konya - Eskişehir - Bilecik - Kocaeli - Istanbul");
                System.out.print("Nerede binmek ve nerede inmek istersiniz? ( Bilecik:1 , Eskişehir:2 , Istanbul:3 , Kocaeli:4 , Konya:5): ");
                binis = tarayici.nextInt();
                inis = tarayici.nextInt();
                while (binis == inis) {
                    System.out.print("Lütfen farklı bir iniş noktası seçin. Aynı şehir seçilemez.");
                    inis = tarayici.nextInt();
                }
                switch(binis){
                    case 1:
                    Rotamiz= Bilecik;
                    ucret = Bilecik[inis];
                    System.out.print(ucret);
                    break;
                    case 2:
                    Rotamiz= Eskişehir;
                    ucret = Eskişehir[inis];
                    System.out.print(ucret);
                    break;
                    case 3:
                    Rotamiz= Istanbul;
                    ucret = Istanbul[inis];
                    System.out.print(ucret);
                    break;
                    case 4:
                    Rotamiz= Kocaeli;
                    ucret = Kocaeli[inis];
                    System.out.print(ucret);
                    break;
                    case 5:
                    Rotamiz= Konya;
                    ucret = Konya[inis];
                    System.out.print(ucret);
                    break;
                    default:
                    System.out.println("Bu rotada sadece listelenen 5 şehir arası yolculuklar mümkündür.");
                    break;
            }
            break;
        }
       
     }
}
}
