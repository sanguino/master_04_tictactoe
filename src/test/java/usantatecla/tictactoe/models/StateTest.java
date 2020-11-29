package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.StateValue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateTest {
    
    private State state;

    @BeforeEach
    void before() {
        this.state = new State();
    }

    @Test
    public void testGivenNewStateWhenGetValueStateThenIsInitial() {
        assertEquals(StateValue.INITIAL, this.state.getValueState());
    }

    @Test
    public void testGivenNewStateWhenDoNextAndGetValueStateThenIsInGame() {
        this.state.next();
        assertEquals(StateValue.IN_GAME, this.state.getValueState());
    }

    @Test
    public void testGivenNewStateWhenDoTwoNextAndGetValueStateThenIsResult() {
        this.state.next();
        this.state.next();
        assertEquals(StateValue.RESUME, this.state.getValueState());
    }

    @Test
    public void testGivenNewStateWhenDoThreeNextAndGetValueStateThenIsExit() {
        this.state.next();
        this.state.next();
        this.state.next();
        assertEquals(StateValue.EXIT, this.state.getValueState());
    }

}