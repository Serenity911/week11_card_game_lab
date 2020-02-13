import java.util.ArrayList;

public class Game {
    private ArrayList<Person> players;
    private Deck deck;

    public Game() {
        this.players = new ArrayList<Person>();
        this.deck = new Deck();
    }

    public void addPlayer(String name){
        this.players.add(new Person(name));
    }

    public void prepareDeck(){
        this.deck.populateDeck();
        this.deck.shuffleDeck();
    }

    public void giveCards(){
        for (Person player : players) {
            player.addToHand(deck.dealCard());
        }
    }

    public Person findWinner(){
        int winningCard = 0;
        Person winner = new Person("WHATEVER");
        for (Person player : players) {
            int cardScore = Score.getValue(player.getCard());
            if (cardScore > winningCard) {
                winner = player;
            }
        }
        return winner;
    }
}
