import org.junit.Before;
import org.junit.Test;

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

    }

}
