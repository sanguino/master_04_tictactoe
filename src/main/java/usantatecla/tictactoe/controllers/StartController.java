package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;

public class StartController extends Controller implements AcceptorController{

  public StartController(Game game) {
    super(game);
  }

  public void setUsers(int users) {
    this.game.setUsers(users);
  }

  public int getMaxPlayers() {
	return this.game.getMaxPlayers();
}

  @Override
  public void accept(ControllerVisitor controllerVisitor) {

  }
}
