package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SessionTest {

    private Session session;

    @BeforeEach
    void before() {
        this.session = new Session();
    }

    @Test
    public void testGivenSessionWhenBornThenInitialValues() {
        this.session.setUsers(2);
        assertEquals(2, this.session.getMaxPlayers());

        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                assertEquals(Token.NULL, this.session.getToken(new Coordinate(i, j)));
            }
        }

        assertFalse(this.session.isBoardComplete());
    }

}
