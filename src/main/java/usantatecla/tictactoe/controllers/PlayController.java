package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;

public class PlayController extends Controller implements AcceptorController{

	public PlayController(Game game) {
		super(game);
	}

	public boolean isBoardComplete() {
		return this.game.isBoardComplete();
	}

	public boolean isTicTacToe() {
		return this.game.isTicTacToe();
	}

	public Token getToken() {
		return this.game.getToken();
	}

	public boolean isUser() {
		return this.game.isUser();
	}

	public Error put(Coordinate coordinate) {
		Error error = this.game.put(coordinate);
		if (error.isNull() && this.game.isTicTacToe()) {
			this.game.next();
		}
		return error;
	}

	public Error move(Coordinate origin, Coordinate target) {
		Error error = this.game.move(origin, target);
		if (error.isNull() && this.game.isTicTacToe()) {
			this.game.next();
		}
		return error;
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}
}
