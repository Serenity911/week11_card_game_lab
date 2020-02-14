import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    public Game game;
    public Person player1;

    @Before
    public void before(){
        game = new Game();
        player1 = new Person("Bob");
    }

    @Test
    public void starts_0_players(){
        assertEquals(0, game.countPlayers());
    }

    @Test
    public void can_add_players(){
        game.addPlayer("Jill");
        assertEquals(1, game.countPlayers());
    }

    @Test
    public void gives_two_cards_to_each_player_when_game_start(){
        game.prepareDeck();
        game.addPlayer("Jim");
        game.addPlayer("Alex");
        game.giveCards();
        player1 = game.getPlayers().get(0);
        Person player2 = game.getPlayers().get(1);
        assertEquals(2, player1.countHandCards());
        assertEquals(2, player2.countHandCards());
    }

//    @Test
//    public void get_players_hands_score(){
//        game.prepareDeck();
//        game.addPlayer("Jim");
//        game.addPlayer("Alex");
//        game.giveCards();
//        player1 = game.getPlayers().get(0);
//        Person player2 = game.getPlayers().get(1);
//        game.
//    }
}
