import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    public Game game;
    public Person player1;
//    public Dealer dealer;

    @Before
    public void before(){
        game = new Game();
        player1 = new Player("Bob");
//        dealer = new Dealer();
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

    @Test
    public void gives_two_cards_to_dealer_and_to_each_players_when_game_start(){
        game.prepareDeck();
        game.addPlayer("Jim");
        game.addPlayer("Alex");
        game.giveCards();
        player1 = game.getPlayers().get(0);
        Person player2 = game.getPlayers().get(1);
        Dealer dealer = game.getDealer();
        assertEquals(2, player1.countHandCards());
        assertEquals(2, player2.countHandCards());
        assertEquals(2, dealer.countHandCards());
    }

    @Test
    public void players_and_dealer_score_start_at_0(){
        game.prepareDeck();
        game.addPlayer("Jim");
        game.addPlayer("Alex");
        Person person1 = game.getPlayers().get(0);
        Person person2 = game.getPlayers().get(1);
        Dealer dealer = game.getDealer();
        int player1Score = game.getGameScores().get(person1);
        int player2Score = game.getGameScores().get(person2);
        int dealerScore = game.getGameScores().get(dealer);
        assertEquals(0, player1Score);
        assertEquals(0, player2Score);
        assertEquals(0, dealerScore);
    }


    @Test
    public void get_players_hands_score(){
        game.prepareDeck();
        game.addPlayer("Jim");
        game.addPlayer("Alex");
        game.giveCards();
        Player person1 = game.getPlayers().get(0);
        Player person2 = game.getPlayers().get(1);
        Dealer dealer = game.getDealer();
        int player1Score = game.getGameScores().get(person1);
        int player2Score = game.getGameScores().get(person2);
        int dealerScore = game.getGameScores().get(dealer);
        assertEquals(person1.getHandScore(), player1Score);
        assertEquals(person2.getHandScore(), player2Score);
//        assertEquals(dealer.getHandScore(), dealerScore);
    }

//    public void get_second_turn_not_busted_players(){
//        game.prepareDeck();
//        game.addPlayer("Jim");
//        game.addPlayer("Alex");
//        game.giveCards();
//        Player person1 = game.getPlayers().get(0);
//        Player person2 = game.getPlayers().get(1);
//        Dealer dealer = game.getDealer();
//        game.playersNextTurn();
//        player1.stand();
//        player2.twist();
//
//    }
}
