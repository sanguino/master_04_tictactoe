package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import usantatecla.tictactoe.models.Session;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class StartControllerTest {

    @Spy
    private Session session;

    @InjectMocks
    private StartController startController;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    public void testGivenStartControllerWhenSerUsersThenGameNext() {
        this.startController.setUsers(anyInt());
        verify(session).setUsers(anyInt());
        verify(session).next();
    }
}
