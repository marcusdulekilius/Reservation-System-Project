import java.util.*;
public class Rail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] Ankara = {0, 150, 100, 250, 200, 0};
        int[] Bilecik = {150, 0, 50, 150, 50, 200};
        int[] Eskişehir = {100, 50, 0, 200, 100, 150};
        int[] Istanbul = {250, 150, 200, 0, 50, 300};
        int[] Kocaeli = {200, 50, 100, 50, 0, 250};
        int[] Konya = {0, 200, 150, 300, 250, 0};
        int round, trip, price;
        System.out.print("Select the route you want to use: ");
        int way = scanner.nextInt();
        switch(way) {
            case 1: {
                int[] Route;
                System.out.println("You have selected Route 1.");
                System.out.println("Your route: Istanbul - Kocaeli - Bilecik - Eskişehir - Ankara - Eskişehir - Bilecik - Kocaeli - Istanbul");
                System.out.print("Where do you want to board and get off? (Ankara:1 , Bilecik:2 , Eskişehir:3 , Istanbul:4 , Kocaeli:5): ");
                round = scanner.nextInt();
                trip = scanner.nextInt();
                while (round == trip) {
                    System.out.println("Please choose a different trip point. The same city cannot be selected.");
                    trip = scanner.nextInt();
                }
                switch(round) {
                    case 1:
                    Route = Ankara;
                    price = Ankara[trip - 1];
                    System.out.print(price);
                    break;
                    case 2:
                    Route = Bilecik;
                    price = Bilecik[trip - 1];
                    System.out.print(price);
                    break;
                    case 3:
                    Route = Eskişehir;
                    price = Eskişehir[trip - 1];
                    System.out.print(price);
                    break;
                    case 4:
                    Route = Istanbul;
                    price = Istanbul[trip - 1];
                    System.out.print(price);
                    break;
                    case 5:
                    Route = Kocaeli;
                    price = Kocaeli[trip - 1];
                    System.out.print(price);
                    break;
                    default:
                    System.out.println("Only intercity travel between the listed 5 cities is possible on this route.");
                    break;
                }
            }
            break;
            case 2: {
                int[] Route;
                System.out.println("You have selected Route 2.");
                System.out.println("Your route: Istanbul - Kocaeli - Bilecik - Eskişehir - Konya - Eskişehir - Bilecik - Kocaeli - Istanbul");
                System.out.print("Where do you want to board and get off? (Bilecik:1 , Eskişehir:2 , Istanbul:3 , Kocaeli:4 , Konya:5): ");
                round = scanner.nextInt();
                trip = scanner.nextInt();
                while (round == trip) {
                    System.out.print("Please choose a different trip point. The same city cannot be selected.");
                    trip = scanner.nextInt();
                }
                switch(round) {
                    case 1:
                    Route = Bilecik;
                    price = Bilecik[trip];
                    System.out.print(price);
                    break;
                    case 2:
                    Route = Eskişehir;
                    price = Eskişehir[trip];
                    System.out.print(price);
                    break;
                    case 3:
                    Route = Istanbul;
                    price = Istanbul[trip];
                    System.out.print(price);
                    break;
                    case 4:
                    Route = Kocaeli;
                    price = Kocaeli[trip];
                    System.out.print(price);
                    break;
                    case 5:
                    Route = Konya;
                    price = Konya[trip];
                    System.out.print(price);
                    break;
                    default:
                    System.out.println("Only intercity travel between the listed 5 cities is possible on this route.");
                    break;
                }
            }
            break;
        }
    }
}
