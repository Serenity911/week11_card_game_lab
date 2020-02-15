import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private ArrayList<Person> players;
    private Deck deck;
    private Dealer dealer;


    private HashMap<Person, Integer> gameScores;

    public Game() {
        this.players= new ArrayList<Person>();
        this.dealer = new Dealer();
        this.deck = new Deck();
        this.gameScores = new HashMap<Person, Integer>();
        this.gameScores.put(dealer, 0);

    }

    public ArrayList<Person> getPlayers() {
        return this.players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public int countPlayers() {
        return this.players.size();
    }


    public void addPlayer(String name) {
        Player personToAdd = new Player(name);
        this.players.add(personToAdd);
        this.gameScores.put(personToAdd, 0);
    }

    public void prepareDeck() {
        this.deck.populateDeck();
        this.deck.shuffleDeck();
    }

//    not sure if dealer gets the card first or not
    public Card giveCards() {
        for (int i = 0; i < 2; i++) {
            for (Person player : players) {
                player.addToHand(deck.dealCard());
            }
            this.dealer.addToHand(deck.dealCard());
        }
        return this.dealer.getHand().get(0);
    }

    public HashMap<Person, Integer> getGameScores() {
        return this.gameScores;
    }
}