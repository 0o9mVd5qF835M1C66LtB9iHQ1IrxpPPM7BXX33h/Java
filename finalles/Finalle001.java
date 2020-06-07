// Resolucao do exercicio 7.31 do livro de Java

// Pacote que pertence
package finalles;

public class Finalle001 {
    
    // o metodo main inicia o aplicativo de Java
    public static void main( String args[] )
    {
        int valores[] = { 0,1,2,3,4,5,6,7,8,9 };

        System.out.println( linearSearch( valores, 1, 9, 0 ) );

        System.exit( 0 ); // termina o aplicativo de Java
    } // fim do metodo main

    public static int linearSearch( int array[], int subscritoInicial, int subscritoFinal, int key ) {
        if ( array[ subscritoInicial ] == key ) 
            return subscritoInicial;
        else if ( subscritoInicial == subscritoFinal )
            return -1;
        else
            return linearSearch( array, subscritoInicial + 1, subscritoFinal, key );

    } // fim do metodo linearSearch( int[], int, int )

} // fim da classe Finalle001