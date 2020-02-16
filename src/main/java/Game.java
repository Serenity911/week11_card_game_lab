import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players;
    private Deck deck;
    private Dealer dealer;
    private ArrayList<Person> dealerAndPlayers;

    public Game() {
        this.players= new ArrayList<Player>();
        this.dealer = new Dealer();
        this.deck = new Deck();
        this.dealerAndPlayers = new ArrayList<Person>();
        this.dealerAndPlayers.add(this.dealer);
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

    public ArrayList<Person> getDealerAndPlayers() {
        return this.dealerAndPlayers;
    }

    public void addPlayer(String name) {
        Player personToAdd = new Player(name);
        this.players.add(personToAdd);
        this.dealerAndPlayers.add(personToAdd);
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

    public void updateScores() {
        for (Person person: this.dealerAndPlayers) {
            person.getHandScore();
        }
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

    public void playersNextRound(Scanner scanner) {
        for (Player player : this.players) {
            if (!player.isBusted && !player.getIsStand()) {
                while (!player.isBusted && !player.getIsStand() && player.doesPlayerTwist(player.getNextAction(scanner))) {
                    this.extraCard(player);
                    this.updateScores();
                }
            }
        }
    }

    public Integer dealerNextRound() {
        Integer dealerScore = this.dealer.getHandScore();
        if(dealerScore <= 16) {
            this.dealer.addToHand(deck.dealCard());
        }

       return this.dealer.getHandScore();
    }



    public void nextRound(Scanner scanner) {
        this.playersNextRound(scanner);
        this.dealerNextRound();
        this.updateScores();
    }

    public Person findWinner() {
        int winningScore = 0;
        Person winner = null;
        for (Person person : this.dealerAndPlayers ) {
            if (!person.isBusted && person.getHandScore() >= winningScore) {
                winningScore = person.getHandScore();
                winner = person;
            }
        }

        return winner;
    }
}
