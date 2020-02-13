public class Runner {

    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer("Bob");
        game.addPlayer("Jill");
        game.prepareDeck();
        game.giveCards();
        for (Person player : game.getPlayers()) {
            System.out.println(""+ player.getCard().getRank() + " of " + player.getCard().getSuit());
        }
        Person winner = game.findWinner();
        System.out.println("the winner is: " + winner.getName());
        System.out.println(""+ winner.getName() + " has " + winner.getScore() + " points" );
        winner = game.newRound();
        System.out.println("the winner is: " + winner.getName());
        System.out.println(""+ winner.getName() + " has " + winner.getScore() + " points" );
    }
}
