import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (AnimalController controller = new AnimalController(new AnimalView())) {
            boolean exit = false;
            while (!exit) {
                controller.view.displayMenu();
                Scanner scanner = new Scanner(System.in);
                int choice;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                } catch (InputMismatchException e) {
                    controller.view.displayErrorMessage("Invalid choice. Please try again.");
                    scanner.nextLine(); 
                    continue; 
                }

                switch (choice) {
                    case 1:
                        controller.addAnimal();
                        break;
                    case 2:
                        controller.viewAnimalCommands();
                        break;
                    case 3:
                        controller.addCommandToAnimal();
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        controller.view.displayErrorMessage("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
