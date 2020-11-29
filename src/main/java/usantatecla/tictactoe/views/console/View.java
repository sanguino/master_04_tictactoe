package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.ControllerVisitor;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public class View extends usantatecla.tictactoe.views.View implements ControllerVisitor {

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

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);
	}

	@Override
	public void visit(PlayController playController) {
		this.playView.interact(playController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}
}
