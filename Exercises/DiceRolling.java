// It's the resolution of the exercise 7.17 
/**
 * Write an application to simulate the rolling of two dice. 
 * The application should use an object of class Random once to roll the first die and again to roll the second die. 
 * The sum of the two values should then be calculated.
 * Each die can show an integer value from 1 to 6, so the sum of the values will vary from 2 to 12, with 7 being the most frequent sum, and 2 and 12 the least frequent. 
 * Figure 7.28 shows the 36 possible combinations of the two dice. Your application should roll the dice 36,000,000 times. Use a one-dimensional array to tally the number of times each possible sum appears. 
 * Display the results in tabular format.
 */

public class DiceRolling 
{
    public static void main( String args[] )
    {
        int die1, die2, sum;
        int numberOfTimesEachPossibleSumAppears[] = new int[ 13 ];

        for ( int counter = 0; counter < 36_000_000; counter++ )
        {
            die1 = 1 + (int) ( Math.random() * 6 );
            die2 = 1 + (int) ( Math.random() * 6 );
            sum = die1 + die2;
            numberOfTimesEachPossibleSumAppears[ sum ]++;
        } // end for statement

        for ( int counter = 2; counter <= 12; counter++ )
            System.out.printf( "[%2d]\t%7d\n", counter, numberOfTimesEachPossibleSumAppears[ counter ] );
    } // end main 
} // end class DiceRolling