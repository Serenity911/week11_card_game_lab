import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreTest {

    public Card aceCard;
    public Card threeCard;
    public Card queenCard;

    @Before
    public void before(){
        aceCard = new Card(SuitType.HEART, RankType.ACE);
        threeCard = new Card(SuitType.CLUB, RankType.THREE);
        queenCard = new Card(SuitType.CLUB, RankType.QUEEN);
    }

    @Test
    public void aceCardIsWorthEleven(){
        assertEquals(11, Score.getValue(aceCard));
    }

    @Test
    public void threeCardIsWorthThree(){
        assertEquals(3, Score.getValue(threeCard));
    }

    @Test
    public void queenCardIsWorthTen(){
        assertEquals(10, Score.getValue(queenCard));
    }

}
