package usantatecla.tictactoe.models;

public class Session {

    private final State state;
    private final Game game;

    public Session() {
        this.state = new State();
        this.game = new Game();
    }

    public int getMaxPlayers() {
        return 0;
    }

    public void setUsers(int i) {
        this.game.setUsers(i);
    }
}
