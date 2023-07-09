// AnimalView

import java.util.List;
import java.util.Scanner;

class AnimalView {
    private Scanner scanner;

    public AnimalView() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n=== Animal Registry ===");
        System.out.println("1. Add a new animal");
        System.out.println("2. View animal commands");
        System.out.println("3. Teach animal new commands");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public String getAnimalNameFromUser() {
        System.out.print("Enter the animal name: ");
        return scanner.nextLine();
    }

    public String getAnimalTypeFromUser() {
        System.out.print("Enter the animal type (dog, cat, hamster, horse, camel, donkey): ");
        return scanner.nextLine().toLowerCase();
    }

    public String getAnimalBirthdayFromUser() {
        System.out.print("Enter the animal's birthday: ");
        return scanner.nextLine();
    }

    public void displayAnimalCommands(List<String> commands) {
        if (commands.isEmpty()) {
            System.out.println("No available commands for this animal.");
        } else {
            System.out.println("Animal commands:");
            for (String command : commands) {
                System.out.println("- " + command);
            }
        }
    }

    public String getCommandFromUser() {
        System.out.print("Enter the command: ");
        return scanner.nextLine();
    }

    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    public void displaySuccessMessage(String message) {
        System.out.println("Success: " + message);
    }

    public void displayAnimalInfo(Animals animal) {
        System.out.println("Animal Info:");
        System.out.println("Class: " + (animal instanceof DomesticAnimals ? "Domestic" : "Draught"));
        System.out.println("Type: " + animal.getClass().getSimpleName());
        System.out.println("Name: " + animal.getName());
    }
}
