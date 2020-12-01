package usantatecla.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class MenuConcrete extends Menu {

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
    void testGivenNewCoordinateViewWhenReadCoordinateThenReturnCoordinate() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.menu.execute();
            verify(this.console).writeln();
        }
    }
}