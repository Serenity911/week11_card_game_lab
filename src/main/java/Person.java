import java.util.ArrayList;
import java.util.Comparator;

public class Person {

    protected ArrayList<Card> hand;
    protected boolean isBusted;
    protected String name;




    public Person() {
        this.hand = new ArrayList<Card>();
        this.isBusted = false;
    }

    public String getName() {
        return this.name;
    }

    public void addToHand(Card card){
        this.hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public int countHandCards(){
        return getHand().size();
    }

    public int getHandScore(){
        ArrayList<Card> aces = new ArrayList<Card>();
        int runningTotal = 0;
        for (Card card : getHand()) {
            if( card.getRank() == RankType.ACE  ) {
                aces.add(card);
            }
            runningTotal += Score.getValue(card);
        }
        while (runningTotal > 21 && aces.size() >0) {
            runningTotal -= 10;
            aces.remove(0);
        }
        checkIfBusted(runningTotal);
        return runningTotal;
    }

    public boolean getIsBusted() {
        return this.isBusted;
    }



    public boolean checkIfBusted(int runningTotal){
        return this.isBusted = runningTotal > 21;
    }
}
