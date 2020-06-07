// Resolucao do exercicio 7.20 do livro de Java

// Pacote no qual essa classe pertence
package finalles;

// Classes de extensoes de Java
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Finalle007 {
    
    // o metodo main inicia o aplicativo de Java
    public static void main( String args[] )
    {
        // Declaracoes de variaveis
        JTextArea outputArea = new JTextArea( 15,25 );
        JScrollPane scroller = new JScrollPane( outputArea ); 

        int sales[][] = new int[ 4 ][ 5 ], vendedor, produto, row, column;
        String output = "";

        for ( vendedor = 0; vendedor < 4; vendedor++ ) 
            for ( produto = 0; produto < 5; produto++ )
                sales[ vendedor ][ produto ] = Integer.parseInt( JOptionPane.showInputDialog( null, "Digite o total adquirido pelo produto numero " + produto + " em reais" ) );


        for ( row = 0; row < sales.length; row++ ) {
            output += "Num. do vendedor: " + row + "\n";

            for( column = 0; column < sales[ row ].length; column++ )
                output += "Total de venda do produto " + column + ": R$" + sales[ row ][ column ] + "\n";
            output += "\n";
        }

        outputArea.setText( output );
        JOptionPane.showMessageDialog( null, scroller );
        System.exit( 0 );

    } // fim do metodo main

} // fim da classe Finalle008