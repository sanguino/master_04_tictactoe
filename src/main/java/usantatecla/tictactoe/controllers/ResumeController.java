package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;

public class ResumeController extends Controller implements AcceptorController{

  public ResumeController(Session session) {
    super(session);
  }

  public void resume(Boolean isResumed) {
    if (isResumed) {
      this.session.reset();
    } else {
      this.session.next();
    }
  }

  @Override
  public void accept(ControllerVisitor controllerVisitor) {
    controllerVisitor.visit(this);
  }
}
