import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Вася", 80);
    Player player2 = new Player(2, "Коля", 100);
    Player player3 = new Player(3, "Петя", 99);
    Player player4 = new Player(4, "Миша", 99);
    Player player5 = new Player(5, "Вова", 50);

    @Test
    public void mustWinTheSecondOne() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 2;
        int actual = game.round("Вася", "Коля");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mustWinFirst() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 1;
        int actual = game.round("Миша", "Вова");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void thereshouldBeDraw() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 0;
        int actual = game.round("Миша", "Петя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void thereIsNoRegistrationOfTheFirstPlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Гриша", "Петя");
        });
    }

    @Test
    public void thereIsNoRegistrationOfTheSecondPlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Миша", "Гриша");
        });
    }

    @Test
    public void thereIsNoRegistrationForTwoPlayers() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Гриша");
        });
    }
}
