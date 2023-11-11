import java.util.*;

public class Railway {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] Ankara = {0, 150, 100, 250, 200, 0};
        int[] Bilecik = {150, 0, 50, 150, 50, 200};
        int[] Eskişehir = {100, 50, 0, 200, 100, 150};
        int[] Istanbul = {250, 150, 200, 0, 50, 300};
        int[] Kocaeli = {200, 50, 100, 50, 0, 250};
        int[] Konya = {0, 200, 150, 300, 250, 0};
        int departure, arrival, price;
        
        System.out.print("Select the route you want to use: ");
        int route = scanner.nextInt();
        while (route > 2 || route < 1) {
            System.out.println("Please choose a valid route number.");
            route = scanner.nextInt();
        }

        switch (route) {
            case 1: {
                int[] selectedRoute;
                System.out.println("You have selected Route 1.");
                System.out.println("Your Route: Istanbul - Kocaeli - Bilecik - Eskişehir - Ankara - Eskişehir - Bilecik - Kocaeli - Istanbul");
                System.out.print("Where do you want to board and disembark? (Ankara: 1, Bilecik: 2, Eskişehir: 3, Istanbul: 4, Kocaeli: 5): ");
                departure = scanner.nextInt();
                arrival = scanner.nextInt();
                while (departure == arrival) {
                    System.out.println("Please choose a different destination. You cannot select the same city.");
                    arrival = scanner.nextInt();
                }
                switch (departure) {
                    case 1:
                        selectedRoute = Ankara;
                        price = Ankara[arrival - 1];
                        System.out.print(price);
                        break;
                    case 2:
                        selectedRoute = Bilecik;
                        price = Bilecik[arrival - 1];
                        System.out.print(price);
                        break;
                    case 3:
                        selectedRoute = Eskişehir;
                        price = Eskişehir[arrival - 1];
                        System.out.print(price);
                        break;
                    case 4:
                        selectedRoute = Istanbul;
                        price = Istanbul[arrival - 1];
                        System.out.print(price);
                        break;
                    case 5:
                        selectedRoute = Kocaeli;
                        price = Kocaeli[arrival - 1];
                        System.out.print(price);
                        break;
                    default:
                        System.out.println("Only journeys between the 5 cities listed are possible on this route.");
                        break;
                }
            }
            break;
            case 2: {
                int[] selectedRoute;
                System.out.println("You have selected Route 2.");
                System.out.println("Your Route: Istanbul - Kocaeli - Bilecik - Eskişehir - Konya - Eskişehir - Bilecik - Kocaeli - Istanbul");
                System.out.print("Where do you want to board and disembark? (Bilecik: 1, Eskişehir: 2, Istanbul: 3, Kocaeli: 4, Konya: 5): ");
                departure = scanner.nextInt();
                arrival = scanner.nextInt();
                while (departure == arrival) {
                    System.out.print("Please choose a different destination. You cannot select the same city.");
                    arrival = scanner.nextInt();
                }
                switch (departure) {
                    case 1:
                        selectedRoute = Bilecik;
                        price = Bilecik[arrival];
                        System.out.print(price);
                        break;
                    case 2:
                        selectedRoute = Eskişehir;
                        price = Eskişehir[arrival];
                        System.out.print(price);
                        break;
                    case 3:
                        selectedRoute = Istanbul;
                        price = Istanbul[arrival];
                        System.out.print(price);
                        break;
                    case 4:
                        selectedRoute = Kocaeli;
                        price = Kocaeli[arrival];
                        System.out.print(price);
                        break;
                    case 5:
                        selectedRoute = Konya;
                        price = Konya[arrival];
                        System.out.print(price);
                        break;
                    default:
                        System.out.println("Only journeys between the 5 cities listed are possible on this route.");
                        railway.main(null);
                        break;
                }
            }
            break;
        }
    }
}
