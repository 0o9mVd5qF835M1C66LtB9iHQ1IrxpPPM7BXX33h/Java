// Resolucao do exericico 7.22 do livro de Java

// Pacote que o contem
package finalles;

// Pacotes de extensao de Java
import javax.swing.JOptionPane;

public class Finalle003 {
    
    public static void main( String args[] )
    {
        // Declaracao de variaveis
        int board[][] = new int[8][8], horizontal[] = { 2, 1, -1, -2, -2 , -1, 1, 2 }, vertical[] = { -1, -2, -2, -1, 1, 2, 2, 1 },
            accessibility[][] = { { 2,3,4,4,4,4,3,2 }, { 3,4,6,6,6,6,4,3 }, { 4,6,8,8,8,8,6,4 },  { 4,6,8,8,8,8,6,4 }, { 4,6,8,8,8,8,6,4 }, { 4,6,8,8,8,8,6,4 }, 
            { 1, 3, 4,6,6,6,6,4,3 }, { 2,3,4,4,4,4,3,2 } }, osMelhoresMoveNumber[] = new int[ 7 ], currentRow = 0, currentColumn = 0, moveNumber, movimentos = 64, melhorMoveNumber, menorNumeroDaAcessibilidade = 0, currentRowAux, currentColumnAux, passeiosRealizados = 0, currentRowAux2 = 0, currentColumnAux2 = 0, auxComoContador, auxComoContador2;
        String output = "";
        boolean teste;

        // Inicio do for dos passeios
        for ( int passeios = 1; passeios <= 64; passeios++ ) {
            movimentos = 0;

            // Inicia todos os elemento do array board como ZERO
            for ( int contadorA = 0; contadorA < board.length; contadorA++ )
                for  ( int contadorB = 0; contadorB < board[ contadorA ].length; contadorB++ )
                    board[ contadorA ][ contadorB ] = 0;

            // Fara com que o computador realiza ate no maximo 64 movimentos, caso nao haja uma interrupcao.
            for ( int contador = 0; contador < 64; contador++ ) {
                teste = true;
                melhorMoveNumber = -1;
                auxComoContador = 0;
                auxComoContador2 = 0;
                
                // for que testa todas as possibilidades do moveNumber
                for ( moveNumber = 0; moveNumber <= 7; moveNumber++ ) {

                    currentRowAux = currentRow + vertical[ moveNumber ];
                    currentColumnAux = currentColumn + horizontal[ moveNumber ];

                    if ( testeSeDeveContinuar( currentRowAux, currentColumnAux, board ) )
                        continue;  // Esse if teste se o numero passa dos limites do tabuleiro (array bidimensional 8X8 chamada board) e analisa se a posicao ja foi visitado, em caso verdadeiro, ele voltara para o inicio

                    if ( teste ) {  // Esse if funciona somente uma vez, que e quando pela primeira vez o moveNumber passou em todos os testes.
                        melhorMoveNumber = moveNumber;
                        menorNumeroDaAcessibilidade = accessibility[ currentRowAux ][ currentColumnAux ];
                        teste = false;

                        osMelhoresMoveNumber[ auxComoContador ] = melhorMoveNumber;
                    } else if ( accessibility[ currentRowAux ][ currentColumnAux ] <= menorNumeroDaAcessibilidade ) {
                        melhorMoveNumber = moveNumber;
                        menorNumeroDaAcessibilidade = accessibility[ currentRowAux ][ currentColumnAux ];

                        osMelhoresMoveNumber[ auxComoContador ] = melhorMoveNumber;
                        auxComoContador++;  // Auxiliar da posicao do array acima.
                    }  // Esse if fuciona quando no array bidimensional acessibilidade nas posicoes indicadas, o valor contido nele, sera menor que o que foi recebido no if anterior.


                } // fim do for que testa todas as possibilidades.
                movimentos++;
                if ( movimentos == 64 || melhorMoveNumber == -1 )
                    break;
        
                // Esse for sera responsavel para que, somente fique no array unidimensional chamado de "osMelhoresMoveNumber", so fique aqueles que ao relxar as instrucoes do currentRowAux e currentColumnAux, tenha o valor do accessibility igual ao da variavel "menorNumeroDaAcessibilidade".
                for ( contador = 0; contador < auxComoContador; contador++ ) {
                    currentRowAux = currentRow + vertical[ osMelhoresMoveNumber[ contador ] ];
                    currentColumnAux = currentColumn + horizontal[ osMelhoresMoveNumber[ contador ] ];
                    if ( accessibility[ currentRowAux ][ currentColumnAux ] == menorNumeroDaAcessibilidade ) {
                        osMelhoresMoveNumber[ auxComoContador2 ] = osMelhoresMoveNumber[ contador ];
                        auxComoContador2++;
                    } // Caso esse if seja true/verdadeiro o array "osMelhoresMoveNumber" no subscrito da variavel "auxComoContador" receba, por ela mesma, o elemento do subscrito que esta descrito na variavel "contador".

                }   // fim do for que determina a quantidade de valores iguais ao valor da variavel "melhorMoveNumber" atualmente.

                if ( auxComoContador2 >= 2 ) {
                    for ( contador = auxComoContador2; contador < 7; contador++ )  // esse for seta todos os outros valores, que nao sao REALMENTE os melhores (Como testado a cima), como zero.
                        osMelhoresMoveNumber[ contador ] = 0;

                    melhorMoveNumber = retornarAMelhorJogadaPossivel( osMelhoresMoveNumber, board, accessibility, horizontal, vertical, currentRow, currentColumn, menorNumeroDaAcessibilidade ); // A variavel "melhorMoveNumber" recebe de fato a melhor jogada, em caso de empates, possivel. 
                } // Esse if so acontece, se existiu mais de um valor com o numero de acessibilidade iguais.


                currentRow += vertical[ melhorMoveNumber ];
                currentColumn += horizontal[ melhorMoveNumber ];           

                board[ currentRow ][ currentColumn ] = 2;

                output = "O cavalo e representado pelo valor 2\n\n";

                // Esse for aninhado ira fazer com o que output vai mostre o estado atual do tabuleiro
                for ( int contadorA = 0; contadorA < board.length; contadorA++ ) {
                    for  ( int contadorB = 0; contadorB < board[ contadorA ].length; contadorB++ )
                        output += board[ contadorA ][ contadorB ] + " ";
                    output += "\n";
                } 

                board[ currentRow ][ currentColumn ] = 1;  // Definira novamente a posicao na qual o cavalo foi para 1.

                JOptionPane.showMessageDialog( null, output );  // Esse JOptionPane mostra-ra como o estado daquele momento do tabuleiro.
            } // fim do for ( contador = 1 )

            teste = true;
            for ( int contadorA = 0; contadorA < board.length; contadorA++ ) {
                for  ( int contadorB = 0; contadorB < board[ contadorA ].length; contadorB++ )
                    if ( board[ contadorA ][ contadorB ] == 0 ) {
                        teste = false;
                        break;
                    }
                if ( teste == false )
                    break;
            } // Esse for vai testar se todos os valores sao 1 e caso seja sera contalizado +1 na variavel passeiosRealizados

            if ( teste ) {
                JOptionPane.showMessageDialog( null, "Olha que maravilha! todos os movimentos foram realizados comecando na determinada posicao." );
                passeiosRealizados++; 
            }  // No caso do for anterior nao ter encontrado nenhum zero em nenhuma posicao do array bidimensional board, ele aumentara a quantidade de passeiosRealizados e, dera uma mensagem falando que foi um sucesso.

            JOptionPane.showMessageDialog( null, "Foram realizados " + movimentos + " movimentos!" ); // Mostra na tela a quantidade de movimentos realizados.

            // Faz com que o cavalo faca passeios em lugares diferentes.
            if ( passeios % 8 == 0 ) { 
                currentRow = ++currentRowAux2;
                currentColumn = 0;
            } else {
                currentRow = 0;
                currentColumn = ++currentColumnAux2;
            }
            System.out.println( "currentRow: " + currentRow + "\ncurrentRowAux2: " + currentRowAux2 + "\ncurrentColumn: " + currentColumn + "\ncurrentColumnAux2: " + currentColumnAux2 );
        
        } // fim do for dos passeios

        // Resultado Final
        JOptionPane.showMessageDialog( null, "Foram realizados " + passeiosRealizados );    // Ira mostrar na tela a quantidade de passeios completos que foi realizado

        System.exit( 0 );   // termina o aplicativo de Java

    } // fim do metodo main

    public static int retornarAMelhorJogadaPossivel( int osMelhoresMoveNumber[], int board[][], int accessibility[][], int horizontal[], int vertical[], int currentRow, int currentColumn, int menorNumeroDaAcessibilidade ) {
        int melhorMoveNumber = 0, currentRowAux = currentRow, currentColumnAux = currentColumn, currentRowAux2, currentColumnAux2;
        boolean teste = true;

        for ( int contador = 0; contador < osMelhoresMoveNumber.length; contador++ ) {
            if ( osMelhoresMoveNumber[ contador ] == 0 )
                break;  // Caso um dos valores passado seja igual a zero, significa que nao houve mais valores com a acessbilidade igual, ou seja, nao e preciso continuar.

                currentRowAux = currentRow + vertical[ osMelhoresMoveNumber[ contador ] ];
                currentColumnAux = currentColumn + horizontal[ osMelhoresMoveNumber[ contador ] ];

                for ( int moveNumber = 0; moveNumber <= 7; moveNumber++ ) {

                    currentRowAux2 = currentRowAux + vertical[ moveNumber ];
                    currentColumnAux2 = currentColumnAux + horizontal[ moveNumber ];

                    if ( testeSeDeveContinuar ( currentRowAux2, currentColumnAux2, board ) )
                        continue;  // Esse if teste se o numero passa dos limites do tabuleiro (array bidimensional 8X8 chamada board) e analisa se a posicao ja foi visitado, em caso verdadeiro, ele voltara para o inicio

                    if ( teste ) {
                        melhorMoveNumber = osMelhoresMoveNumber[ contador ];
                        menorNumeroDaAcessibilidade = accessibility[ currentRowAux2 ][ currentColumnAux2 ];
                        teste = false;
                    } else if ( accessibility[ currentRowAux2 ][ currentColumnAux2 ] < menorNumeroDaAcessibilidade ) {
                        menorNumeroDaAcessibilidade = accessibility[ currentRowAux2 ][ currentColumnAux2 ];
                        melhorMoveNumber = osMelhoresMoveNumber[ contador ];

                        if ( osMelhoresMoveNumber[ contador ] != melhorMoveNumber )
                            melhorMoveNumber = osMelhoresMoveNumber[ contador ];
                    }

                } // fim do for que testa todas as possibilidades. 

        } // fim do for, que recebe todos os valores do array unidimensional "osMelhoresMoveNumber".

        return melhorMoveNumber;

    } // fim do metodo --> int retornarAMelhorJogadaPossivel( int[], int[][], int[][], int[], int, int )


    public static boolean testeSeDeveContinuar( int currentRowAux, int currentColumnAux, int board[][] ) {
        boolean teste = false;

        if ( ( ( currentRowAux < 0  || currentRowAux > 7 ) || ( currentColumnAux < 0 || currentColumnAux > 7 ) ) || ( board[ currentRowAux ][ currentColumnAux ] != 0 ) )
            teste = true;

        return teste;

    } // fim do metodo --> boolean testeSeDeveContinuar( int, int, int[][] )


} // fim da classe Finalle003