import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public int countCards() {
        return cards.size();
    }

    public void populateDeck(){
        for (int i = 0; i < SuitType.values().length; i++){
            for (int j = 0; j < RankType.values().length; j++){
                this.cards.add(new Card(SuitType.values()[i], RankType.values()[j]));
            }
        }
    }
}
