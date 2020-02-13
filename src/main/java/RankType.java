public enum RankType {
    ACE(false),
    TWO(false),
    THREE(false),
    FOUR(false),
    FIVE(false),
    SIX(false),
    SEVEN(false),
    EIGHT(false),
    NINE(false),
    TEN(false),
    JACK(true),
    QUEEN(true),
    KING(true);


    private final boolean isFaceCard;

    RankType(boolean isFaceCard){
        this.isFaceCard = isFaceCard;
    }

    public boolean getIsFaceCard() {
        return isFaceCard;
    }
}
