package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameRegistryTest {

    private Game game;
    private GameRegistry registry;

    @BeforeEach
    void before() {
        this.game = new Game();
        this.game.setUsers(2);
        this.registry = new GameRegistry(this.game);
    }

    @Test
    void testGivenGameRegistryWhenIsUndoableThenFalse() {
        assertFalse(this.registry.isUndoable());
    }
}
