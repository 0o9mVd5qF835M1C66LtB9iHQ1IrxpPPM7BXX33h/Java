// Resoluao do exercicio 7.36 do livro de Java

// Pacote com o que o contem
package finalles;

public class Finalle005 {
    
    // o metodo main inicia o aplicativo de Java
    public static void main( String args[] )
    {
        int array[] = { 10, 7, 2, 3, 6, 5, 8, 4, 1, 9 };

        int menor = recursiveMinimum( array, array.length - 1 );
        System.out.println( menor ); // Retorna o numero 1

        System.exit( 0 );   // termina o aplicativo de Java

    } // fim do metodo main

    public static int recursiveMinimum( int array[], int tamanho ) {

        if ( tamanho == 0 )
            return array[ tamanho ];

        if ( array[ tamanho ] <= recursiveMinimum( array, tamanho - 1) )
            return array[ tamanho ];
        else
            return recursiveMinimum( array, tamanho - 1 );

    } // fim do metodo recursiveMinimum( int[] )

} // fim da classe Finalle005