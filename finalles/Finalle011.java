// Resolucao do exercicio 7.28 do livro de Java

// Pacote no qual essa classe esta contida
package finalles;

// Pactoes de extensao de Java
import javax.swing.*;

public class Finalle011 {
    
    public static void main( String args[] )
    {
        int valores1[] = new int[ 10 ];
        int valores2[] = new int[ 10 ];
        int valores3[] = new int[ 10 ];

        adicionarNumerosAleatoriosAUmArray( valores1 );
        adicionarNumerosAleatoriosAUmArray( valores2 );
        adicionarNumerosAleatoriosAUmArray( valores3 );

        JOptionPane.showMessageDialog( null, "Antes:\n\n" + mostrarArrayUnidimensional( valores1 ) + "\n" + mostrarArrayUnidimensional( valores2 ) + "\n" + mostrarArrayUnidimensional( valores3 ) );

        bucketSort( valores1 );
        bucketSort( valores2 );
        bucketSort( valores3 );

        JOptionPane.showMessageDialog( null, "Depois:\n\n" + mostrarArrayUnidimensional( valores1 ) + "\n" + mostrarArrayUnidimensional( valores2 ) + "\n" + mostrarArrayUnidimensional( valores3 ) );

        System.exit( 0 );
    } // fim do metodo main

    public static void bucketSort( int array[] ) 
    {
        int valorASerDividido = 1;     

        for ( int passagens = 0; passagens < 4; passagens++ ) {

            int arrayDeDepositos[][] = new int[ 10 ][ array.length ], quantidadesDe0 = 0, quantidadesDe1 = 0, QuantidadesDe2 = 0, quantidadesDe3 = 0, quantidadeDe4 = 0, quantidadeDe5 = 0, quantidadeDe6 = 0, quantidadeDe7 = 0, quantidadeDe8 = 0, quantidadeDe9 = 0,
            primeiroNumero, copiaDoValor;
            
            if ( passagens > 0 ) 
                valorASerDividido *= 10;

            for ( int valor : array ) { 

                copiaDoValor = valor;
                if ( passagens > 0 ) 
                    copiaDoValor /= valorASerDividido;

                primeiroNumero = copiaDoValor % 10;

                if ( primeiroNumero == 0 ) { 
                    arrayDeDepositos[ primeiroNumero ][ quantidadesDe0 ] = valor;
                    quantidadesDe0++;
                } else if ( primeiroNumero == 1) {
                    arrayDeDepositos[ primeiroNumero ][ quantidadesDe1 ] = valor;
                    quantidadesDe1++;
                } else if ( primeiroNumero == 2 ) {    
                    arrayDeDepositos[ primeiroNumero ][ QuantidadesDe2 ] = valor;
                    QuantidadesDe2++;   
                } else if ( primeiroNumero == 3 ) {
                    arrayDeDepositos[ primeiroNumero ][ quantidadesDe3 ] = valor;
                    quantidadesDe3++;
                } else if ( primeiroNumero == 4 ) {
                    arrayDeDepositos[ primeiroNumero ][ quantidadeDe4 ] = valor;   
                    quantidadeDe4++;             
                } else if ( primeiroNumero == 5 ) {     
                    arrayDeDepositos[ primeiroNumero ][ quantidadeDe5 ] = valor; 
                    quantidadeDe5++;
                } else if ( primeiroNumero == 6 ) {    
                    arrayDeDepositos[ primeiroNumero ][ quantidadeDe6 ] = valor; 
                    quantidadeDe6++; 
                } else if ( primeiroNumero == 7 ) {     
                    arrayDeDepositos[ primeiroNumero ][ quantidadeDe7 ] = valor;     
                    quantidadeDe7++;    
                } else if ( primeiroNumero == 8 ) {
                    arrayDeDepositos[ primeiroNumero ][ quantidadeDe8 ] = valor;
                    quantidadeDe8++;
                } else if ( primeiroNumero == 9 ) {
                    arrayDeDepositos[ primeiroNumero ][ quantidadeDe9 ] = valor;
                    quantidadeDe9++;
                }

            } // fim do for das passagens de distribuicao

            adicionarNumerosDeUmArrayBidimensionalParaUmArrayUnidimensional( arrayDeDepositos, array );

        } // fim do laco que passa a analize de (unidades -> dezenas -> centenas -> etc..)

    } // fim do metodo bucketSort

    public static void adicionarNumerosDeUmArrayBidimensionalParaUmArrayUnidimensional( int array1[][], int array2[] )
    {
        int contadorDeValoresQueForamAceitos = 0;

        for ( int row = 0; row < array1.length; row++ )  {
            for ( int column = 0; column < array1[ row ].length; column++ ) {
                if ( array1[ row ][ column ] != 0 ) {
                    array2[ contadorDeValoresQueForamAceitos ] = array1[ row ][ column ];
                    contadorDeValoresQueForamAceitos++;
                }            
            }
        } // fim do laco de passagens de coleta

    } // fim do metodo adicionarNumerosDeUmArrayBidimensionalParaUmArrayUnidimensional

    public static String mostrarArrayUnidimensional( int array3[] )
    {
        String output = "";
        for ( int row = 0; row < array3.length; row++ )
            output += array3[ row ] + " ";

        return output;

    } // fim do metodo mostrarArrayUnidimensional

    public static void adicionarNumerosAleatoriosAUmArray( int array4[] )
    {
        for ( int contador = 0; contador < 10; contador++ )
            array4[ contador ] = 1 + (int) ( Math.random() * 10000 );

    } // fim do metodo adicionarNumerosAleatoriosAUmAr-

} // fim da classe Finalle011