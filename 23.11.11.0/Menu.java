import java.util.*;
public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select an option:");
        System.out.println("1) Airways");
        System.out.println("2) Roadways");
        System.out.println("3) Railways");

        int choice = scanner.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println("Invalid option.");
            choice = scanner.nextInt();
        }
        if (choice == 1) {
            Airway.main(null);
        } else if (choice == 2) {
            Highway.main(null); 
        } else if (choice == 3) {
            Railway.main(null);
        } 
    }
}
