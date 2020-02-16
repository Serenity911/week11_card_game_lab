import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players;
    private Deck deck;
    private Dealer dealer;
    private HashMap<Person, Integer> gameScores;

    public Game() {
        this.players= new ArrayList<Player>();
        this.dealer = new Dealer();
        this.deck = new Deck();
        this.gameScores = new HashMap<Person, Integer>();
        this.gameScores.put(dealer, 0);

    }

    public ArrayList<Player> getPlayers() {
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
            for (Player player : this.players) {
                player.addToHand(deck.dealCard());
            }
            this.dealer.addToHand(deck.dealCard());
        }
        return this.dealer.getHand().get(0);
    }

    public HashMap<Person, Integer> getGameScores() {
        for (Player player: this.players) {
            this.gameScores.put(player, player.getHandScore());
        }
        return this.gameScores;
    }

    public void extraCard(Player player){
        if (!player.isBusted && !player.getIsStand()){
            Card newCard = deck.dealCard();
            System.out.println(newCard.getRank());
            player.addToHand(newCard);
            System.out.println("Player " +player.getName() +" score: " + player.getHandScore());

        }
        else {
            return;
        }
    }

    public void nextRound(Scanner scanner) {
        for (Player player : this.players) {
            if (!player.isBusted && !player.getIsStand()) {
                while(!player.isBusted && !player.getIsStand() && player.doesPlayerTwist(player.getNextAction(scanner))) {
                    this.extraCard(player);
                    this.getGameScores();
                }
                this.getGameScores();
            }
        }
    }



}