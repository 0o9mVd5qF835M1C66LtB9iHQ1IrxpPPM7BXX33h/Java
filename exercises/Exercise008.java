// Resolucao do exercicio 7.11 do livro de Java

// Pacote de extensao de Java
import javax.swing.*;

public class Finalle008 {
    
    public static void main( String args[] )
    {
        JTextArea outputArea = new JTextArea();

        int array[] = { 2,4,6,8,12,10,37,8,89 };
        String output = "Data items in original order\n";

        for ( int counter = 0; counter < array.length; counter++ )
            output += "   " + array[ counter ];

        bubbleSort( array );    // ordena o array
        
        output +=  "\n\nData items in ascedingorder\n";

        // acrescenta valores ordenados do array ao String output
        for ( int counter = 0; counter < array.length; counter++ )
            output += "   " + array[ counter ];

        outputArea.setText( output );

        JOptionPane.showMessageDialog( null, outputArea );
        System.exit( 0 );
    } // fim do metodo main

    // ordenada os elementos do array com bubble sort
    public static void bubbleSort( int array2[] )
    {
        int posicaoDoMaiorValor = 0;
        int auxiliarParaOLacoDeComparacoes = array2.length;
        boolean temQueSerFeitoAlgumMovimento = false;

        // laco  para controlar o numero de passagens
        for ( int pass = 0; pass < array2.length; pass++ ) {

            temQueSerFeitoAlgumMovimento = false;

            // laco para controlar o numero de comparacoes
            for ( int element = 0; element < auxiliarParaOLacoDeComparacoes; element++ ) {

                if ( element == 0 || array2[ element ] > array2[ posicaoDoMaiorValor ] )
                    posicaoDoMaiorValor = element;
                if ( array2[ element ] < array2[ posicaoDoMaiorValor ] ) 
                    temQueSerFeitoAlgumMovimento = true;
                
            } // fim do laco para controlar comparacoes

            if ( temQueSerFeitoAlgumMovimento == false )
                break;

            System.out.println( "Passou!" );
            auxiliarParaOLacoDeComparacoes--;

            swap( array2, posicaoDoMaiorValor, auxiliarParaOLacoDeComparacoes );

        } // fim do laco para controlar passagens

    } // fim do metodo bubbleSort

    public static void swap( int array3[], int first, int second )
    {
        int hold; // area de armazenamento temporario para troca

        hold = array3[ first ];
        array3[ first ] = array3[ second ];
        array3[ second ] = hold;
    }

} // fim da classe BubbleSort