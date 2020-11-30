package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.Token;

public abstract class Controller {
    
    protected Session session;

	Controller(Session session) {
		this.session = session;
  }

	public Token getToken(Coordinate coordinate) {
		return this.session.getToken(coordinate);
	}
  
}
