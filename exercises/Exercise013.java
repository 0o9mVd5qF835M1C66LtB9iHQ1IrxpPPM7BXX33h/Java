// Resolucao do exercicio 7.25 do livro de Java

// Pacote de extensao de Java
import javax.swing.*;

public class Finalle013 {
    
    public static void main( String args[] )
    {
        int N = 8, numeroAleatorio;
        int board[][] = new int[ N ][ N ];
        boolean asRainhasNaoEstaoSeAtacando = false;

        for ( int respostas = 0; respostas < 10; respostas++ ) {
            while ( true ) {
                inicializarArrayBidimensional( board );

                for ( int contador = 0; contador < 8; contador++ ) {
                    numeroAleatorio = (int) ( Math.random() * 8 );
                    board[ numeroAleatorio ][ contador ] = 1;

                    asRainhasNaoEstaoSeAtacando = seguro( board, numeroAleatorio, contador );
                    if ( asRainhasNaoEstaoSeAtacando == false )
                        break;
                }

                if ( asRainhasNaoEstaoSeAtacando )
                    break;

            }

            JOptionPane.showMessageDialog( null, imprimirArrayBidimensional( board ) );
        }

        System.exit( 0 );
    } // fim do metodo main

    public static boolean seguro( int array1[][], int row1, int column1 )
    {
        if ( ocorreAtaqueNaLinha( array1, row1, column1 ) )
            return false;
        else if ( ocorreAtaqueNaColuna( array1, row1, column1 ) )
            return false;
        else if ( ocorreAtaqueNasDiagonais( array1, row1, column1 ) )
            return false;

        return true;

    } // fim do metodo descobrirSeAsRainhasEstaoSeAtacando

    public static boolean ocorreAtaqueNaLinha( int array2[][], int row2, int column2 )
    {
        for ( int rowCopy = 0; rowCopy < 8; rowCopy++ ) {
            if ( rowCopy == row2 )
                continue;

            else if ( array2[ rowCopy ][ column2 ] == 1 )
                return true;

        }

        return false;
    } // fim do metodo ocorreAtauqeNaLinha

    public static boolean ocorreAtaqueNaColuna( int array3[][], int row3, int column3 )
    {
        for ( int columnCopy = 0; columnCopy < 8; columnCopy++ ) {
            if ( columnCopy == column3 )
                continue;
            else if ( array3[ row3 ][ columnCopy ] == 1 )
                return true;
        }

        return false;
    } // fim do metodo ocorreAtaqueNaColuna

    public static boolean ocorreAtaqueNasDiagonais( int array4[][], int row4, int column4 )
    {
        int copiaDoRow = row4, copiaDoColumn = column4;

        // Testa se ha uma rainha no Noroeste
        while ( true ) {
            copiaDoRow--;
            copiaDoColumn--;

            if ( copiaDoRow < 0 || copiaDoColumn < 0 )
                break;

            else if ( array4[ copiaDoRow][ copiaDoColumn ] == 1 )
                return true;
        }

        copiaDoRow = row4;
        copiaDoColumn = column4;

        // Testa se ha uma rainha no Sudeste
        while ( true ) {
            copiaDoRow++;
            copiaDoColumn++;
            
            if ( copiaDoRow > 7 || copiaDoColumn > 7 )
                break;
            
            else if ( array4[ copiaDoRow ][ copiaDoColumn ] == 1 )
                return true;
        }

        copiaDoRow = row4;
        copiaDoColumn = column4;

        // Teste se ha uma rainha no Nordeste
        while ( true ) {
            copiaDoRow--;
            copiaDoColumn++;

            if ( copiaDoRow < 0 || copiaDoColumn > 7 )
                break;
            
            else if ( array4[ copiaDoRow ][ copiaDoColumn ] == 1 )
                return true;
        }

        copiaDoRow = row4;
        copiaDoColumn = column4;

        // Testa se ha uma rainha no Sudoeste
        while ( true ) {
            copiaDoRow++;
            copiaDoColumn--;

            if ( copiaDoRow > 7 || copiaDoColumn < 0 )
                break;
            
            else if ( array4[ copiaDoRow ][ copiaDoColumn ] == 1 )
                return true;
        }

        return false;
    } // fim do metodo ocorreAtaqueNasDiagonais

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