package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.PlayController;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class PlayCommandTest {

    @InjectMocks
    private PlayCommand playCommand;

    @Mock
    private PlayController playController;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenPlayCommandWhenIsActiveThenTrue() {
        assertTrue(playCommand.isActive());
    }

}
