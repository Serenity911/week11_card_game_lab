import java.util.ArrayList;

public class Game {
    private ArrayList<Person> players;
    private Deck deck;
    private ArrayList<Card> dealerHand;


    public Game() {
        this.players = new ArrayList<Person>();
        this.deck = new Deck();
        this.dealerHand = new ArrayList<Card>();
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
}