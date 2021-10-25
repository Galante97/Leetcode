//Design a deck of cards

//Q: is the deck of cards for games like blackjack poker etc
//A: YES 

//Q: is the deck of cards a standard 52 deck of cards, with no jokers
//A: YES

//Q: would you like me to design it for a specfic game
//A: yes design a generic deck and extend it for black jack

//DEFINE THE CORE OBJECTS
//define an enum called suit
public enum Suit {
    CLUB,
    DIAMOND,
    HEART,
    SPADE
}

//define a class of card
public class Card {
    private int value;
    private Suit suit;
    public Card(int _val, Suit _suit) {
        value = _val;
        suit = _suit;
    }
}


//define the deck class 
public class Deck {
    public Deck() {}
    public Deck(int num) {}

    int numOfCards;
    Card[] cards = new Card[52];
}

//Last but not least, we define a class that represents the player
public class Hand {
    List<Card> cards;
    public Hand() {}
    public Hand(List<Card> _cards) {
        cards = _cards;
    }

}
/*
Analyze Relationships:
The deck represents the remaining cards on the table,
 we can initialized the deck with cards ranging from 1 to 52 cards.
  So this is a one-to-many relationship between deck and card.

We also define a class called Hand which represents our players,
each player will be holding any number of cards.
*/