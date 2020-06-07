// Resolucao do exercicio 7.18 do livro de Java

// Pacote no qual ele pertence
package finalles;

// Classe de extensao de Java
import javax.swing.JOptionPane;

public class Finalle006 {
    
    // o metodo main inicia o aplicativo de Java
    public static void main( String args[] )
    {
        boolean assentos[] = { true, true, true, true, true, true, true, true, true, true }; 
        int numeroDoAssentoReservado, escolhaDoTipoDeAssento;
        
        escolhaDoTipoDeAssento = Integer.parseInt( JOptionPane.showInputDialog( null, "Please type 1 for \"smoking\"\nPlease type 2 for \"nonsmoking\"" ) );

        numeroDoAssentoReservado = fazerReservaDeUmAssentoParaUmDeterminadoTipoDePessoa( assentos, escolhaDoTipoDeAssento );

        if ( numeroDoAssentoReservado == -1 && escolhaDoTipoDeAssento == 1) {
            escolhaDoTipoDeAssento = 
                Integer.parseInt( JOptionPane.showInputDialog( null, "I'm Sorry, but it was not possible to make the assignment for smokers, would you like to have a non-smoking seat? (Type 2 for yes)" ) );

            if ( escolhaDoTipoDeAssento == 2 )
                numeroDoAssentoReservado = fazerReservaDeUmAssentoParaUmDeterminadoTipoDePessoa( assentos, escolhaDoTipoDeAssento );

        } else if ( numeroDoAssentoReservado == -1 && escolhaDoTipoDeAssento == 2 ) {
            escolhaDoTipoDeAssento = 
                Integer.parseInt( JOptionPane.showInputDialog( null, "I'm Sorry, but it was not possible to make the assignment for smokers, would you like to have a non-smoking seat? (Type 1 for yes)" ) );

            if ( escolhaDoTipoDeAssento == 1 )
                numeroDoAssentoReservado = fazerReservaDeUmAssentoParaUmDeterminadoTipoDePessoa( assentos, escolhaDoTipoDeAssento );
        }

        if ( numeroDoAssentoReservado == -1 )
            JOptionPane.showMessageDialog( null, "Next flight leaves in 3 hours." );
        else
            JOptionPane.showMessageDialog( null, "Seat number: " + numeroDoAssentoReservado + "\nSeat type: " + escolhaDoTipoDeAssento );
            
        System.exit( 0 );

    } // fim do metodo main

    public static int fazerReservaDeUmAssentoParaUmDeterminadoTipoDePessoa( boolean assentos[], int tipoDeAssento )
    {
        int numeroDoAssento, numeroDoAssentoReservado = -1;

        if ( tipoDeAssento == 1 )
            for ( numeroDoAssento = 0; numeroDoAssento < 5; numeroDoAssento++ ) {
                if ( assentos[ numeroDoAssento ] == false ) {
                    assentos[ numeroDoAssento ] = true;
                    numeroDoAssentoReservado = numeroDoAssento;
                    break;
                }
            }

        else if ( tipoDeAssento == 2 )
            for ( numeroDoAssento = 5; numeroDoAssento < 10; numeroDoAssento++ )
                if ( assentos[ numeroDoAssento ] == false ) {
                    assentos[ numeroDoAssento ] = true;
                    numeroDoAssentoReservado = numeroDoAssento;
                    break;
                }

        return numeroDoAssentoReservado;

    } // fim da definicao do metodo "fazerReservaUmAssentoParaUmDeterminadoTipoDePessoa"

} // fim da classe Finalle007