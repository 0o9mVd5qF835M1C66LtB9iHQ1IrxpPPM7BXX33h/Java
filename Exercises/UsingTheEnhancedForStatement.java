// It's the resolution of the exercise 7.16
/**
 * Write an application that uses an enhanced for statement to sum the double values passed by the command-line arguments. 
 * [Hint: Use the static method parseDouble of class Double to convert a String to a double value.]
 */

public class UsingTheEnhancedForStatement 
{
    public static void main( String args[] )
    {
        double sum = 0.0;
        for ( String number : args )
            sum += Double.parseDouble( number );

        System.out.println( sum );        

    } // end main 
} // end class UsingTheEnhancedForStatement