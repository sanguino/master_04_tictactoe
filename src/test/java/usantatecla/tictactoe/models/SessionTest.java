package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.StateValue;

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
        assertFalse(this.session.undoable());
    }

    @Test
    public void testGivenSessionWhenMultiplyNextThenExit() {
        this.session.setUsers(1);
        assertEquals(StateValue.INITIAL, this.session.getValueState());
        this.session.next();
        assertEquals(StateValue.IN_GAME, this.session.getValueState());
        this.session.next();
        assertEquals(StateValue.RESUME, this.session.getValueState());
        this.session.next();
        assertEquals(StateValue.EXIT, this.session.getValueState());
    }

    @Test
    public void testGivenSessionWhenResetThenInitial() {
        this.session.setUsers(1);
        assertEquals(StateValue.INITIAL, this.session.getValueState());
        this.session.next();
        assertEquals(StateValue.IN_GAME, this.session.getValueState());
        this.session.next();
        assertEquals(StateValue.RESUME, this.session.getValueState());
        this.session.reset();
        assertEquals(StateValue.INITIAL, this.session.getValueState());
    }

    @Test
    public void testGivenSessionWhenPutMainDiagonalTokensThenTrue(){
        this.session.setUsers(0);
        assertEquals(Token.X, this.session.getToken());
        this.session.put(new Coordinate(0,0));
        assertEquals(Token.O, this.session.getToken());
        this.session.put(new Coordinate(0,1));
        assertEquals(Token.X, this.session.getToken());
        this.session.put(new Coordinate(1,1));
        assertEquals(Token.O, this.session.getToken());
        this.session.put(new Coordinate(1,2));
        assertEquals(Token.X, this.session.getToken());
        this.session.put(new Coordinate(2,2));
        assertEquals(Token.X, this.session.getToken());
        assertTrue(this.session.isTicTacToe());
    }

    @Test
    public void testGivenSessionWhenMoveThenErrorNull(){
        this.session.setUsers(2);
        this.session.put(new Coordinate(0,0));
        this.session.put(new Coordinate(0,1));
        Error error = this.session.move(new Coordinate(0,0), new Coordinate(0,2));
        assertEquals(error, Error.NULL );
    }

    @Test
    public void testGivenSessionWhenIsUserThenTrue() {
        this.session.setUsers(2);
        assertTrue(this.session.isUser());
    }

    @Test
    public void testGivenSessionWhenPutThenRegistryIsUndoable() {
        this.session.setUsers(2);
        this.session.put(new Coordinate(0,0));
        assertTrue(this.session.undoable());
    }

    @Test
    public void testGivenSessionWhenPutThenRegistryIsNotredoable() {
        this.session.setUsers(2);
        this.session.put(new Coordinate(0,0));
        assertFalse(this.session.redoable());
    }

    @Test
    public void testGivenSessionWhenPutThenRegistryAndUndoIsUndoableFalse() {
        this.session.setUsers(2);
        this.session.put(new Coordinate(0,0));
        this.session.undo();
        assertFalse(this.session.undoable());
    }

    @Test
    public void testGivenSessionWhenPutThenRegistryAndUndoAndRedoIsUndoableFalse() {
        this.session.setUsers(2);
        this.session.put(new Coordinate(0,0));
        this.session.undo();
        this.session.redo();
        assertTrue(this.session.undoable());
    }


}
