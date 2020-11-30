package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.StateValue;

public class Session {

    private final State state;
    private final Game game;

    public Session() {
        this.state = new State();
        this.game = new Game();
    }

    public int getMaxPlayers() {
        return this.game.getMaxPlayers();
    }

    public void setUsers(int i) {
        this.game.setUsers(i);
    }

    public Token getToken(Coordinate coordinate) {
        return this.game.getToken(coordinate);
    }

    public Token getToken() {
        return this.game.getToken();
    }

    public boolean isBoardComplete() {
        return this.game.isBoardComplete();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public void next() {
        this.state.next();
    }

    public void reset() {
        this.game.reset();
        this.state.reset();
    }

    public Error put(Coordinate coordinate) {
        Error error = this.game.put(coordinate);
        return error;
    }

    public Error move(Coordinate origin, Coordinate target) {
        Error error = this.game.move(origin, target);
        return error;
    }

    public boolean isTicTacToe() {
        return this.game.isTicTacToe();
    }

    public boolean isUser() {
        return this.game.isUser();
    }

}
