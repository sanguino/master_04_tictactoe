package usantatecla.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

    private List<Command> commandList;

    public Menu() {
        this.commandList = new ArrayList<>();
    }

    public void execute() {
        Console console = Console.getInstance();
        boolean error;
        do {
            error = false;
            console.writeln();
            for (int i = 0; i < commandList.size(); i++) {
                console.writeln((i + 1) + ") " + commandList.get(i).getTitle());
            }

        } while (error);
    }

    protected void addCommand(Command command) {
        this.commandList.add(command);
    }
}
