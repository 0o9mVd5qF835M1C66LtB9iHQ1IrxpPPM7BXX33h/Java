// Resolucao do exercicio 7.24 do livro de Java

// Pacotes de extensa de Java
import javax.swing.JOptionPane;

public class Finalle012 {

    public static void main( String args[] )
    {
        final int N = 8;
        int board[][] = new int[ N ][ N ];
        inicializarArrayBidimensional( board );
        executa( board, N, 0 );

        System.exit( 0 );
    } // fim do metodo main

    public static void executa( int board[][], int N, int column )
    {
        if (  column == N ) {
            JOptionPane.showMessageDialog( null, imprimirArrayBidimensional( board ) );
            return;
        }

        for ( int row = 0; row < N; row++ ) {
            if ( seguro( board, row, column ) ) {
                board[ row ][ column ] = 1; // insere a nova rainha
                executa( board, N, column + 1 ); // chamada recursiva
                board[ row ][ column ] = 0; // backtracking
            }
        }

    } // fim do metodo executa

    public static boolean seguro( int board[][], int row, int column ) 
    {
        if ( ocorre_Ataque_Na_Linha( board, row, column ) )
            return false;
        else if ( ocorre_Ataque_Na_Coluna( board, row, column ) ) 
            return false;
        else if ( ocorre_Ataque_Nas_Diagonais( board, row, column ) ) 
            return false;

        return true;

    } // fim do metodo seguro

    public static boolean ocorre_Ataque_Na_Linha( int board[][], int row, int column )
    {
        for ( int copiaDoRow = 0; copiaDoRow < 8; copiaDoRow++ ) {
            if ( copiaDoRow == row )
                continue;

            else if ( board[ copiaDoRow ][ column ] == 1 )
                return true;
        }

        return false;

    } // fim do metodo ocorre_Ataque_Na_Linha

    public static boolean ocorre_Ataque_Na_Coluna( int board[][], int row, int column )
    {
        for ( int copiaDoColumn = 0; copiaDoColumn < 8; copiaDoColumn++ ) {
            if ( copiaDoColumn == column )
                continue;
            
            else if ( board[ row ][ copiaDoColumn ] == 1 )
                return true;
        }

        return false;

    } // fim do metodo ocorre_Ataque_Na_Coluna

    public static boolean ocorre_Ataque_Nas_Diagonais( int board[][], int row, int column )
    {
        int copiaDoRow = row, copiaDoColumn = column;

        // Testa se ha uma rainha no Noroeste
        while ( true ) {
            copiaDoRow--;
            copiaDoColumn--;

            if ( copiaDoRow < 0 || copiaDoColumn < 0 )
                break;

            else if ( board[ copiaDoRow][ copiaDoColumn ] == 1 )
                return true;
        }

        copiaDoRow = row;
        copiaDoColumn = column;

        // Testa se ha uma rainha no Sudeste
        while ( true ) {
            copiaDoRow++;
            copiaDoColumn++;
            
            if ( copiaDoRow > 7 || copiaDoColumn > 7 )
                break;
            
            else if ( board[ copiaDoRow ][ copiaDoColumn ] == 1 )
                return true;
        }

        copiaDoRow = row;
        copiaDoColumn = column;

        // Teste se ha uma rainha no Nordeste
        while ( true ) {
            copiaDoRow--;
            copiaDoColumn++;

            if ( copiaDoRow < 0 || copiaDoColumn > 7 )
                break;
            
            else if ( board[ copiaDoRow ][ copiaDoColumn ] == 1 )
                return true;
        }

        copiaDoRow = row;
        copiaDoColumn = column;

        // Testa se ha uma rainha no Sudoeste
        while ( true ) {
            copiaDoRow++;
            copiaDoColumn--;

            if ( copiaDoRow > 7 || copiaDoColumn < 0 )
                break;
            
            else if ( board[ copiaDoRow ][ copiaDoColumn ] == 1 )
                return true;
        }

        return false;
    } // fim do metodo ocorre_Ataque_Nas_Diagonais

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
    } // fim do metodo inicializarArray

} // fim da classe Finalle012