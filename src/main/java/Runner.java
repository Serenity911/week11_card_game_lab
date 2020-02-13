public class Runner {

    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer("Bob");
        game.addPlayer("Jill");
        game.prepareDeck();
        game.giveCards();
        Person winner = game.findWinner();
        System.out.println(winner.getName());


    }
}
