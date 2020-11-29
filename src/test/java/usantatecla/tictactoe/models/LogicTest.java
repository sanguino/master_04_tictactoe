package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.controllers.StartController;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogicTest {

    private Logic logic;

    @BeforeEach
    void before() {
        this.logic = new Logic();
    }

    @Test
    public void testGivenNewLogicWhenGetControllerThenIsStartController() {
        assertThat(logic.getController(), instanceOf(StartController.class));
    }

}
