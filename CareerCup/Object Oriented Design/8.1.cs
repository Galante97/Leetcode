//Design a data structure for a generic deck of cards. Explain how you would subclass the data structures to implement black jack 
//Q: is this a standard deck of 52 cards? - YES


public enum Suit
{
    DIAMOND,
    SPADE,
    CLUB,
    HEART
}

public class Deck : Card
{
    private Card[] cards = new Card[52]; //all cards dealt or not
    private int dealtIndex = 0; //marks the first undealt card

    public void SetDeckOfCards(Card[] cards) { }
    public void Shuffle() { }
    public int remainingCards()
    {
        return cards.size() - dealtIndex;
    }

    


}

public abstract class Card
{
    private boolean available = true;
    /* number or face thats on card - a number 2 through 10 or 11 for jack, 12 for queen etc */
    protected int faceValue;
    protected int suitValue;

    public Card(int c, Suit s)
    {
        faceValue = c;
        suit = s;
    }
    public abstract int value();
    public Suit suit() { return suit; }

    /* Checks if the card is available to be given out to someone */
    public boolean isAvailable() { return available; }
    public void markUnavailable() { available = false; }
    public void markAvailable() { available = true; }
}

public class Hand : Card 
{
    protected List<T> cards = new List<T>();

    public int score()
    {
        int score = 0;
        foreach (T card in cards)
        {
            score += card.value();
        }
        return score;
    }

    public void addCard(T card) { cards.Add(card); }

}