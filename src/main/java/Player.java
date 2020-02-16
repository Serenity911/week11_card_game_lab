import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Person {

    private String name;
    private ArrayList<Card> aces;
    private boolean isStand;

    public Player(String name){
        this.name = name;
        this.aces = new ArrayList<Card>();
        this.isStand = false;

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

    public String getNextAction(Scanner scanner){
        if (!isBusted && !isStand) {
//            Scanner scanner = new Scanner(System.in);
            System.out.println("Player "+ this.getName() +": Stand or Twist?");
            String playerInput = scanner.next();
//            scanner.close();
            return playerInput;
        }
        else {
            return "no more round";
        }
    }

    public boolean doesPlayerTwist(String playerInput) {
        if(playerInput.equals("no more round")) {
            return false;
        }
        if(playerInput.equals("Stand")){
            this.chooseStand();
            return false;
        }
        if(playerInput.equals("Twist")) {
            return this.chooseTwist();
        }
        return false;
    }

    public boolean getIsStand() {
        return this.isStand;
    }

    public void chooseStand(){
        this.isStand = true;
    }

    public boolean chooseTwist(){
        if(!this.isBusted && !this.isStand){
            return true;
        }
        return false;
    }


}
