// Resolucao do exericicio 7.30 do livro de Java

// Pacote de extensao de Java
import javax.swing.*;

public class Finalle010 {
    
    public static void main( String args[] )
    {
        String palavra = JOptionPane.showInputDialog( null, "Digite uma frase/palavra para descobrir se ela e um palindromo" ).toLowerCase().strip();
        char letras[] = palavra.toCharArray();


        String palavraAoContrario = testPalindrome( letras, letras.length - 1 );

        if ( palavraAoContrario.equals( removerEspacosVazios( letras ) ) )
            JOptionPane.showMessageDialog( null, palavra + " e um palindromo!" );
        else
            JOptionPane.showMessageDialog( null, palavra + " nao e um palindromo! Ele ao contrario fica: " + palavraAoContrario );

        System.exit( 0 );
    } // fim do metodo main

    public static String testPalindrome( char letras[], int tamanho )
    {
        if ( tamanho == 0 )
            return Character.toString( letras[ tamanho ] );
        else {
            String frase = "";
            String letrasNaFrente = testPalindrome( letras, tamanho - 1 );

            if ( letras[ tamanho ] != ' ' )
                return frase += letras[ tamanho ] + letrasNaFrente;
            else
                return letrasNaFrente;
        }

    } // fim do metodo testPalindrome

    public static String removerEspacosVazios( char letras[] )
    {
        String fraseFinal = "";
        for ( char letra : letras ) {
            if ( letra != ' ' )
                fraseFinal += letra;
        }

        return fraseFinal;

    } // fim do metodo removerEspacosVazios

} // fim da classe Finalle010