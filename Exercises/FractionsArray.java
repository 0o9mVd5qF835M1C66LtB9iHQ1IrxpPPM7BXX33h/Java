// It's the resolution of exercise 7.2 of the book "Java how to Program 9th by Deitel".
/**
 *  Objective:
 *      Perform the following tasks for an array called fractions: 
 *          a) Declare a constant ARRAY_SIZE that’s initialized to 10. 
 *          b) Declare an array with ARRAY_SIZE elements of type double, and initialize the elements to 0. 
 *          c) Refer to array element 4. 
 *          d) Assign the value 1.667 to array element 9. 
 *          e) Assign the value 3.333 to array element 6. 
 *          f) Sum all the elements of the array, using a for statement. Declare the integer variable x as a control variable for the loop. 
 */

public class FractionsArray 
{
    public static void main( String args[] )
    {
        final int ARRAY_SIZE = 10; // A done.
        double fractions[] = new double[ ARRAY_SIZE ]; // B done.
        double sum = 0;

        System.out.println( fractions[ 4 ] ); // C with some modifications. done.

        fractions[ 9 ] = 1_667; // D done.
        fractions[ 6 ] = 3_333; // E done.

        // F done.
        for ( int x = 0; x < fractions.length; x++ ) 
            sum += fractions[ x ];

        // G done. :v
        System.out.println( sum );
    } // end main
} // end class fractionsArray