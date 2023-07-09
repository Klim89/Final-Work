import java.util.ArrayList;
import java.util.List;

class Animals {
    protected String name;
    protected List<String> commands;

    public Animals(String name) {
        this.name = name;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void displayCommands() {
        if (commands.isEmpty()) {
            System.out.println("No available commands for this animal.");
        } else {
            System.out.println("Commands for " + name + ":");
            for (String command : commands) {
                System.out.println("- " + command);
            }
        }
    }

    public String[] getCommands() {
        return null;
    }
}
