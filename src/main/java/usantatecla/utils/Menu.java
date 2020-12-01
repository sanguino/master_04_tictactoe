package usantatecla.utils;

public abstract class Menu {

    public Menu() {

    }

    public void execute() {
        Console console = Console.getInstance();
        boolean error;
        do {
            error = false;
            console.writeln();

        } while (error);
    }

    protected void addCommand(Command command) {

    }
}
