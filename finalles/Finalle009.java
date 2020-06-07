// Resolucao do exercicio 7.21 do livro de Java

// Pacote no qual ele pertence
package finalles;

// Pacotes de extensao de Java
import javax.swing.*;

public class Finalle009 {

    public static void main( String args[] )
    {
        // Declaracoes de variaveis
        JTextArea outputArea = new JTextArea( 15,40 );
        JTextArea areaDoArray = new JTextArea( 5, 10 );
        JScrollPane scroller = new JScrollPane( outputArea );
        int floor[][] = new int[ 20 ][ 20 ], comandoDoUsuario = -1, quantidadeDeMovimentos = 0;
        String idiomas = "\nPT-BR\nEN-US";
        String idiomaDesejado = "Null";
        String comandos = "";

        while ( idiomas.contains( idiomaDesejado ) == false )
            idiomaDesejado = JOptionPane.showInputDialog( null, "Escolha o idioma desejado" + idiomas ).toUpperCase();

        if ( idiomaDesejado.equals( "PT-BR" ) ) {
            comandos = "---------------------------------------\nComando\tSignificado\n---------------------------------------\n1\tCaneta para cima.\n2\tCaneta para baixo.\n3\tVire para a direita.\n4\tVire para a esquerda.\n5,10\tAvance 10 espacos (ou um numero diferente de 10).\n6\tImprima o array.\n9\tFim (sentinela).\n";
        } else if ( idiomaDesejado.equals( "EN-US" ) ) {
            comandos ="---------------------------------------\nCommands\tMeanings\n---------------------------------------\n1\tPen up.\n2\tPen down.\n3\tTurn right.\n4\tTurn left.\n5,10\tIt gonna walks ten steps (or a number other than ten).\n6\tPrint the array.\n9\tEnd (sentinela).\n";
        }

        // Estado inicial da Tartaruga
        String estadoDaTartaruga = "";
        String estadoAtualDoPiso;
        int posicaoDaTartarugaNaLinhaENaColunaConsecutivos[] = { 0, 0 };
        int estadoDaCaneta = 1;
        char direcaoDaTartaruga = 'S';

        inicializarArrayBidimensionalComUmNumeroDesejado( floor, 0 );

        while ( comandoDoUsuario != 9 )
        {
            if ( idiomaDesejado.equals( "PT-BR" ) ) {
                estadoDaTartaruga = "\n***\nStatus atual da tartaruga\n***\nLinha atual: " + posicaoDaTartarugaNaLinhaENaColunaConsecutivos[0] + "\nColuna atual: " + 
                posicaoDaTartarugaNaLinhaENaColunaConsecutivos[1] + "\nEstado da caneta: " + estadoDaCaneta + "\nDirecao da Tartaruga: " + direcaoDaTartaruga;
            } else if ( idiomaDesejado.equals( "EN-US" ) ) {
                estadoDaTartaruga = "\n***\nTurtle's current status\n***\nCurrent row: " + posicaoDaTartarugaNaLinhaENaColunaConsecutivos[0] + "\nCurrent column: " + 
                posicaoDaTartarugaNaLinhaENaColunaConsecutivos[1] + "\nPen status: " + estadoDaCaneta + "\nTurtle's direction: " + direcaoDaTartaruga; 
            }

            outputArea.setText( comandos + estadoDaTartaruga );

            comandoDoUsuario = Integer.parseInt( JOptionPane.showInputDialog( null, scroller ) );

            if ( comandoDoUsuario == 1 || comandoDoUsuario == 2 ) {
                estadoDaCaneta = comandoDoUsuario;
                
            } else if ( comandoDoUsuario == 3 || comandoDoUsuario == 4 ) {
                direcaoDaTartaruga = modificarADirecaoDaTartaruga( direcaoDaTartaruga, comandoDoUsuario, idiomaDesejado );
                    
            } else if ( comandoDoUsuario == 5 ) {
                if ( idiomaDesejado.equals( "PT-BR" ) )
                    quantidadeDeMovimentos = Integer.parseInt( JOptionPane.showInputDialog( null, "Digite a quantidade de movimentos que voce desejar" ) );
                else if ( idiomaDesejado.equals( "EN-US" ) )
                    quantidadeDeMovimentos = Integer.parseInt( JOptionPane.showInputDialog( null, "Enter the amount of moves you want" ) );

                modificarAPosicaoDaTartaruga( floor, posicaoDaTartarugaNaLinhaENaColunaConsecutivos, quantidadeDeMovimentos, direcaoDaTartaruga, estadoDaCaneta, idiomaDesejado );

            } else if ( comandoDoUsuario == 6 ) {
                estadoAtualDoPiso = imprimirUmArrayBidimensionalInteiro( floor );
                areaDoArray.setText( estadoAtualDoPiso );
                JOptionPane.showMessageDialog( null, areaDoArray );
            }

        } // fim do laco das acoes da tartaruga. 

        System.exit( 0 );

    } // fim do metodo main

    public static void inicializarArrayBidimensionalComUmNumeroDesejado( int array2[][], int valor )
    {
        for ( int row = 0; row < array2.length; row++ )
            for ( int column = 0; column < array2[ row ].length; column++ )
                array2[ row ][ column ] = valor;

    } // fim do metodo inicializarArrayComONumeroDesejado

    public static String imprimirUmArrayBidimensionalInteiro( int array3[][] )
    {
        String output = "";

        for ( int row = 0; row < array3.length; row++ ) {
            for ( int column = 0; column < array3[ row ].length; column++ ) {
                if ( array3[ row ][ column ] == 0 )
                    output += " ";
                else if ( array3[ row ][ column ] == 1 )
                    output += ".";
            }
            output += "\n";
        }

        return output;
        
    } // fim do metodo imprimirUmArrayBidimensionalInteiro

    public static void modificarAPosicaoDaTartaruga( int array4[][], int posicaoDaTartarugaNaLinhaENaColunaConsecutivos[], int quantidadeDeMovimentos, char direcaoDaTartaruga , int estadoDaCaneta, String idiomaDesejado )
    {
        if ( estadoDaCaneta == 2 )
            inserirUmNumeroEmUmArrayBidimensional( array4, posicaoDaTartarugaNaLinhaENaColunaConsecutivos[0], posicaoDaTartarugaNaLinhaENaColunaConsecutivos[1], 1 );   

            for ( int contador = 0; contador < quantidadeDeMovimentos; contador++ ) {

                if ( testarJogada( posicaoDaTartarugaNaLinhaENaColunaConsecutivos, direcaoDaTartaruga ) == false ) {
                    if ( idiomaDesejado.equals( "PT-BR" ) )
                        JOptionPane.showMessageDialog( null, "A Tartaruga nao pode passar do limite (20x20)" );
                    else if ( idiomaDesejado.equals( "EN-US" ) )
                        JOptionPane.showMessageDialog( null, "The turtle can't cross the limit (20x20)" );

                    break;
                }


                if ( direcaoDaTartaruga == 'N' ) 
                    posicaoDaTartarugaNaLinhaENaColunaConsecutivos[0]--;

                else if ( direcaoDaTartaruga == 'L' || direcaoDaTartaruga == 'E' )
                    posicaoDaTartarugaNaLinhaENaColunaConsecutivos[1]++;

                else if ( direcaoDaTartaruga == 'S' ) 
                    posicaoDaTartarugaNaLinhaENaColunaConsecutivos[0]++;
                
                else if ( direcaoDaTartaruga == 'O' || direcaoDaTartaruga == 'W' ) 
                    posicaoDaTartarugaNaLinhaENaColunaConsecutivos[1]--;

                if ( estadoDaCaneta == 2 )
                    inserirUmNumeroEmUmArrayBidimensional( array4, posicaoDaTartarugaNaLinhaENaColunaConsecutivos[0], posicaoDaTartarugaNaLinhaENaColunaConsecutivos[1], 1 );
            }

    } // fim do metodo modificarAPosicaoDaTartaruga

    public static void inserirUmNumeroEmUmArrayBidimensional( int array5[][], int linha, int coluna, int elemento )
    {
            array5[ linha ][ coluna ] = elemento;
    } // fim do metodo inserirNumeroEmUmArrayBidimensional

    public static boolean testarJogada( int posicaoDaTartarugaNaLinhaENaColunaConsecutivos[], char direcaoDaTartaruga )
    {
        if ( direcaoDaTartaruga == 'N' ) {
            if ( posicaoDaTartarugaNaLinhaENaColunaConsecutivos[ 0 ] == 0 )
                return false;
        } else if ( direcaoDaTartaruga == 'L' || direcaoDaTartaruga == 'E' ) {
            if ( posicaoDaTartarugaNaLinhaENaColunaConsecutivos[ 1 ] == 19 )    
                return false;
        } else if ( direcaoDaTartaruga == 'S' ) {
            if ( posicaoDaTartarugaNaLinhaENaColunaConsecutivos[ 0 ] == 19 )
                return false;
        } else if ( direcaoDaTartaruga == 'O' || direcaoDaTartaruga == 'W' ) {
            if ( posicaoDaTartarugaNaLinhaENaColunaConsecutivos[ 1 ] == 0 )
                return false;
        }

        return true;

    } // fim do metodo testarJogada

    public static char modificarADirecaoDaTartaruga( char direcaoDaTartaruga, int comandoDoUsuario, String idiomaDesejado )
    {
        if ( comandoDoUsuario == 3 ) {
            if ( direcaoDaTartaruga == 'N' ) {
                if ( idiomaDesejado.equals( "PT-BR" ) )
                    direcaoDaTartaruga = 'L';
                else if ( idiomaDesejado.equals( "EN-US" ) )
                    direcaoDaTartaruga = 'E';

            } else if ( direcaoDaTartaruga == 'L' || direcaoDaTartaruga == 'E' ) {
                direcaoDaTartaruga = 'S';

            } else if ( direcaoDaTartaruga == 'S') {
                if ( idiomaDesejado.equals( "PT-BR" ) )
                    direcaoDaTartaruga = 'O';
                else if ( idiomaDesejado.equals( "EN-US" ) )
                    direcaoDaTartaruga = 'W';

            } else if ( direcaoDaTartaruga == 'O' || direcaoDaTartaruga == 'W' ) {
                direcaoDaTartaruga = 'N';
            }

        } else if ( comandoDoUsuario == 4 ) {
        
            if ( direcaoDaTartaruga == 'N' ) {
                if ( idiomaDesejado.equals( "PT-BR" ) )
                    direcaoDaTartaruga = 'O';
                else if ( idiomaDesejado.equals( "EN-US" ) )
                    direcaoDaTartaruga = 'W';

            } else if ( direcaoDaTartaruga == 'O' || direcaoDaTartaruga == 'W' ) {
                direcaoDaTartaruga = 'S';

            } else if ( direcaoDaTartaruga == 'S' ) {
                if ( idiomaDesejado.equals( "PT-BR" ) )
                    direcaoDaTartaruga  = 'L';
                else if ( idiomaDesejado.equals( "EN-US" ) )
                    direcaoDaTartaruga = 'E';

            } else if ( direcaoDaTartaruga == 'L' || direcaoDaTartaruga == 'E' )
                direcaoDaTartaruga = 'N';

        }
        
        return direcaoDaTartaruga;

    } // fim do metodo modificarDirecaoDaTartaruga

} // fim da classe Finalle009