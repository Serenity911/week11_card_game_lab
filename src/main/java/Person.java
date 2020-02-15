import java.util.ArrayList;
import java.util.Comparator;

public class Person {

    protected ArrayList<Card> hand;
    protected boolean isBusted;
//    protected int runningTotal;


    public Person() {
        this.hand = new ArrayList<Card>();
//        this.runningTotal = 0;
        this.isBusted = false;
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

//    public int getRunningTotal() {
//        return this.runningTotal;
//    }

    public boolean getIsBusted() {
        return this.isBusted;
    }



    public boolean checkIfBusted(int runningTotal){
        return this.isBusted = runningTotal > 21;
    }
}
