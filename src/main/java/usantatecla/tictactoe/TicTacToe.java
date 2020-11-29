package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.*;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.StateValue;
import usantatecla.tictactoe.views.console.View;

public abstract class TicTacToe {

    private Game game;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;
    private View view;

    protected TicTacToe() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        do {
            this.view.interact(this.startController);
            this.view.interact(this.playController);
        } while (this.view.interact(this.resumeController));
    }
}
