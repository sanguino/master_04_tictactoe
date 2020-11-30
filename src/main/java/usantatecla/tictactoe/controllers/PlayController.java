package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.Token;
import usantatecla.tictactoe.types.Error;

public class PlayController extends Controller implements AcceptorController{

	private ActionController actionController;
	private UndoController undoController;
	private RedoController redoController;

	public PlayController(Session session) {
		super(session);
		this.actionController = new ActionController(session);
		this.undoController = new UndoController(session);
		this.redoController = new RedoController(session);
	}

	public boolean isBoardComplete() {
		return this.actionController.isBoardComplete();
	}

	public boolean isTicTacToe() {
		return this.actionController.isTicTacToe();
	}

	public Token getToken() {
		return this.actionController.getToken();
	}

	public boolean isUser() {
		return this.actionController.isUser();
	}

	public Error put(Coordinate coordinate) {
		return this.actionController.put(coordinate);
	}

	public Error move(Coordinate origin, Coordinate target) {
		return this.actionController.move(origin, target);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}
}
