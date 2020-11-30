package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.StateValue;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class LogicTest {

    @Mock
    private Session session;

    @InjectMocks
    private Logic logic;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    public void testGivenNewLogicWhenGetControllerThenIsStartController() {
        when(this.session.getValueState()).thenReturn(StateValue.INITIAL);
        assertThat(this.logic.getController(), instanceOf(StartController.class));
    }

    @Test
    public void testGivenNewLogicWhenGameNextAndGetControllerThenIsPlayController() {
        when(this.session.getValueState()).thenReturn(StateValue.IN_GAME);
        assertThat(logic.getController(), instanceOf(PlayController.class));
    }

}
