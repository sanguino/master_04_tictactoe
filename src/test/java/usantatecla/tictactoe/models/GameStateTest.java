package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.StateValue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStateTest {

    @Test
    public void testGivenNewStateWhenGetValueStateThenIsInitial() {
        Game game = new GameBuilder().build();
        assertEquals(StateValue.INITIAL, game.getValueState());
    }

}
