package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Token;
import usantatecla.tictactoe.types.Error;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
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
        this.playCommand = spy(this.playCommand);
    }

    @Test
    void testGivenPlayCommandWhenIsActiveThenTrue() {
        assertTrue(playCommand.isActive());
    }

    @Test
    void testGivenPlayCommandWhenExecutePutThenGamePutCoordinate() {
        Coordinate coordinate = new Coordinate(0, 0);
        when(this.playController.put(any(Coordinate.class))).thenReturn(Error.NULL);
        doReturn(coordinate).when(this.playCommand).readCoordinate();
        this.playCommand.execute();
        verify(this.playController).put(coordinate);
    }


}
