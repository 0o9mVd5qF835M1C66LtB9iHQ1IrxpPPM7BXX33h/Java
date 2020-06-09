// Resolucao do exercicio 7.17 do livro de Java
// Craps

// Pacote de extensao de Java
import javax.swing.*;

public class Finalle014 {

    public static void main( String args[] )
    {
        // variaveis constantes para status do jogo
        final int WON = 0, LOST = 1, CONTINUE = 2;

        // outras variaveis utilizadas
        boolean firstRoll = true;   // true se for a primeira jogada
        int sumOfDice = 0;          // soma dos dados
        int myPoint = 0;            // pontos se nao ganhar/perder na 1a. jogada
        int gameStatus = CONTINUE;  // o jogo ainda nao acabou
        String outputDosStatus[] = new String[ 4 ];

        // componentes da interface grafica com o usuario
        String die1Area = "", die2Area = "", sumArea = "", pointArea = "";

        // primeiro lancamento dos dados
        while( true ) {
            if ( firstRoll ) {
                sumOfDice = rollDice( die1Area, die2Area, sumArea, outputDosStatus ); // lanca os dados

                switch ( sumOfDice ) {

                    // ganha na primeira jogada
                    case 7: case 11:
                        gameStatus = WON;
                        pointArea = "Point is: ";   // limpa campo de texto da pontuacao
                        break;
                    
                    // perde na primeira jogada
                    case 2: case 3: case 12:
                        gameStatus = LOST;
                        pointArea = "Point is: ";   // limpa campo de texto da pontuacao
                        break;
                    
                    // memoriza os pontos obtido
                    default:
                        gameStatus = CONTINUE;
                        myPoint = sumOfDice;
                        pointArea = "Point is: " + Integer.toString( myPoint );
                        firstRoll = false;
                        break;

                } // fim da estrutura switch

            } // fim do corpo da estrutura if

            // lancamentos subsequentes dos dados
            else {
                sumOfDice = rollDice( die1Area, die2Area, sumArea, outputDosStatus );     // lanca os dados

                // determina estado do jogo
                if ( sumOfDice == myPoint ) // vitoria fazendo o ponto
                    gameStatus = WON;
                else
                    if ( sumOfDice == 7 )   // derrota por jogar 7
                        gameStatus = LOST;
            }

            outputDosStatus[ 3 ] = pointArea;   // Adiciona o point para o array de status para ser mostrada em breve

            // exibe mensagem indicando estado do jogo
            firstRoll = displayMessage( gameStatus, firstRoll, outputDosStatus );
        }

    } // fim do metodo main

    // lanca os dados, calcula soma e exibe resultados
    public static int rollDice( String die1Area, String die2Area, String sumField, String outputDosStatus[] )
    {
        int die1, die2, sum;

        // escolhe valores aleatorios para os dados
        die1 = 1 + (int) ( Math.random() * 6 );
        die2 = 1 + (int) ( Math.random() * 6 );

        sum = die1 + die2;  // soma os valores dos dados

        // exibe resultados
        die1Area = "Die 1: " + Integer.toString( die1 );
        die2Area = "Die 2: " + Integer.toString( die2 );
        sumField = "Sum is: " + Integer.toString( sum );

        outputDosStatus[ 0 ] = die1Area;
        outputDosStatus[ 1 ] = die2Area;
        outputDosStatus[ 2 ] = sumField;

        return sum; // retorna soma dos dados

    } // fim do metodo rollDice

    // determina o estado do jogo e exibe mensagem apropriada na barra de estado
    public static boolean displayMessage( int gameStatus, boolean firstRoll, String outputDosStatus[] )
    {
        JTextArea output = new JTextArea( 5, 5 );

        output.setText( outputDosStatus[ 0 ] + "\t" + outputDosStatus[ 1 ] + "\n" + outputDosStatus[ 2 ] + "\t" + outputDosStatus[ 3 ] );
        output.setEditable( false );
        
        // jogo deve continuar
        if ( gameStatus == 2 ) {
            output.append( "\n\n\tRoll again." );
            JOptionPane.showMessageDialog( null, output );
            return false;
        }
        // jogo ganho ou perdido
        else {

            if ( gameStatus == 0 ) {
                output.append( "\n\n\tPlayer wins. " + "Click OK to play again." );
                JOptionPane.showMessageDialog( null, output );
            } else {
                output.append( "\n\n\tPlayer loses. " + "Click OK to play again." );
                JOptionPane.showMessageDialog( null,  output );
            }
            
            // proxima jogada e a primeira de um novo jogo
            return true;
        }

    } // fim do metodo displayMEssahe


} // fim da classe Finalle014