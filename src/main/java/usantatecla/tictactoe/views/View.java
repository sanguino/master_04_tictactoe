package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public abstract class View {

    public abstract void interact(StartController startController);
    public abstract void interact(PlayController playController);
    public abstract boolean interact(ResumeController resumeController);

}
