package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Token;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class StartViewTest {

    private StartController startController;

    @InjectMocks
    private StartView startView;

    @Mock
    private Console console;

    @BeforeEach
    void before() {
        openMocks(this);
        this.startController = Mockito.mock(StartController.class);
    }

    @Test
    void testGivenNewStartViewWhenReadNumberOfUsersThenGameSetNumberOfUsers() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.startController.getMaxPlayers()).thenReturn(2);
            when(this.startController.getToken(any(Coordinate.class))).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.startView.interact(this.startController);
            verify(this.console).writeln(Message.TITLE.toString());
            verify(this.startController).setUsers(1);
        }
    }
}
