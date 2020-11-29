package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public abstract class View {

    public abstract void start(StartController startController);
    public abstract void play(PlayController playController);
    public abstract boolean isResumed(ResumeController resumeController);

}
