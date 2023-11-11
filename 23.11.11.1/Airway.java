import java.util.*;
public class Airway {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] Istanbul = {1000, 1200};
        int departure, arrival, price;
        System.out.print("Select the route you want to use: ");
        int route = scanner.nextInt();
        while (route > 2 || route < 1) {
            System.out.println("Please choose a valid route number.");
            route = scanner.nextInt();
        }
        switch (route) {
            case 1:
                System.out.println("You have selected Route 1.");
                System.out.println("Istanbul - Konya - Istanbul");
                price = 1200;
                System.out.println(price);
                break;
            case 2:
                System.out.println("You have selected Route 2.");
                System.out.println("Istanbul - Ankara - Istanbul");
                price = 1000;
                System.out.println(price);
                break;
        }
    }
}
