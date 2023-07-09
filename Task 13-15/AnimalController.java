// AnimalController

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class AnimalController implements AutoCloseable {
    AnimalView view;
    private Counter counter;
    private FileWriter fileWriter;
    private List<Animals> animals;

    public AnimalController(AnimalView view) {
        this.view = view;
        this.counter = new Counter();
        this.animals = new ArrayList<>();
        try {
            Path registryFile = Paths.get("animal_registry.txt");
            if (!Files.exists(registryFile)) {
                Files.createFile(registryFile);
            }
            fileWriter = new FileWriter(registryFile.toString(), true);
        } catch (IOException e) {
            view.displayErrorMessage("Failed to open the file for writing.");
        }
    }

    public void addAnimal() {
        try {
            counter.add();
            String name = view.getAnimalNameFromUser();
            String type = view.getAnimalTypeFromUser();
            String birthday = view.getAnimalBirthdayFromUser();
            Animals animal = createAnimal(type, name);
            if (animal != null) {
                animals.add(animal);
                view.displaySuccessMessage("Animal successfully added.");
                writeAnimalToFile(animal, birthday);
                view.displayAnimalInfo(animal);
                view.displayAnimalCommands(animal.commands);
            } else {
                view.displayErrorMessage("Invalid animal type or name.");
            }
        } catch (Exception e) {
            view.displayErrorMessage("Error occurred while adding the animal: " + e.getMessage());
        }
    }

    public void viewAnimalCommands() {
        String name = view.getAnimalNameFromUser();
        Animals animal = findAnimal(name);
        if (animal != null) {
            view.displayAnimalCommands(animal.commands);
        } else {
            view.displayErrorMessage("Invalid animal name.");
        }
    }

    public void addCommandToAnimal() {
        String name = view.getAnimalNameFromUser();
        Animals animal = findAnimal(name);
        if (animal != null) {
            String command = view.getCommandFromUser();
            animal.addCommand(command);
            view.displaySuccessMessage("Command successfully added.");
            writeAnimalCommandsToFile(animal);
        } else {
            view.displayErrorMessage("Invalid animal name.");
        }
    }

    private Animals createAnimal(String type, String name) {
        switch (type.toLowerCase()) {
            case "dog":
                return new Dogs(name);
            case "cat":
                return new Cats(name);
            case "hamster":
                return new Hamsters(name);
            case "horse":
                return new Horses(name);
            case "camel":
                return new Camels(name);
            case "donkey":
                return new Donkeys(name);
            default:
                return null;
        }
    }

    private Animals findAnimal(String name) {
        for (Animals animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    private void writeAnimalToFile(Animals animal, String birthday) {
        try (FileWriter tempWriter = new FileWriter("animal_registry.txt", true)) {
            tempWriter.write("Class: " + (animal instanceof DomesticAnimals ? "Domestic" : "Draught") + "\n");
            tempWriter.write("Type: " + animal.getClass().getSimpleName() + "\n");
            tempWriter.write("Name: " + animal.getName() + "\n");
            tempWriter.write("Birthday: " + birthday + "\n");
            tempWriter.write("Commands:\n");
            for (String command : animal.commands) {
                tempWriter.write("- " + command + "\n");
            }
            tempWriter.write("\n");
        } catch (IOException e) {
            view.displayErrorMessage("Failed to write animal data to file.");
        }
    }

    private void writeAnimalCommandsToFile(Animals animal) {
        try {
            Path registryFile = Paths.get("animal_registry.txt");
            Path tempFile = Paths.get("animal_registry_temp.txt");

            FileWriter tempWriter = new FileWriter(tempFile.toString());

            try (BufferedReader reader = new BufferedReader(new FileReader(registryFile.toString()))) {
                String line;
                boolean found = false;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length > 0 && parts[0].trim().equalsIgnoreCase("Name")
                            && parts[1].trim().equalsIgnoreCase(animal.getName())) {
                        tempWriter.write(line + "\n");
                        tempWriter.write("Commands:\n");
                        for (String command : animal.commands) {
                            tempWriter.write("- " + command + "\n");
                        }
                        tempWriter.write("\n");
                        found = true;
                    } else {
                        tempWriter.write(line + "\n");
                    }
                }

                if (!found) {
                    view.displayErrorMessage("Animal not found in the registry.");
                    tempWriter.close();
                    Files.delete(tempFile);
                    return;
                }
            }

            tempWriter.close();

            // Удаление исходного файла и переименование временного файла
            Files.delete(registryFile);
            Files.move(tempFile, registryFile);

            // Обновление FileWriter на исходный файл
            fileWriter = new FileWriter(registryFile.toString(), true);
        } catch (IOException e) {
            view.displayErrorMessage("Failed to update animal commands in the file.");
        }
    }

    @Override
    public void close() throws Exception {
        counter.close();
        fileWriter.close();
    }
}