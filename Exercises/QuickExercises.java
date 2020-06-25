// It's the resolution of the exercises that can be accomplished quickly.

public class QuickExercises 
{
    public static void main( String args[] )
    {
        // ** 7.8 **

        // A) Display the value of element 6 of array f.
        int f[] = new int[ 7 ]; // First, We need to create an array.
        System.out.println( f[ 6 ] ); // And now, We display the 6th element of the array f.

        // B) Initialize each of the five elements of one-dimensional integer array g to 8.
        int g[] = { 8,8,8,8,8 };

        // C) Total the 100 elements of floating-point array c.
        float c[] = new float[ 100 ]; // First, again, We need to create an array, in this case, an array called c.
        float sum = 0; // And, I've to create a floating-point variable to store the total of the array c.
        for ( float value : c ) // Here, I'll use the enhanced for statement, because, I think that it's more simple than using the for statement, in this case.
            sum += value;   // And now We've the total.

        // D) Copy 11-element array a into the first portion of array b, which contains 34 elements.
        int a[] = { 0,1,2,3,4,5,6,7,8,9,10 }; // I'll create the array called a.
        int b[] = new int[ 34 ]; // Thereafter, I'll create an array called b.
        System.arraycopy( a, 0, b, 0, 11 ); // Here, I preferred to use the method arraycopy, because, He's simpler then uses, for example, a for statement.

        // E) Determine and display the smallest and largest values contained in 99-element floating-point array w.
        float w[] = new float[ 99 ]; // First, Let's go create an array called w.

        // In this part, I'll use a for statement, only for I can set aleatory values in each position.
        for ( int counter = 0; counter < w.length; counter++ )
            w[ counter ] = (float) ( Math.random() * 100  );
        
        float min = w[ 0 ], max = w[ 0 ];

        for ( float value : w )
            if ( value < min )
                min = value;
            else if ( value > max )
                max = value;
        
        System.out.printf( "The largest value is: %f \n The smallest value is: %f\n", max, min );

    } // end main
} // end class QuickExercises.