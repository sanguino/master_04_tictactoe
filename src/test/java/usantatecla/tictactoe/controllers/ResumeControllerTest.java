package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import usantatecla.tictactoe.models.Game;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class ResumeControllerTest {

    @Spy
    private Game game;

    @InjectMocks
    private ResumeController resumeController;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    public void testGivenResumeControllerWhenResumeTrueThenGameReset() {
        this.resumeController.resume(true);
        verify(game).reset();
    }

    @Test
    public void testGivenResumeControllerWhenResumeFalseThenGameNext() {
        this.resumeController.resume(false);
        verify(game).next();
    }
}
