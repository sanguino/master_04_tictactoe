package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public class View extends usantatecla.tictactoe.views.View {

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;

	private StartController startController;
	private ResumeController resumeController;

	public View(StartController startController, PlayController playController, ResumeController resumeController) {
		this.startController = startController;
		this.resumeController = resumeController;
		this.startView = new StartView();
		this.playView = new PlayView(playController);
		this.resumeView = new ResumeView();
	}

	@Override
	public void start(){
		this.startView.interact(this.startController);
	}

	@Override
	public void play(){
		this.playView.interact();
	}

	@Override
	public boolean isResumed(){
		return this.resumeView.interact(this.resumeController);
	}
}
