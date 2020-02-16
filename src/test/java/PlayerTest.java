import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    public Player player1;
    public Card cardTwo;
    public Card cardAce;

    @Before
    public void before(){
        player1 = new Player("Bob");
        cardTwo = new Card(SuitType.HEART, RankType.TWO);
        cardAce = new Card(SuitType.HEART, RankType.ACE);

    }

    @Test
    public void can_stand(){
        player1.addToHand(cardAce);
        player1.addToHand(cardTwo);
        player1.chooseStand();
        assertEquals(2, player1.countHandCards());
        assertEquals(true, player1.getDoesStand());

    }

    @Test
    public void can_twist(){
        player1.addToHand(cardAce);
        player1.addToHand(cardTwo);
        player1.chooseTwist();
        assertEquals(3, player1.countHandCards());
    }

    @Test
    public void cannot_twist_if_stand(){
        player1.addToHand(cardAce);
        player1.addToHand(cardTwo);
        player1.chooseStand();
        player1.chooseTwist();
        assertEquals(2, player1.countHandCards());
    }

    @Test
    public void asks_input(){
        String input = "test";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String personInput = player1.getNextAction();
        assertEquals("test", personInput );
    }

    @Test
    public void do_not_ask_input_if_stand(){
//        String input = "test";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
        player1.addToHand(cardAce);
        player1.addToHand(cardTwo);
        player1.chooseStand();
        String personInput = player1.getNextAction();
        assertEquals("no more round", personInput );
    }

}

