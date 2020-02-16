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

//    every class has a method toString that print the name of the class and a unique identifier for the instance. It can be overridden to make it print anything else. Since it makes more sense to have the rank instead of Card@123456, it returns the ranktype but converted in string.
    @Override
    public String toString() {
        return this.getRank().toString();
    }
}
