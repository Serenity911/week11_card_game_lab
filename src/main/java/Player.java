import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Person {

    private String name;
    private ArrayList<Card> aces;
    private boolean stand;

    public Player(String name){
        this.name = name;
        this.aces = new ArrayList<Card>();
        this.stand = false;

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
        if (!isBusted && !stand) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Stand or Twist?");
            String playerInput = scanner.nextLine();
            scanner.close();
            return playerInput;
        }
        else {
            return "no more round";
        }
    }

    public void playAction(String playerInput) {
        if(playerInput == "no more round") {
            return;
        }
        if(playerInput == "Stand"){
            this.chooseStand();
        }
        if(playerInput == "Twist") {
            this.chooseTwist();
        }
        else {
            System.out.println("Invalid, try again.");
            this.getNextAction();
        }
    }

    public boolean getDoesStand() {
        return this.stand;
    }

    public boolean chooseStand(){
        this.stand = true;
        return true;
    }

    public void chooseTwist(){

    }


}
