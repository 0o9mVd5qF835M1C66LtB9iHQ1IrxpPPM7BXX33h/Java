// It's the resolution of the exercise 7.15
/**
 * Rewrite Fig.7.2 so that the size of the array is specified by the first command-line argument. 
 * If no command-line argument is supplied, use 10 as the default size of the array. 
 */

public class CommandLineArguments 
{
    public static void main( String args[] )
    {
        int[] array; // declare array named array
        System.out.printf( "%s%8s\n", "Index", "Value" ); // column headings
        int arrayLength;
        if ( args.length == 1 )
            arrayLength = Integer.parseInt( args[ 0 ] );
        else 
            arrayLength = 10;

        array = new int[ arrayLength ]; // create the array object

        // output each array element's value
        for( int counter = 0; counter < array.length; counter++ )
            System.out.printf( "%5d%8d\n", counter, array[ counter ] );
    } // end main 
} // end class