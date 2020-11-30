package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import usantatecla.tictactoe.models.Session;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class ResumeControllerTest {

    @Spy
    private Session session;

    @InjectMocks
    private ResumeController resumeController;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    public void testGivenResumeControllerWhenResumeTrueThenGameReset() {
        this.resumeController.resume(true);
        verify(session).reset();
    }

    @Test
    public void testGivenResumeControllerWhenResumeFalseThenGameNext() {
        this.resumeController.resume(false);
        verify(session).next();
    }
}
