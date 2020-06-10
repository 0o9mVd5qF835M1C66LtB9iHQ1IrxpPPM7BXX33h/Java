// Resolucao do exercicio 7.27 do livro de Java

// Pacotes de extensao de Java
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Finalle002 {

    // o metodo main inicia o aplicativo de Java
    public static void main( String args[] )
    {
        // Declaracao de variaveis
        JTextArea outputArea = new JTextArea( 5,10 );
        JScrollPane scroller = new JScrollPane( outputArea );
        boolean primos[] = new boolean[ 1_000 ];

        for ( int contador = 2; contador < primos.length; contador++ )
            primos[ contador ] = true;

        for ( int contador = 2; contador < primos.length; contador++ ) 
            if ( primos[ contador ] )
                for ( int contadorB = contador + 1; contadorB < primos.length; contadorB++ )
                    if ( contadorB % contador == 0 )
                        primos[ contadorB ] = false;

        for ( int contador = 2; contador < primos.length; contador++ )
            if ( primos[ contador ] )
                outputArea.append( "Is " + contador + " a prime number? " + primos[ contador ] + "\n" );

        // Resultado final
        JOptionPane.showMessageDialog( null, scroller );

        System.exit( 0 );   // termina o aplicativo de Java
    } // fim o metodo main

} // fim da classe Finalle002