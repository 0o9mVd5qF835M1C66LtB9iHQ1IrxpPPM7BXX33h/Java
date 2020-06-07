// Resolucao do exercicio 7.24 do livro de Java

// Pacote pertencente
package finalles;

// Pacotes de extensa de Java
import javax.swing.JOptionPane;

public class Finalle012 {

    public static void main( String args[] )
    {
        int N = 8, numeroDeCasas;
        int board[][] = new int[ N ][ N ];

        for ( int row = 0; row < board.length; row++ ) {
            for ( int column = 0; column < board[ row ].length; column++ ) {
                numeroDeCasas = descobrirQuantidadeDeCasasQueARainhaPodeAndar( board, row, column );
                board[ row ][ column ] = numeroDeCasas;
            }
        }

        System.exit( 0 );
    } // fim do metodo main

    public static int descobrirQuantidadeDeCasasQueARainhaPodeAndar( int board[][], int row, int column ) 
    {
        int numeroDeCasas = 0, copiaDoRow = row, copiaDoColumn = column;

        while ( true )
        {
            if ( copiaDoColumn >= 7 )
                break;
            copiaDoColumn++;
            numeroDeCasas++;
        } // fim do laco para descobrir a quantidade de casas horizontais a direita

        copiaDoColumn = column;

        while ( true )
        {
            if ( copiaDoColumn <= 0 )
                break;
            copiaDoColumn--;
            numeroDeCasas++;
        } // fim do laco para descobrir a quantidade de casas horizontais a esquerda

        copiaDoColumn = column;

        while ( true )
        {
            if ( copiaDoRow >= 7 )
                break;
            copiaDoRow++;
            numeroDeCasas++;
        } // fim do laco para descobrir a quantidade de casas verticais a baixo.

        copiaDoRow = row;

        while ( true )
        {
            if ( copiaDoRow <= 0 )
                break;
            copiaDoRow--;
            numeroDeCasas++;
        } // fim do laco para descobrir a quantidade de casas verticais a cima.

        copiaDoRow = row;

        while ( true )
        {
            if ( copiaDoRow <= 0 || copiaDoColumn <= 0 )
                break;
            copiaDoRow--;
            copiaDoColumn--;
            numeroDeCasas++;
        } // fim do laco para descobrir a quantidade de casas diagonais para o Noroeste

        copiaDoRow = row;
        copiaDoColumn = column;

        while ( true )
        {
            if ( copiaDoRow <= 0 || copiaDoColumn >= 7 )
            break;
            copiaDoRow--;
            copiaDoColumn++;
            numeroDeCasas++;
        } // fim do laco para descobrir a quantidade de casas diagonais para o Nordeste

        copiaDoRow = row;
        copiaDoColumn = column;

        while ( true )
        {
            if ( copiaDoRow >= 7 || copiaDoColumn <= 0 )
                break;
            copiaDoRow++;
            copiaDoColumn--;
            numeroDeCasas++;
        } // fim do laco para descoobrir a quantidade de casas diagonais para o Sudoeste

        copiaDoRow = row;
        copiaDoColumn = column;

        while( true )
        {
            if ( copiaDoRow >= 7 || copiaDoColumn >= 7 )
                break;
            copiaDoRow++;
            copiaDoColumn++;
            numeroDeCasas++;
        }

        return numeroDeCasas + 1;

    } // fim do metodo descobrirQuantidadeDecasasQueARainhaPodeAndar

    public static void imprimirArrayBidimensional( int array1[][] )
    {
        for ( int row = 0; row < array1.length; row++ ) {
            for ( int column = 0; column < array1[ row ].length; column++ )
                System.out.print( array1[ row ][ column ] + " " );
            System.out.println();
        }
    } // fim do metodo imprimirArrayBidimensional

} // fim da classe Finalle012