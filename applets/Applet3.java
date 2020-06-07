// Fig. 3.10: Welcomelines.java
// Exibindo texto e linhas

package applets;

// Pacotes do núcleo de Java
import java.awt.Graphics;   // importa a classe Graphics

// Pacotes de extensão de Java
import javax.swing.JApplet; // importa a classe JApplet

public class Applet3 extends JApplet {

    // desenha linhas e um string no fundo do applet
    public void paint( Graphics g )
    {
    // chama a versão do método paint herdada
    super.paint( g );

        // desenha linha horizontal de (15, 10) até (210, 10)
        g.drawLine( 15, 10, 210, 10 );

        // desenha linha horizontal de (15, 30) até (210, 30)
        g.drawLine( 15, 30, 210, 30 );

        // desenha String entre as linhas, na posição (25, 25)
        g.drawString( "Welcome to Java Programaing!", 25, 25 );

    } // fim do método paint

} // fim da classe WelcomeLines