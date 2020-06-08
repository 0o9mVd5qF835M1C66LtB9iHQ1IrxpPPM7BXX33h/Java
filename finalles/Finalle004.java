// Resoluca do exercicio 7.23 do livro de Java

// Pacotes de extensao de Java
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Finalle004 {
    
    // o metodo main inicia o aplicativo de java
    public static void main( String args[] )
    {
        // Declaracao de variaveis
        JTextArea outputArea = new JTextArea( 25, 30 );
        JScrollPane scroller = new JScrollPane( outputArea );
        String output = "", valoresSetados = "", tabelaDosMovimentos = "Posicao\tElemento\n";
        int board[][] = new int[ 8 ][ 8 ], vertical[] = { -1, -2, -2, -1, 1, 2, 2, 1 }, horizontal[] = { 2, 1, -1, -2, -2 , -1, 1, 2 }, currentRow = 0, currentRowAux, currentColumn = 0, currentColumnAux, moveNumber, 
            movimentosRealizados, aux = 1;
        
        // Testa todos os valores, e aceitara o primeiro possivel.
        while ( true ) {
            movimentosRealizados = 0;   // Reseta a variavel "movimentosRealizados" como zero, toda vez que um passeio seja terminado.

            // Monta o output com o tabuleiro feito, iniciando tudo como zero.
            for ( int row = 0; row < board.length; row++ ) 
                for ( int column = 0; column < board[ row ].length; column++ )
                    board[ row ][ column ] = 0;

            // Faz com que os movimentos no total se possa realizar 64 movimentos (O maximo de movimentos possiveis que o cavalo pode fazer, nese caso).
            for ( int movimentos = 0; movimentos < 64; movimentos++ ) {

                while ( true ) {
                    if ( valoresSetados.length() >= 15 ) {
                        moveNumber = -1;
                        break;
                    } // No caso de todos os valores ja tiverem sidos testados, e ainda sim, nao conseguiu um movimento valido, significa que ele se encuralou, e ira parar esse passeio.

                    moveNumber = (int) ( Math.random() * 8 );   // Seta um valor aleatorio, como uma escolha de movimento.

                    // testa se o valor gerado ja nao foi gerado antes, vendo se ele esta na string valoresSetados, em caso positivo ele continua com o while do inicio, em caso de negativo, ele sera adicionado na string valoresSetados.
                    if ( valoresSetados.contains( Integer.toString( moveNumber ) ) )
                        continue;
                    else
                        valoresSetados += Integer.toString( moveNumber ) + " ";

                    // Seta previamente a posicao, para depois descobrir se ele nao passa do tabuleiro, ou que ele nao va para um lugar ja visitado.
                    currentRowAux = currentRow + vertical[ moveNumber ];
                    currentColumnAux = currentColumn + horizontal[ moveNumber ];

                    // Testa se o valor escolhido aleatoriamente nao passa do tabuleiro, ou que ele nao va para um lugar ja visitado.
                    if ( ( ( currentRowAux < 0  || currentRowAux > 7 ) || ( currentColumnAux < 0 || currentColumnAux > 7 ) ) || ( board[ currentRowAux ][ currentColumnAux ] == 1 ) )
                        continue;

                    // Muda o currentRow e o currentColumn para os seus auxiliares, no caso de ele passar nos requisitos.
                    currentRow = currentRowAux;
                    currentColumn = currentColumnAux;

                    break; // no caso de ter chegado ate aqui, ele para o while ( true ).

                } // fim do teste dos movimentos.

                valoresSetados = "";

                if ( moveNumber == -1 )
                    break;  // Caso nao se tenha achado um valor valido, ele ira parar o for dos movimentos, e iniciara um novo passeio.

                
                movimentosRealizados++; // Adiciona mais um na variavel "movimentosRealizados" a cada movimento realizado, ou seja, no fim do for dos movimentos, e caso o "moveNumber" nao seja igual a -1.
                board[ currentRow ][ currentColumn ] = 1; // Seta a posicao que o cavlao foi como 1, para que quando for realizado outro movimento, ja fique setado, ate o fim do atual passeio como 1.

            } // fim do for dos movimentos
            
            // Seta a posicao inicial do cavalo sempre na mesma no final dos movimentos, assim, fazendo com que sempre ele inicie no mesmo lugar que iniciou.
            board[ currentRow ][ currentColumn ] = 2;  // Seta na ultima posicao, onde esta o cavalo, representado como 2.
            currentRow = 0;
            currentColumn = 0; 

            if ( movimentosRealizados >= 64 ) {

                // Seta o output com as posicoes ja visitadas e a posicao atual do cavalo.
                for ( int row = 0; row < board.length; row++ ) {
                    for ( int column = 0; column < board[ row ].length; column++ )
                        output += board[ row ][ column ] + " ";
                    output += "\n";
                }

                outputArea.setText( output );

                JOptionPane.showMessageDialog( null, outputArea, "Board", JOptionPane.INFORMATION_MESSAGE );
                if ( movimentosRealizados >= 64 )
                    break;

                output = "";

            } // No caso de a variaveel "movimentosRealizados" estar com o valor 57, a variavel ira imprimir o tabuleiro mostrando o estado atual do proprio.


            tabelaDosMovimentos += aux + "\t" + movimentosRealizados + "\n";
            aux++; // Contador que serve apenas para organizar o numero da string a cima.

        } // fim do while dos passeios
 
        outputArea.setText( tabelaDosMovimentos );
        JOptionPane.showMessageDialog( null, scroller, "Table of Moves", JOptionPane.INFORMATION_MESSAGE );
        
        System.exit( 0 );

    } // fim do metodo main

}  // fim da classe Finalle004