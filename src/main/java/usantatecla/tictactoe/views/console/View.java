package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public class View extends usantatecla.tictactoe.views.View {

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;

	public View(StartController startController, PlayController playController, ResumeController resumeController) {
		this.startView = new StartView(startController);
		this.playView = new PlayView(playController);
		this.resumeView = new ResumeView(resumeController);
	}

	@Override
	public void start(){
		this.startView.interact();
	}

	@Override
	public void play(){
		this.playView.interact();
	}

	@Override
	public boolean isResumed(){
		return this.resumeView.interact();
	}
}
