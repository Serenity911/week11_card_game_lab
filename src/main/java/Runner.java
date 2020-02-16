import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Game game = new Game();

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players would you like to play?");
        int numberPlayer = scanner.nextInt();
        for (int i = 0; i < numberPlayer ; i++) {
            System.out.println("Player's "+ (i+1) + " name:");
            game.addPlayer(scanner.next());
        }
        System.out.println("Shuffling..");
        game.prepareDeck();
        game.giveCards();
        for (Player player : game.getPlayers()) {
            System.out.println("Player " + player.getName() + " score: " + player.getHandScore());
            System.out.println("Player " + player.getName() + " cards: " + player.getHand());
        }
        game.getGameScores();
        game.nextRound(scanner);
        for (Player player : game.getPlayers()) {
            System.out.println("Player " + player.getName() + " score: " + player.getHandScore());
            System.out.println("Player " + player.getName() + " cards: " + player.getHand());
        }

//        System.out.println(game.getPlayers()[0].getHandValue());


//        for (Person player : game.getPlayers()) {
//            System.out.println(""+ player.getHand().getRank() + " of " + player.getHand().getSuit());
//        }
//        Person winner = game.findWinner();
//        System.out.println("the winner is: " + winner.getName());
//        System.out.println(""+ winner.getName() + " has " + winner.getScore() + " points" );
//        winner = game.newRound();
//        System.out.println("the winner is: " + winner.getName());
//        System.out.println(""+ winner.getName() + " has " + winner.getScore() + " points" );
    }
}
