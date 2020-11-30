package usantatecla.tictactoe.models;

import java.util.List;
import java.util.ArrayList;

class GameRegistry {

    private List<GameMemento> mementos;
    private Game game;
    private int firstPrevious;

    GameRegistry(Game game) {
        this.game = game;
        this.mementos = new ArrayList<GameMemento>();
        this.firstPrevious = 0;
        this.mementos.add(this.firstPrevious, this.game.createMemento());
    }

    void register() {
        for (int i = 0; i < this.firstPrevious; i++) {
            this.mementos.remove(0);
            this.firstPrevious--;
        }
        this.mementos.add(this.firstPrevious, this.game.createMemento());
    }

    void undo() {

    }

    void redo() {

    }

    boolean isUndoable() {
        return this.firstPrevious < this.mementos.size() - 1;
    }

}
