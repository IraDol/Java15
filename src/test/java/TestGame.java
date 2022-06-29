import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class TestGame {
    Collection<Player> testGame = new ArrayList<>();
    Game game = new Game();
    // TestGame testGame = new TestGame();
    Player player1 = new Player(1, "First", 4);
    Player player2 = new Player(2, "Second", 7);
    Player player3 = new Player(3, "Third", 3);
    Player player4 = new Player(4, "Forth", 4);

    @Test
    public void shouldFindByName() {
        game.register(player1);
        game.register(player2);

        int actual = game.findByName("First");
        int expected = 0;
        assertEquals(expected, actual);
    }


    @Test
    public void shouldFindByNotRegisteredName() {
        game.register(player1);
        game.register(player2);

        int actual = game.findByName("player3");

        int expected = -1;
        assertEquals(expected, actual);


    }

    @Test
    public void exceptionWhenOnePlayerNotRegistered() {
        game.register(player1);
        game.register(player2);

        int expected = -1;
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Second", "Third");
        });


    }
    @Test
    public void exceptionWhenBothPlayerNotRegistered() {
        game.register(player1);
        game.register(player2);

        int expected = -1;
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Forth", "Third");
        });


    }
    @Test
    public void exceptionWhenEmptyRegisteredField() {

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Forth", "Six");
        });


    }


    @Test
    public void whenWinnerIsPlayer1() {
        game.register(player1);
        game.register(player3);

        int actual = game.round("First", "Third");

        int expected = 1;
        assertEquals(expected, actual);


    }

    @Test
    public void whenWinnerIsPlayer2() {
        game.register(player1);
        game.register(player2);

        int actual = game.round("First", "Second");

        int expected = 2;
        assertEquals(expected, actual);


    }
    @Test
    public void whenStrengthSame() {
        game.register(player1);
        game.register(player4);


        int actual = game.round("First", "Forth");

        int expected = 0;
        assertEquals(expected, actual);


    }

}
