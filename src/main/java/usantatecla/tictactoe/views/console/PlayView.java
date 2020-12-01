package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.types.Error;

class PlayView {

    private PlayController playController;

    void interact(PlayController playController) {
        this.playController = playController;
        if (playController.isUser()) {
            this.showPlayMenu();
        } else {
            this.randomPlay();
        }

        this.showGameView();
    }

    void showGameView() {
        new GameView(this.playController).write();
    }

    void showPlayMenu() {
        new PlayMenu(this.playController).execute();
    }

    private void randomPlay() {
        Error error;
        Coordinate target;
        do {
            target = new Coordinate();
            target.random();
            if (!this.playController.isBoardComplete()) {
                error = this.playController.put(target);
            } else {
                Coordinate origin = new Coordinate();
                origin.random();
                error = this.playController.move(origin, target);
            }
        } while (!error.isNull());
    }

}
