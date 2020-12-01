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
        }
    }

    Coordinate readCoordinate() {
        return new CoordinateView().read(Message.COORDINATE_TO_PUT.toString());
    }

    private void put() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = this.readCoordinate();
            error = this.playController.put(coordinate);
            new ErrorView(error).writeln();
        } while (!error.isNull());
    }

    @Override
    protected boolean isActive() {
        return true;
    }

}
