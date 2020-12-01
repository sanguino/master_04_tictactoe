package usantatecla.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class MenuConcrete extends Menu {

}

class CommandConcrete extends Command {

    protected CommandConcrete(String title) {
        super(title);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isActive() {
        return false;
    }
}

@ExtendWith(MockitoExtension.class)
public class MenuTest {

    @Mock
    private Console console;

    @InjectMocks
    private Menu menu = new MenuConcrete();

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenMenuWhenExecuteThenVerifyWritelnOneTime() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(1);
            this.menu.addCommand(new CommandConcrete("title"));
            this.menu.execute();
            verify(this.console).writeln();
            verify(this.console).writeln(anyString());
        }
    }

    @Test
    void testGivenMenuWhenExecuteThenVerifyWritelnTwoTimes() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(5).thenReturn(1);
            this.menu.addCommand(new CommandConcrete("title"));
            this.menu.execute();
            verify(this.console, times(2)).writeln();
            verify(this.console, times(2)).writeln(anyString());
        }
    }

    @Test
    void testGivenMenuWhenExecuteThenVerifyExecute() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(1);
            Command command = Mockito.spy(new CommandConcrete("title"));
            this.menu.addCommand(command);
            this.menu.execute();
            verify(command).execute();
        }
    }
}