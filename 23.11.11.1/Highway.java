import java.util.*;

public class Highway {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] Ankara = {300, 400};
        int[] Eskişehir = {150, 100, 150};
        int[] Istanbul = {300, 150, 50, 300};
        int[] Kocaeli = {400, 100, 50, 250};
        int[] Konya = {150, 300, 250};
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
                System.out.println("Your Route: Istanbul - Kocaeli - Ankara - Kocaeli - Istanbul");
                System.out.print("Where do you want to board and disembark? (Ankara: 1, Istanbul: 2, Kocaeli: 3): ");
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
                        selectedRoute = Istanbul;
                        price = Istanbul[arrival - 1];
                        System.out.print(price);
                        break;
                    case 3:
                        selectedRoute = Kocaeli;
                        price = Kocaeli[arrival - 1];
                        System.out.print(price);
                        break;
                    default:
                        System.out.println("Only journeys between the 3 cities listed are possible on this route.");
                        break;
                }
            }
            break;
            case 2: {
                int[] selectedRoute;
                System.out.println("You have selected Route 2.");
                System.out.println("Your Route: Istanbul - Kocaeli - Eskişehir - Konya - Eskişehir - Kocaeli - Istanbul");
                System.out.print("Where do you want to board and disembark? (Eskişehir: 1, Istanbul: 2, Kocaeli: 3, Konya: 4): ");
                departure = scanner.nextInt();
                arrival = scanner.nextInt();
                while (departure == arrival) {
                    System.out.print("Please choose a different destination. You cannot select the same city.");
                    arrival = scanner.nextInt();
                }
                switch (departure) {
                    case 1:
                        selectedRoute = Eskişehir;
                        price = Eskişehir[arrival - 1];
                        System.out.print(price);
                        break;
                    case 2:
                        selectedRoute = Istanbul;
                        price = Istanbul[arrival - 1];
                        System.out.print(price);
                        break;
                    case 3:
                        selectedRoute = Kocaeli;
                        price = Kocaeli[arrival - 1];
                        System.out.print(price);
                        break;
                    case 4:
                        selectedRoute = Konya;
                        price = Konya[arrival];
                        System.out.print(price);
                        break;
                    default:
                        System.out.println("Only journeys between the 4 cities listed are possible on this route.");
                        break;
                }
            }
            break;
        }
    }
}
