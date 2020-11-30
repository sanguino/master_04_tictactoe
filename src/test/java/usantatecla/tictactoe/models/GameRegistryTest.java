package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testGivenGameRegistryWhenRegistryAndIsUndoableThenTrue() {
        this.registry.register();
        assertTrue(this.registry.isUndoable());
    }
}
