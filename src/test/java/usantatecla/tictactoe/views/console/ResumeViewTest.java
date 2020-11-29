package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Game;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class ResumeViewTest {

    private ResumeController resumeController;

    @Mock
    private Console console;

    @InjectMocks
    private ResumeView resumeView;

    @BeforeEach
    void before() {
        openMocks(this);
        this.resumeController = Mockito.mock(ResumeController.class);
    }

    @Test
    void testGivenNewGameIsFalseWhenInteractThenIsFalse() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.console.readChar(anyString())).thenReturn('n');
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.resumeView.interact(this.resumeController), is(false));
        }
    }

    @Test
    void testGivenNewGameIsTrueWhenInteractThenIsTrue() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.console.readChar(anyString())).thenReturn('y');
            this.resumeController.resume(true);
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.resumeView.interact(this.resumeController), is(true));
        }
    }
}
