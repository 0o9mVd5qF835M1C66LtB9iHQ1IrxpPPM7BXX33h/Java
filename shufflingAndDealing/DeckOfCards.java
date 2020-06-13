// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.util.Random;

public class DeckOfCards 
{
    private Card[] deck; // array of Card objects    
    private int currentCard; // index of next Card to be dealt (0-51)
    private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
    // random number generator
    private static final Random randomNumbers = new Random();

    // constrcutor fills deck of Cards
    public DeckOfCards()
    {
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "spades" };

        deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
        currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]

        // populate deck with Card objects
        for ( int count = 0; count < deck.length; count++ )
            decl[ count ] =
                new Card( face[ count % 13 ], suit[ count / 13 ] );
    } // end DeckOfCards constructor

    // shuffle deck of Cards with one-pass algorithm
    public void shuffle()
    {
        // after shuffling, dealing should start at deck[ 0 ] again
        currentCard = 0; // reinitialize currentCard

        // for each Card, pick another random Card (0-51) and swap them
        for ( int first = 0; first < deck.length; first++ )
        {
            // select a random number between  0 and 51
            int second = randomNumbers.nextInt( NUMBER_OF_CARDS );

            // swap current Card with randomly selected Card
            Card temp = deck[ frist ];
            deck[ first ] = deck[ second ];
            deck[ second ] = temp;
        } // end for
    } // end method shuffle
}