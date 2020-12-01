package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.models.Token;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    private PlayController playController;

    @InjectMocks
    private PlayView playView;

    @Mock
    private Console console;

    @BeforeEach
    void before() {
        openMocks(this);
        this.playView = spy(this.playView);
        this.playController = Mockito.mock(PlayController.class);
    }

    @Test
    void testGivenNewPlayViewWhenUserPlayerPutCoordinateThenGamePutCoordinate() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.playController.isUser()).thenReturn(true);
            doNothing().when(this.playView).showPlayMenu();
            doNothing().when(this.playView).showGameView();
            this.playView.interact(this.playController);
            verify(this.playView).showPlayMenu();
            verify(this.playView).showGameView();
        }

    }

    @Test
    void testGivenNewPlayViewWhenMachinePlayerPutCoordinateThenGamePutCoordinate() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.playController.isBoardComplete()).thenReturn(false);
            when(this.playController.isUser()).thenReturn(false);
            when(this.playController.put(any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.playController.getToken(any(Coordinate.class))).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact(this.playController);
            verify(this.playController).put(any(Coordinate.class));
        }
    }

    @Test
    void testGivenNewPlayViewWhenMachinePlayerMoveOriginToTargetThenGameMoveOriginToTarget() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.playController.isBoardComplete()).thenReturn(true);
            when(this.playController.isUser()).thenReturn(false);
            when(this.playController.move(any(Coordinate.class), any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.playController.getToken(any(Coordinate.class))).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact(this.playController);
            verify(this.playController).move(any(Coordinate.class), any(Coordinate.class));
        }
    }

}
