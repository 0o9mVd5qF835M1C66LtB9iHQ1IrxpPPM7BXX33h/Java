// It's the resolution of the exercise 7.10
/**
 * (Sales Commissions) Use a one-dimensional array to solve the following problem: A company pays its salespeople on a commission basis. 
 * The salespeople receive $200 per week plus 9% of their gross sales for that week. For example, a salesperson who grosses $5000 in sales in a week receives $200 plus 9% of $5000, or a total of $650. 
 * Write an application (using an array of counters) that determines how many of the salespeople earned salaries in each of the following ranges (assume that each salesperson’s salary is truncated to an integer amount): 
 * a) $200–299 
 * b) $300–399 
 * c) $400–499 
 * d) $500–599 
 * e) $600–699 
 * f) $700–799 
 * g) $800–899 
 * h) $900–999 
 * i) $1000 and over 
 * 
 * Summarize the results in tabular format.
 */

import java.util.Scanner;
import java.util.Arrays;

public class SalesCommissions 
{
    public static void main( String args[] )
    {
        Scanner input = new Scanner( System.in );
        final int ARRAY_SIZE = 10;

        final String RANGES[] = { "$200–299", "$300–399", "$400–499", "$500–599", "$600–699", "$700–799", "$800–899", "$900–999", "$1000 and over" };
        int salaries[] = new int[ ARRAY_SIZE ]; // An array that will have many salaries.

        for ( int counter = 0; counter < ARRAY_SIZE; counter++ )   // Now, I'll want to receive the salary of any salesperson.
            salaries[ counter ] = input.nextInt();

        for ( int counter = 0; counter < ARRAY_SIZE; counter++ ) 
            salaries[ counter ] = (int) ( 200 + ( 0.09 * salaries[ counter ] ) ); // And now, I want to set the salary in the same location where, before, It had gross sales. 

        Arrays.sort( salaries ); // This will organize the values from smallest to largest. 


        for ( String range : RANGES ) {
            System.out.printf( "%14s| ", range );

            for ( int salary : salaries ) {
                if ( range.equals( "$200–299" ) && ( salary >= 200 && salary <= 299 ) ) {
                    System.out.printf( "%d ", salary );
                    continue;
                } else if ( range.equals( "$300–399" ) && ( salary >= 300 && salary <= 399 ) ) {
                    System.out.printf( "%d ", salary );
                    continue;   
                } else if ( range.equals( "400-499" ) && ( salary >= 400 && salary <= 499 ) ) {
                    System.out.printf( "%d ", salary );
                    continue;
                } else if ( range.equals( "500-599" ) && ( salary >= 500 && salary <= 599 ) ) {
                    System.out.printf( "%d ", salary );
                    continue;
                } else if ( range.equals( "$600–699" ) && ( salary >= 600 && salary <= 699 ) ) {
                    System.out.printf( "%d ", salary );
                    continue;
                } else if ( range.equals( "$700–799" ) && ( salary >= 700 && salary <= 799 ) ) {
                    System.out.printf( "%d ", salary );
                    continue;
                } else if ( range.equals( "$800–899" ) && ( salary >= 800 && salary <= 899 ) ) {
                    System.out.printf( "%d ", salary );
                    continue;
                } else if ( range.equals( "$900–999" ) && ( salary >= 900 && salary <= 999 ) ) {
                    System.out.printf( "%d ", salary );
                    continue;
                } else if ( range.equals( "$1000 and over" ) && ( salary >= 1000 ) )
                    System.out.printf( "%d ", salary );
            } // end inner for

        
            System.out.println();
        } // end outer for

            input.close();
            System.exit(0);

    } // end main
} // end class salesCommissions