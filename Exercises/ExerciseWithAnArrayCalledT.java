// It's the resoluction of the exercise 7.9
/**
 * Consider a two-by-three integer array t. 
 * a) Write a statement that declares and creates t. 
 * b) How many rows does t have? 
 * c) How many columns does t have? 
 * d) How many elements does t have? 
 * e) Write access expressions for all the elements in row 1 of t. 
 * f) Write access expressions for all the elements in column 2 of t. 
 * g) Write a single statement that sets the element of t in row 0 and column 1 to zero. 
 * h) Write individual statements to initialize each element of t to zero. 
 * i) Write a nested for statement that initializes each element of t to zero. 
 * j) Write a nested for statement that inputs the values for the elements of t from the user. 
 * k) Write a series of statements that determines and displays the smallest value in t. 
 * l) Write a single printf statement that displays the elements of the first row of t. 
 * m) Write a statement that totals the elements of the third column of t. Do not use repetition. 
 * n) Write a series of statements that displays the contents of t in tabular format. List the column indices as headings across the top, and list the row indices at the left of each row.
 */

import java.util.Scanner;

public class ExerciseWithAnArrayCalledT {
    
    public static void main( String args[] )
    {
        final int ROW = 2;
        final int COLUMN = 3;

        int t[][] = new int[ ROW ][ COLUMN ]; // A

        // B) 2 rows     C) 3 column    D) 2 * 3 = 6 elements

        // E
        for ( int column = 0; column < t[ 1 ].length; column++ )
            System.out.printf( "%d ", t[ 1 ][ column ] );
        System.out.println();

        // F
        for( int row = 0; row < t.length; row++ )
            System.out.printf( "%d ", t[ row ][ 2 ] );
        System.out.println();

        // G
        t[ 0 ][ 1 ] = 0;

        // H
        for ( int column = 0; column < t[ 0 ].length; column++ )
            t[ 0 ][ column ] = 0;
        
        for ( int column = 0; column < t[ 1 ].length; column++)
            t[ 1 ][ column ] = 0;

        // I
        for ( int row = 0; row < t.length; row++ )
            for ( int column = 0; column < t[ row ].length; column++ )
                t[ row ][ column ] = 0;

        // J
        Scanner input = new Scanner( System.in );

        for ( int row = 0; row < t.length; row++ )
            for( int column = 0; column < t[ row ].length; column++ )
                t[ row ][ column ] = input.nextInt();

        // K
        int smallest = t[ 0 ] [ 0 ];

        for ( int column = 0; column < t[ 0 ].length; column++ )
            if ( t[ 0 ][ column ] < smallest )
                smallest = t[ 0 ][ column ];
        
        for ( int column = 0; column < t[ 1 ].length; column++)
            if ( t[ 1 ][ column ] < smallest )
                smallest = t[ 1 ][ column ];

        // L
        System.out.printf( "%d, %d, %d\n", t[ 0 ][ 0 ], t[ 0 ][ 1 ], t[ 0 ][ 2 ] );

        // M
        int total = t[ 0 ][ 2 ] + t[ 1 ][ 2 ];

        // N
        System.out.print( "   " );
        for ( int counter = 0; counter < COLUMN; counter++ )
            System.out.printf( "%d ", counter );
        System.out.println( "\n--------" );

        for ( int row = 0; row < t.length; row++ ) {
            System.out.printf( "%d| ", row );
            for( int column = 0; column < t[ row ].length; column++ )
                System.out.printf( "%d ", t[ row ][ column ] );
            System.out.println();
        } // end for statement
    } // end main
} // end class Exercise079