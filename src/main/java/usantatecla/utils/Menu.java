package usantatecla.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

    private static final String OPTION = "Option? [1-#size]: ";
    private List<Command> commandList;

    public Menu() {
        this.commandList = new ArrayList<>();
    }

    public void execute() {
        int option;
        Console console = Console.getInstance();
        boolean error;
        do {
            error = false;
            console.writeln();
            for (int i = 0; i < commandList.size(); i++) {
                console.writeln((i + 1) + ") " + commandList.get(i).getTitle());
            }
            option = console.readInt(Menu.OPTION.replace("#size", "" + commandList.size())) - 1;
            if (!new ClosedInterval(0, commandList.size() - 1).isIncluded(option)) {
                error = true;
            }

        } while (error);
    }

    protected void addCommand(Command command) {
        this.commandList.add(command);
    }
}
