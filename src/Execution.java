import java.time.LocalDate;
import java.util.Scanner;

public class Execution {
    private final Invoice invoice1;
    private final Invoice invoice2;
    private final Invoice invoice3;
    private final Scanner scanner;

    public Execution() {
        CargoVan cargoVan = new CargoVan("Citroen", "Jumper", 20000.00, 8);
        RentalPeriod rentalPeriod1 = new RentalPeriod(LocalDate.of(2024, 6, 3), LocalDate.of(2024, 6, 18), LocalDate.of(2024, 6, 13));
        Pricing pricing1 = new Pricing(cargoVan, rentalPeriod1);
        invoice1 = new Invoice("John Markson", pricing1);

        Car car = new Car("Mitsubishi", "Mirage", 15000.00, 3);
        RentalPeriod rentalPeriod2 = new RentalPeriod(LocalDate.of(2024, 6, 3), LocalDate.of(2024, 6, 13), LocalDate.of(2024, 6, 13));
        Pricing pricing2 = new Pricing(car, rentalPeriod2);
        invoice2 = new Invoice("John Doe", pricing2);

        Motorcycle motorcycle = new Motorcycle("Triumph", "Tiger Sport 660", 10000.00, 20);
        RentalPeriod rentalPeriod3 = new RentalPeriod(LocalDate.of(2024, 6, 3), LocalDate.of(2024, 6, 13), LocalDate.of(2024, 6, 13));
        Pricing pricing3 = new Pricing(motorcycle, rentalPeriod3);
        invoice3 = new Invoice("Mary Johnson", pricing3);

        scanner = new Scanner(System.in);
    }


    public void showMainMenu() {
        System.out.println("VEHICLE RENTAL SYSTEM\n\n");
        System.out.println("Welcome to the vehicle rental system, made by Lora Gotseva!\n");
        System.out.println("Select one of the following:\n");
        System.out.println("[1] View by customer name");
        System.out.println("[2] Exit\n");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                showNameSelectMenu();
                break;
            case "2":
                System.out.println("Exiting the system. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
                showMainMenu();
                break;
        }
    }

    private void showNameSelectMenu() {
        System.out.println("Select a name using the corresponding number for which you want to view an invoice:");
        System.out.println("[1] " + invoice1.getCustomerName());
        System.out.println("[2] " + invoice2.getCustomerName());
        System.out.println("[3] " + invoice3.getCustomerName());
        System.out.println("[4] Exit");

        String choice = scanner.nextLine();
        while (!(choice.equals("1") || choice.equals("2") || choice.equals("3")|| choice.equals("4"))) {
            System.out.println("Select a number between 1-4!");
            choice = scanner.nextLine();
        }

        switch (choice) {
            case "1":
                System.out.println(invoice1);
                break;
            case "2":
                System.out.println(invoice2);
                break;
            case "3":
                System.out.println(invoice3);
                break;
            case "4":
                System.out.println("Exiting the system. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3 or 4.");
                showNameSelectMenu();
                break;
        }
    }
}
