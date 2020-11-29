package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.*;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.StateValue;
import usantatecla.tictactoe.views.console.View;

public abstract class TicTacToe {

    private Logic logic;
    private View view;

    protected TicTacToe() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        AcceptorController controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
        } while (controller != null);
    }
}
