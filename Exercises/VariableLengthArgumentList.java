// It's the resolution of the exercise 7.14
/**
 * Write an application that calculates the product of a series of integers that are passed to method product using a variable-length argument list.
 * Test your method with several calls, each with a different number of arguments. 
 */

public class VariableLengthArgumentList 
{
    public static void main( String args[] )
    {

        for ( int counter = 0; counter < 50; counter++ )
        {
            int d1 = 1 + (int) ( Math.random() * 30 ); 
            int d2 = 1 + (int) ( Math.random() * 30 );
            int d3 = 1 + (int) ( Math.random() * 30 );
            int result = 0;

            result = product( d1, d2, d3 );

            System.out.printf( "The product of %d, %d and %d is: %d\n", d1, d2, d3, result );
        } // end for statement
    } // end main 

    public static int product( int... numbers )
    {
        int result = 1;
        for ( int value : numbers )
            result *= value;

        return result;
    } // end method product
} // end class variableLengthArgumentList