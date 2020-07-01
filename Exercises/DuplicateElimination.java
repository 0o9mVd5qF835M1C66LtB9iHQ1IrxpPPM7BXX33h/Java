
// It's the resoluction of the exercise 7.12.
/**
 * (Duplicate Elimination) Use a one-dimensional array to solve the following problem: 
 * Write an application that inputs five numbers, each between 10 and 100, inclusive. 
 * As each number is read, display it only if it’s not a duplicate of a number already read. 
 * Provide for the “worst case,” in which all five numbers are different. Use the smallest possible array to solve this problem. 
 * Display the complete set of unique values input after the user enters each new value. 
 */

import java.util.Scanner;

public class DuplicateElimination
{
    public static void main( String args[] )
    {
        final int ARRAY_LENGTH = 5;
        Scanner input = new Scanner( System.in );
        int values[] = new int[ ARRAY_LENGTH ];
        String auxArray[] = new String[ ARRAY_LENGTH ];
        boolean isItInArray = false;
        int auxOfTheAuxArray = 1;
        int lengthOfTheFinalArray = 0;

        for ( int counter = 0; counter < values.length; counter++ )
            values[ counter ] = input.nextInt();

        auxArray[ 0 ] = Integer.toString( values[ 0 ] ); // Add the first number of the array called values to the first position of the auxArray.

        for ( int counter = 1; counter < ARRAY_LENGTH; counter++ ) 
        {
            isItInArray = false;

            for ( String number : auxArray )
                if ( number == null )
                    break;
                else if ( values[ counter ] == Integer.parseInt( number ) ) {
                    isItInArray = true;
                    break;
                }
            
            if ( isItInArray == false ) {
                auxArray[ auxOfTheAuxArray ] = Integer.toString( values[ counter ] );
                auxOfTheAuxArray++;
            }
        } // end outer for

        for ( int counter = 0; counter < auxArray.length; counter++ )
            if ( auxArray[ counter ] == null )
                break;
            else
                lengthOfTheFinalArray++;


        if ( lengthOfTheFinalArray == ARRAY_LENGTH )
            for ( int value : values )
                System.out.printf( "%d ", value );
        else {
            int finalArray[] = new int[ lengthOfTheFinalArray ];

            System.out.println( "Before:" );

            for ( int value : values ) // The array, before It has been changed.
                System.out.printf( "%d ", value );

            System.out.println( "\nNow:" );

            for ( int counter = 0; counter < finalArray.length; counter++ ) { // The array now.
                finalArray[ counter ] = Integer.parseInt( auxArray[ counter ] );
                System.out.printf( "%d ", finalArray[ counter ] );
            } // end inner for
        }

        input.close();
    } // end main
} // end class duplicateElimination