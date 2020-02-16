import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Person {

    private String name;
    private ArrayList<Card> aces;

    public Player(String name){
        this.name = name;
        this.aces = new ArrayList<Card>();

    }

    public String getName() {
        return this.name;
    }

    public int getHandScore(){
        int runningTotal = 0;
        for (Card card : getHand()) {
            if( card.getRank() == RankType.ACE  ) {
                this.aces.add(card);
            }
            runningTotal += Score.getValue(card);
        }
        while (runningTotal > 21 && this.aces.size() >0) {
            runningTotal -= 10;
            this.aces.remove(0);
        }
        checkIfBusted(runningTotal);
        return runningTotal;
    }

    public String getNextAction(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Stand or Twist?");
        String playerInput = scanner.nextLine();
        scanner.close();
        return playerInput;
    }

//    public String getNextAction() {
//
//    }

    public boolean chooseStand(){
        return true;
    }

    public void chooseTwist(){

    }


}
