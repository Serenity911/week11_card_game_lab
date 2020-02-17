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
        System.out.println("Dealer's first card: " + game.getDealer().getHand().get(0));

        for (Player player : game.getPlayers()) {
            System.out.println("Player " + player.getName() + " score: " + player.getHandScore());
            System.out.println("Player " + player.getName() + " cards: " + player.getHand());
        }

        game.updateScores();
        game.nextRound(scanner);
        for (Person person : game.getDealerAndPlayers()) {
            System.out.println("Person " + person.getName() + " score: " + person.getHandScore());
            System.out.println("Person " + person.getName() + " cards: " + person.getHand());
        }

        System.out.println("Dealer's score: " + game.getDealer().getHandScore());

        System.out.println("The winner is...:");
        System.out.println(game.findWinner().getName());

    }
}
