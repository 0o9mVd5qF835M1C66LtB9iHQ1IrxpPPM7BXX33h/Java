// Resolucao do exercicio 7.25 do livro de Java

public class Finalle013 {
    
    public static void main( String args[] )
    {
        int N = 8, numeroAleatorio;
        int board[][] = new int[ N ][ N ];
        inicializarArrayBidimensional( board );

        for ( int contador = 0; contador < 8; contador++ )
            numeroAleatorio = (int) ( Math.random() * 8 );

        // EM DESENVOLVIMENTO

        System.exit( 0 );
    } // fim do metodo man

    public static String imprimirArrayBidimensional( int array[][] )
    {
        String output = "";

        for ( int row = 0; row < array.length; row++ ) {
            for ( int column = 0; column < array[ row ].length; column++ )
                output += array[ row ][ column ] + " ";
            output += "\n";
        }

        return output;
    } // fim do metodo imprimirArrayBidimensional

    public static void inicializarArrayBidimensional( int array[][] )
    {
        for ( int row = 0; row < array.length; row++ )
            for ( int column = 0; column < array[ row ].length; column++ )
                 array[ row ][ column ] = 0;
    }

} // fim da classe Finalle013