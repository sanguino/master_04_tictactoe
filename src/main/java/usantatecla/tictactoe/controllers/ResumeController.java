package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;

public class ResumeController extends Controller implements AcceptorController{

  public ResumeController(Game game) {
    super(game);
  }

  public void resume(Boolean isResumed) {
    if (isResumed) {
      this.game.reset();
    } else {
      this.game.next();
    }
  }

  @Override
  public void accept(ControllerVisitor controllerVisitor) {
    controllerVisitor.visit(this);
  }
}
