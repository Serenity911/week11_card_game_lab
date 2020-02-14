import java.util.ArrayList;
import java.util.Comparator;

public class Person {

    private String name;
    private ArrayList<Card> hand;
    private ArrayList<Card> aces;
    private boolean isBusted;
    private int runningTotal;



    public Person(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.runningTotal = 0;
        this.isBusted = false;
        this.aces = new ArrayList<Card>();
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

    public int getRunningTotal() {
        return this.runningTotal;
    }

    public boolean getIsBusted() {
        return this.isBusted;
    }

    public int getHandScore(){
        for (Card card : this.hand) {
            if( card.getRank() == RankType.ACE  ) {
                this.aces.add(card);
            }
            this.runningTotal += Score.getValue(card);
        }
       while (this.runningTotal > 21 && this.aces.size() >0) {
           this.runningTotal -= 10;
           this.aces.remove(0);
        }
        this.checkIfBusted();
        return this.runningTotal;
    }

    public boolean checkIfBusted(){
        return this.isBusted = this.runningTotal > 21;
    }
}
