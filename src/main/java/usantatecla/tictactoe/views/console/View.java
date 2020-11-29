package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public class View extends usantatecla.tictactoe.views.View {

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;

	public View() {
		this.startView = new StartView();
		this.playView = new PlayView();
		this.resumeView = new ResumeView();
	}

	@Override
	public void interact(StartController startController){
		this.startView.interact(startController);
	}

	@Override
	public void interact(PlayController playController){
		this.playView.interact(playController);
	}

	@Override
	public boolean interact(ResumeController resumeController){
		return this.resumeView.interact(resumeController);
	}
}
