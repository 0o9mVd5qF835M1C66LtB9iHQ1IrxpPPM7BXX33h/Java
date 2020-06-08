// Fig. 7.11: BubbleSort.java
// Classificia os valores de um array em ordem crescente

// Pacote de extenao de Java
import javax.swing.*;

public class BubbleSort {

    public static void main( String args[] )
    {
        JTextArea outputArea = new JTextArea();

        int array[] = { 2,6,4,8,10,12,89,68,45,37 };
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
        // laco  para controlar o numero de passagens
        for ( int pass = 0; pass < array2.length; pass++ ) {

            // laco para controlar o numero de comparacoes
            for ( int element = 0; element < array2.length - 1; element++ ) {

                // compara elementos adjacentes e os troca de lugar se o primeiro elemento for maior que o segundo elemento
                if ( array2[ element ] > array2[ element + 1 ] )
                    swap( array2, element, element + 1 );

            } // fim do laco para controlar comparacoes

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