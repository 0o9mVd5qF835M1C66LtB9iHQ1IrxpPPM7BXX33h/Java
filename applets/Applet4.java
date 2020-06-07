// Fig. 3.12: AdditionApplet.java
// Adicionando dois números de ponto flutuante

package applets;

// Pacotes do núcleo de Java
import java.awt.Graphics;   // importa a classe Graphics

// Pacotes de extensão de Java
import javax.swing.*;   // importa o pacote javax.swing

public class Applet4 extends JApplet {
    double sum; // soma dos valores inseridos pelo usuário

    // inicializa o applet obtendo valores do usuario
    public void init()
    {
        String firstNumber;     // primeiro string inserido pelo usuário.
        String secondNumber;    // segundo string inserido pelo usuário.
        double number1;         // primeiro número a adicionar.
        double number2;         // segundo número a adicionar.

        // obtém o primeiro número do usuário
        firstNumber = JOptionPane.showInputDialog(
            "Enter first floating-point value" );
        
        // obtém o segundo número do usuário
        secondNumber = JOptionPane.showInputDialog(
            "Enter second floating-point value" );

        // converte os números do tipo String para o tipo double
        number1 = Double.parseDouble( firstNumber );
        number2 = Double.parseDouble( secondNumber );
        
        // adiciona números
        sum = number1 + number2;
    }

    // desenha os resultados em um retângulo no fundo do applet
    public void paint( Graphics g )
    {
        // chama a versão do método paint herdada
        super.paint( g );

        // desenhao o retângulo começando em (15, 10) que tem 270
        // pixels de largura e 20 pixels de altura
        g.drawRect( 15, 10, 270, 20 );
        // desenha os resultados como um string em (25, 25)
        g.drawString( "The sum is " + sum, 25, 25 );

    } // fim do método paint

} // fimda classe AdditionApplet