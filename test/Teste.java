public class Teste {
    
    public static void main( String args[] )
    {
        int board[][] = new int[ 8 ][ 8 ];

        for ( int contador = 0; contador < 8; contador++ )
            for( int contador2 = 0; contador2 < 8; contador2++ )
                board[ contador ][ contador2 ] = contador + contador2;

        for ( int contador = 0; contador < 8; contador++ ) {
            for( int contador2 = 0; contador2 < 8; contador2++ ) {
                System.out.print( board[ contador ][ contador2 ] + " " );       
            }
            System.out.println();
        }

        System.out.println( board[ 0 ][ 7 ] );
    }
}