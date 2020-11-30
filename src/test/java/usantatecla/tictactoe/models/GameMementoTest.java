package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class GameMementoTest {

    private Turn turn;
    private Board board;

    @BeforeEach
    void before() {
        this.board = new Board();
        this.turn = new Turn(this.board);
        this.turn.setUsers(2);
    }

    @Test
    void testGivenPlayerWhenCopyThenIsClone() {
        GameMemento gameMemento = new GameMemento(this.turn, this.board);

        assertFalse(this.board == gameMemento.getBoard());
        assertFalse(this.turn == gameMemento.getTurn());

    }


}
