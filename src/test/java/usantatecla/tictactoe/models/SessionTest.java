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
    }

}
