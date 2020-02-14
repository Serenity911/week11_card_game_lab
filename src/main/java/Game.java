import java.util.ArrayList;

public class Game {
    private ArrayList<Person> players;
    private Deck deck;


    public Game() {
        this.players = new ArrayList<Person>();
        this.deck = new Deck();
    }

    public ArrayList<Person> getPlayers() {
        return this.players;
    }

    public int countPlayers() {
        return this.players.size();
    }

    public void addPlayer(String name) {
        this.players.add(new Person(name));
    }

    public void prepareDeck() {
        this.deck.populateDeck();
        this.deck.shuffleDeck();
    }

    public void giveCards() {
        for (int i = 0; i < 2; i++) {
            for (Person player : players) {
                player.addToHand(deck.dealCard());
            }
        }
    }

}