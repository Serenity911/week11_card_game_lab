import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    public Deck deck;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void deckStartsEmpty(){
        assertEquals(0, deck.countCards());
    }

    @Test
    public void canPopulateDeck(){
        deck.populateDeck();
        assertEquals(52, deck.countCards());
    }

    @Test
    public void canDealCard(){
        deck.populateDeck();
//        deck.dealCard();
        assertEquals(RankType.ACE,deck.dealCard().getRank());
        assertEquals(51, deck.countCards());
    }
}

