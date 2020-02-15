import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    public Player person1;
    public Card cardTwo;
    public Card cardAce;
    public Card cardAce1;
    public Card cardTen;
    public Card cardEight;
    public Card cardNine;

    @Before
    public void before(){
        person1 = new Player("Bob");
        cardTwo = new Card(SuitType.HEART, RankType.TWO);
        cardAce = new Card(SuitType.HEART, RankType.ACE);
        cardAce1 = new Card(SuitType.DIAMOND, RankType.ACE);
        cardTen = new Card(SuitType.CLUB, RankType.TEN);
        cardEight = new Card(SuitType.DIAMOND, RankType.EIGHT);
        cardNine = new Card(SuitType.HEART, RankType.NINE);
    }

    @Test
    public void has_name(){
        assertEquals("Bob", person1.getName());
    }


    @Test
    public void starts_with_0_card(){
        assertEquals(0, person1.countHandCards());

    }

    @Test
    public void starts_with_is_busted_false(){
        assertEquals(false, person1.getIsBusted());
    }

    @Test
    public void starts_with_get_hand_value_0(){
        assertEquals(0, person1.countHandCards());
    }

//    cannot use it anymore, it's inside hand score
//    @Test
//    public void runningTotal_starts_0(){
//        assertEquals(0, person1.getRunningTotal());
//
//    }

    @Test
    public void get_hand_score_one_card(){
        person1.addToHand(cardTwo);
        assertEquals(2, person1.getHandScore());
    }

    @Test
    public void get_hand_score_two_cards(){
        person1.addToHand(cardTwo);
        person1.addToHand(cardAce);
        assertEquals(13, person1.getHandScore());
    }

    @Test
    public void get_hand_score_with_AAAT8(){
        person1.addToHand(cardAce);
        person1.addToHand(cardAce);
        person1.addToHand(cardAce1);
        person1.addToHand(cardTen);
        person1.addToHand(cardEight);
        assertEquals(21, person1.getHandScore());
    }

    @Test
    public void get_hand_score_with_AAAT9(){
        person1.addToHand(cardAce);
        person1.addToHand(cardAce);
        person1.addToHand(cardAce1);
        person1.addToHand(cardTen);
        person1.addToHand(cardNine);
        assertEquals(22, person1.getHandScore());
    }

    @Test
    public void is_busted_if_running_total_larger_than_21(){
        person1.addToHand(cardAce);
        person1.addToHand(cardAce);
        person1.addToHand(cardAce1);
        person1.addToHand(cardTen);
        person1.addToHand(cardNine);
        person1.getHandScore();
        assertEquals(true, person1.getIsBusted());
    }

    @Test
    public void is_not_busted_is_precisely_21(){
        person1.addToHand(cardAce);
        person1.addToHand(cardAce);
        person1.addToHand(cardAce1);
        person1.addToHand(cardTen);
        person1.addToHand(cardEight);
        person1.getHandScore();
        assertEquals(false, person1.getIsBusted());
    }

    @Test
    public void is_not_busted_if_lower_than_21(){
        person1.addToHand(cardTwo);
        person1.addToHand(cardAce);
        person1.getHandScore();
        assertEquals(false, person1.getIsBusted());
    }
}


