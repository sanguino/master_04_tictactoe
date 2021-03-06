package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.Message;

class PlayCommand extends Command {

    PlayCommand(PlayController playController) {
        super(Message.ACTION_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        if (!playController.isBoardComplete()) {
            this.put();
        } else {
            this.move();
        }
        if (playController.isTicTacToe()) {
            this.showWinner();
        }
    }

    void showWinner() {
        new TokenView(playController.getToken()).write();
        Message.PLAYER_WIN.writeln();
    }

    Coordinate readCoordinate(String message) {
        return new CoordinateView().read(message);
    }

    private void put() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = this.readCoordinate(Message.COORDINATE_TO_PUT.toString());
            error = this.playController.put(coordinate);
            new ErrorView(error).writeln();
        } while (!error.isNull());
    }

    private void move() {
        Coordinate origin;
        Coordinate target;
        Error error;
        do {
            origin = this.readCoordinate(Message.COORDINATE_TO_REMOVE.toString());
            target = this.readCoordinate(Message.COORDINATE_TO_MOVE.toString());
            error = this.playController.move(origin, target);
            new ErrorView(error).writeln();
        } while (!error.isNull());
    }

    @Override
    protected boolean isActive() {
        return true;
    }

}
