public class Score {


    public static int getValue(Card card) {
        if (card.getRank() == RankType.ACE){
            return 11;
        } else if (card.hasFace()){
            return 10;
        } else {
            return card.getRank().ordinal() + 1;
        }
    }

}
