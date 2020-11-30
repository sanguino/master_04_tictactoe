package usantatecla.tictactoe.models;

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
        return this.game.getValueState();
    }

    public void next() {
        this.game.next();
    }

    public void reset() {
        this.game.reset();
    }

    public void put(Coordinate coordinate) {
        this.game.put(coordinate);
    }

    public boolean isTicTacToe() {
        return false;
    }
}
