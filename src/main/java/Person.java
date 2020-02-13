import java.util.ArrayList;

public class Person {

    private String name;
    private ArrayList<Card> card;
    private int score;

    public Person(String name) {
        this.name = name;
        this.card = new ArrayList<Card>(1);
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void addToHand(Card card){
        if (this.card.size() >= 1) {
            this.card.clear();
        }
        this.card.add(card);
    }

    public Card getCard() {
        return card.get(0);
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int point){
        this.score += point;
    }
}
