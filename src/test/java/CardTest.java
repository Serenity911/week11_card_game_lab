import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    Card card;

    @Before
    public void before(){
        card = new Card(SuitType.HEART, RankType.FIVE);
    }

    @Test
    public void cardHasSuit(){
        assertEquals(SuitType.HEART, card.getSuit());
    }

    @Test
    public void cardHasRank(){
        assertEquals(RankType.FIVE, card.getRank());
    }

    @Test
    public void cardHasFace() {
        card = new Card(SuitType.HEART, RankType.QUEEN);
        assertEquals(true, card.hasFace());
    }
}
