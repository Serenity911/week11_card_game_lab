public class Card {

    private RankType rank;
    private SuitType suit;

    public Card(SuitType suit, RankType rank){
        this.rank = rank;
        this.suit = suit;
    }

    public SuitType getSuit(){
        return suit;
    }

    public RankType getRank() {
        return rank;
    }

    public boolean hasFace() {
        return rank.getIsFaceCard();
    }

}
