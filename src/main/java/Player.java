import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Person {

    private boolean isStand;

    public Player(String name){
        this.isStand = false;
        this.name = name;
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
        if(playerInput.toLowerCase().equals("stand")){
            this.chooseStand();
            return false;
        }
        if(playerInput.toLowerCase().equals("twist")) {
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
