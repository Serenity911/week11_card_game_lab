import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private ArrayList<Person> players;
    private Deck deck;
    private ArrayList<Card> dealerHand;


    private HashMap<Person, Integer> gameScores;

    public Game() {
        this.players = new ArrayList<Person>();
        this.deck = new Deck();
        this.dealerHand = new ArrayList<Card>();
        this.gameScores = new HashMap<Person, Integer>();
    }

    public ArrayList<Person> getPlayers() {
        return this.players;
    }

    public int countPlayers() {
        return this.players.size();
    }

    public void addPlayer(String name) {
        Person personToAdd = new Person(name);
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
            this.dealerHand.add(deck.dealCard());
        }
        return this.dealerHand.get(0);
    }

    public ArrayList<Card> getDealerHand() {
        return this.dealerHand;
    }

    public int countDealerHand(){
        return this.dealerHand.size();
    }

    public HashMap<Person, Integer> getGameScores() {
        return this.gameScores;
    }
}