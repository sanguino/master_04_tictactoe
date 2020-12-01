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

    }

    @Override
    protected boolean isActive() {
        return true;
    }

}
