// It's the resolution of exercise 7.4 of the book "Java how to program 9th by Deitel"
/**
 * Objective:
 *  Perform the following tasks for an array called table:
 *      a) Declare and create the array as an integer array that has three rows and three columns. Assume that the constant ARRAY_SIZE has been declared to be 3. 
 *      b) How many elements does the array contain? 
 *      c) Use a for statement to initialize each element of the array to the sum of its indices. Assume that the integer variables x and y are declared as control variables. 
 */

public class TableArray 
{
    public static void main( String args[] )
    {
        // A done.
        final int ARRAY_SIZE = 3;
        int table[][] = new int[ ARRAY_SIZE ][ ARRAY_SIZE ];

        // B  ( m by n / 3 by 3 = 9 ) done.

        // C done.
        modifyAnIntegerMultidimensionalArray( table );

        // D done. :v
        for ( int x = 0; x < table.length; x++ ) {
            for( int y = 0; y < table[ x ].length; y++ )
                System.out.printf( "%d ", table[ x ][ y ] );
            System.out.println();
        } // end outer for
    
    } // end main

    public static void modifyAnIntegerMultidimensionalArray( int array1[][] )
    {
        for ( int x = 0; x < array1.length; x++ )
            for( int y = 0; y < array1[ x ].length; y++ )
                array1[ x ][ y ] = x + y;
    } // end method modifyAnIntegerMultidimensionalArray
} // end class tableArray